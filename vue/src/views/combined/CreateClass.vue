<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex justify-content-center">
          <div class="main d-flex flex-column">
            <h2 class="align-self-start">Skapa ny klass</h2>
            <div class="content-line rounded" />

            <form @submit.prevent="createClass">
              <div class="mt-5 d-flex justify-content-center">
                <select class="form-control" id="education" name="education" style="width: 25%">
                  <option value disabled selected>Utbildning</option>
                  <option
                    :value="education.id"
                    v-for="education in getEducations"
                    :key="education.id"
                  >{{education.name}}</option>
                </select>
                <select class="form-control" id="manager" name="manager" style="width: 25%">
                  <option value disabled selected>Utbildningsledare</option>
                  <option
                    :value="ecPers.id"
                    v-for="ecPers in getEcPersonnel"
                    :key="ecPers.id"
                  >{{ecPers.userec.first_name}} {{ecPers.userec.last_name}}</option>
                </select>
              </div>
              <div class="mt-4 d-flex justify-content-center">
                <input
                  class="form-control"
                  type="text"
                  placeholder="Klassnamn"
                  id="class-name"
                  style="width: 40%"
                />
              </div>
              <div class="button-create d-flex justify-content-end">
                <button type="submit" class="button button-primary" style="margin-top: 10%;"> <span> Skapa </span> </button>
              </div>
            </form>
            <div class="alert alert-secondary mt-5" v-show="trigger" role="alert">
            {{ message }}
          </div>
          </div>
          
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CombinedSidebar from "@/components/CombinedSidebar.vue";

export default {
  created() {
    this.$store.dispatch("getAllEducations");
    this.$store.dispatch("getEcPersonnel");
  },
   data() {
    return {
      trigger : false,
      message : ""

      };    
  }, 
  components: {
    CombinedSidebar
  },
  computed: {
    getEcPersonnel() {
      return this.$store.state.ecPersonnel;
    },
    getEducations() {
      return this.$store.state.AllEducation;
    }
  },
  methods: {
    async createClass() {
      let newClass = {
        name: document.getElementById("class-name").value,
        education_id: document.getElementById("education").value,
        manager_id: document.getElementById("manager").value
      };

      let response = await fetch("http://localhost:8080/class", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newClass)
      });
      let result = await response.json();
      console.log(result);

      this.trigger = true,
      this.message = "Du har skapat följande uppgifter: 'KlassNamn': " + result.name + "'Ansvarig ID': " + result.manager_id + " 'Utbildning ID:' " + result.education_id;
      
    }
  }
};
</script>