<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex justify-content-center">
          <div class="main d-flex flex-column">
            <h2 class="align-self-start">Skapa ny utbildning</h2>
            <div class="content-line rounded" />

            <form @submit.prevent="createEducation">
              <div class="mt-5 d-flex justify-content-center">
                <input class="form-control" type="text" style="width: 40%" placeholder="Utbildningsnamn" id="edu-name" />
              </div>

              <div class="mt-4 d-flex justify-content-center">
                <select class="form-control" id="edu-manager" style="width: 40%">
                  <option value disabled selected>Utbildningsledare</option>
                  <option
                    v-for="ecPers in getPersonnel"
                    :key="ecPers.id"
                  >{{ecPers.userec.first_name}}</option>
                </select>
              </div>

              <div class="mt-4 d-flex justify-content-center">
                <select class="form-control" id="edu-city" style="width: 40%">
                  <option value disabled selected>Utbildningsort</option>
                  <option v-for="city in getCities" :key="city.id">{{city.name}}</option>
                </select>
              </div>

              <div class="d-flex justify-content-center">
                <textarea
                  class="form-control width-84"
                  style="resize: none; margin-top: 13%;"
                  type="text"
                  rows="4"
                  placeholder="Beskrivning ..."
                  id="edu-desc"
                />
              </div>
              <div class="button-create mt-4 d-flex justify-content-end">
                <button type="submit" class="button button-primary">
                  <span>Skapa</span>
                </button>
              </div>
            </form>
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
    this.$store.dispatch("getCities");
    this.$store.dispatch("getEcPersonnel");
  },
  computed: {
    getCities() {
      return this.$store.state.cities;
    },
    getPersonnel() {
      return this.$store.state.ecPersonnel;
    }
  },
  components: {
    CombinedSidebar
  },
  methods: {
    async createEducation() {
      let newEducation = {
        name: document.getElementById("edu-name").value,
        description: document.getElementById("edu-desc").value,
        manager_id: document.getElementById("edu-manager").value,
        city_id: document.getElementById("edu-city").value
      };

      let response = await fetch("http://localhost/8080/education", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newEducation)
      });

      let result = await response.json();
      console.log(result);
    }
  }
};
</script>