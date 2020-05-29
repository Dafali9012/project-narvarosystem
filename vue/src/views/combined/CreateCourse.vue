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
            <form>
              <div class="mt-5 d-flex justify-content-center">
                <input
                  class="form-control"
                  type="text"
                  placeholder="Kursnamn"
                  v-model="course.name"
                />
                <input
                  class="form-control"
                  type="number"
                  placeholder="Poäng"
                  v-model="course.point"
                />
              </div>
              <div class="mt-4 d-flex unselectable">
                <label for="from" style="margin-left:9%">Från:</label>
                <label for="to" style="margin-left:39%">Till:</label>
              </div>
              <div class="d-flex justify-content-center">
                <input class="form-control" type="date" id="from" v-model="course.startDate" />
                <input class="form-control" type="date" id="to" v-model="course.endDate" />
              </div>
              <div class="mt-4 d-flex justify-content-center">
                <select
                  class="form-control width-42"
                  id="teacher"
                  name="teacher"
                  v-model="course.edID"
                >
                  <option value>Utbildning</option>
                  <option v-for="education in allEducation" :key="education.edID">{{education.name}}</option>
                </select>
                <select
                  class="form-control width-42"
                  id="teacher"
                  name="teacher"
                  v-model="course.teacherID"
                >
                  <option value>Lärare</option>
                  <option v-for="teacher in allTeachers" :key="teacher.userID">{{teacher.name}}</option>
                </select>
              </div>
              <div class="mt-4 d-flex justify-content-center">
                <input
                  class="form-control width-84"
                  type="text"
                  rows="3"
                  placeholder="Beskrivning"
                  v-model="course.description"
                />
              </div>
              <div class="button-create mt-4 d-flex justify-content-end">
                <button v-on:click="createCourse" type="button" class="button button-primary">
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
  data() {
    return {
      allTeachers: [],
      allEducation: [],
      course: {
        name: "",
        description: "",
        startDate: "",
        endDate: "",
        point: "",
        edID: "",
        teacherID: ""
      }
    };
  },
  components: {
    CombinedSidebar
  },
  computed: {
    getAllTeachers() {
      return this.$store.state.AllUser;
    },
    getAllEducation() {
      return this.$store.state.AllEducation;
    }
  },
  created() {
    this.setAllTeachers();
    this.setEducation();
  },
  methods: {
    setEducation() {
      this.getAllEducation.forEach(education => {
        this.allEducation.push(education);
      });
    },
    setAllTeachers() {
      this.getAllTeachers.forEach(user => {
        if (user.roles[0].roleID == 3) {
          this.allTeachers.push(user);
        }
      });
    },
    setSelectedTeacher() {
      this.allTeachers.forEach(user => {
        if (user.name == this.course.teacherID) {
          this.course.teacherID = user.userID;
        }
      });
    },
    setSelectedEducation() {
      this.allEducation.forEach(education => {
        if (education.name == this.course.edID) {
          this.course.edID = education.edID;
        }
      });
    },
    async createCourse() {
      this.setSelectedTeacher();
      this.setSelectedEducation();
      console.log(this.course);
      let response = await fetch("http://localhost:8080/course", {
        method: "post",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(this.course)
      });
      let result = await response.json();
      console.log(result);
    }
  }
};
</script>