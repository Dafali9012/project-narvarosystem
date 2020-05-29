<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex justify-content-center">
          <div class="main d-flex flex-column">
            <h2 class="align-self-start">Skapa ny kurs</h2>
            <div class="content-line rounded" />
            <form @submit.prevent="createCourse">
              <div class="mt-5 d-flex justify-content-center">
                <input class="form-control" type="text" placeholder="Kursnamn" />
                <input class="form-control" type="number" placeholder="Poäng" />
              </div>
              <div class="mt-4 d-flex unselectable">
                <label for="from" style="margin-left:9%">Från:</label>
                <label for="to" style="margin-left:39%">Till:</label>
              </div>
              <div class="d-flex justify-content-center">
                <input class="form-control" type="date" id="from" />
                <input class="form-control" type="date" id="to" />
              </div>
              <div class="mt-4 d-flex justify-content-center">
                <select class="form-control width-42" id="teacher" name="teacher">
                  <option
                    :value="education.id"
                    v-for="education in getEducations"
                    :key="education.id"
                  >{{education.name}}</option>
                </select>
                <select class="form-control width-42" id="teacher" name="teacher">
                  <option
                    :value="teacher.id"
                    v-for="teacher in getTeachers"
                    :key="teacher.id"
                  >Lärare</option>
                </select>
              </div>
              <div class="mt-4 d-flex justify-content-center">
                <input class="form-control width-84" type="text" rows="3" placeholder="Beskrivning" />
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
  components: {
    CombinedSidebar
  },
  created() {
    this.$store.dispatch("getAllEducations");
    this.$store.dispatch("getTeachers");
  },
  computed: {
    getTeachers() {
      return this.$store.state.Teachers;
    },
    getEducations() {
      return this.$store.state.AllEducation;
    }
  },

  methods: {
    createCourse() {
      console.log("skapa kurs");
    }
  }
};
</script>