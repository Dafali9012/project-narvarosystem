<template>
  <div class="root d-flex justify-content-center">
    <div class="main d-flex justify-content-center width-84">
      <div class="filter-window">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable my-2">Filtrering</p>
          </div>
        </div>
        <div class="d-flex flex-column align-items-center bg-lightblue text-cream">
          <input class="form-control my-4 width-84" type="text" placeholder="Sök" />

          <select class="form-control mb-2 width-84" id="education">
            <option value="education">Utbildning</option>
            <option
              v-for="education in educations"
              :key="education.id"
              :value="education"
              @click="selectedEducation = education"
            >{{education.name}}</option>
          </select>
          <select class="form-control mb-2 width-84" id="course">
            <option value="course">Kurs</option>
            <option
              v-for="course in courses"
              :key="course.id"
              :value="course"
              @click="selectedCourse = course"
            >{{course.name}}</option>
          </select>
          <select class="form-control mb-4 width-84" id="class">
            <option value="class">Klass</option>
            <option
              v-for="c in classes"
              :key="c.id"
              :value="c"
              @click="selectedClass = c"
              v-on:click="setRaport"
            >{{c.name}}</option>
          </select>
          <label class="align-self-start ml-4" for="from">Från:</label>
          <input class="form-control mb-2 width-84" type="date" id="from" />
          <label class="align-self-start ml-4" for="to">Till:</label>
          <input class="form-control mb-4 width-84" type="date" id="to" />
        </div>
      </div>

          <!-- Utbildning Rapport -->
      <div class="results-window ml-3" v-if="raport_utbildning">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable my-2">Utbildning Rapport</p>
          </div>
          <div class="d-flex justify-content-end align-items-center">
            <font-awesome-icon
              :icon="['fas','plus-circle']"
              class="align-self-center mr-3 text-cream"
            />
          </div>
        </div>
        <div class="bg-white container-fluid">
          <vue-bootstrap4-table ref="table" :rows="rows" :columns="columns" :config="config"></vue-bootstrap4-table>
        </div>
        <download-excel
          class="button button-primary"
          :data="rows"
          :fields="json_fields"
          name="filename.xls"
        >
          <span>Exportera</span>
        </download-excel>
      </div>

      <!-- Kurs Rapport -->
      <div class="results-window ml-3" v-if="raport_kurs">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable my-2">Kurs Rapport</p>
          </div>
          <div class="d-flex justify-content-end align-items-center">
            <font-awesome-icon
              :icon="['fas','plus-circle']"
              class="align-self-center mr-3 text-cream"
            />
          </div>
        </div>
        <div class="bg-white container-fluid">
          <vue-bootstrap4-table ref="table" :rows="rows" :columns="columns_kurs" :config="config"></vue-bootstrap4-table>
        </div>
        <download-excel
          class="button button-primary"
          :data="rows"
          :fields="json_fields"
          name="filename.xls"
        >
          <span>Exportera</span>
        </download-excel>
      </div>

    </div>
    <button v-on:click="log">Click</button>
  </div>
</template>

<script>
import VueBootstrap4Table from "vue-bootstrap4-table";
import downloadExcel from "vue-json-excel";

export default {
  components: {
    downloadExcel,
    VueBootstrap4Table
  },
  data: function() {
    return {
      raport_utbildning: true,
      raport_kurs: false,
      selectedEducation: {},
      selectedClass: {},
      selectedCourse: {},
      listOfAttendance: [],
      courses: [],
      classes: [],
      educations: [],
      json_fields: {
        Namn: "namn",
        Kursnamn: "course",
        Närvaro: "närvaro"
      },

      columns: [
        {
          label: "Förnamn",
          name: "userstudent.first_name"
        },
        {
          label: "Efternamn",
          name: "userstudent.last_name"
        }
      ],
      // COLUMN KURS
      columns_kurs: [
        {
          label: "Förnamn",
          name: "first_name"
        },
        {
          label: "Efternamn",
          name: "last_name"
        }
      ],
      config: {
        checkbox_rows: false,
        rows_selectable: false,
        pagination: false,
        pagination_info: false,
        show_refresh_button: false,
        show_reset_button: false,
        global_search: {
          visibility: false
        },
        card_title: "Mina Kurser"
      }
    };
  },
  methods: {
    setRaport() {
      this.raport_1 = false;
      this.raport_2 = true;
    },
    log() {
      console.log('Courses',this.getCourses);
      console.log('Education',this.getEducations);
      console.log('CLasses',this.getClasses);
    },
    setCourses() {
      this.getCourses.forEach(course => {
        if (course) {
          this.courses.push(course);
        }
      });
    },
    setClasses() {
      this.getClasses.forEach(c => {
        if (c) {
          this.classes.push(c);
        }
      });
    },
    setEducations() {
      this.getEducations.forEach(education => {
        if (education) {
          console.log(education);
          this.educations.push(education);
        }
      });
    },
    async getClassStudents() {
      let result = await fetch(
        "http://localhost:8080/student/class/" + this.selectedClass.id
      );
      let respons = await result.json();
      respons.forEach(respons => {
        if (respons) {
          this.listOfAttendance.push(respons.userstudent);
        }
      });
      console.log(respons);
      console.log("list of attendace ", this.listOfAttendance);
    },
    async getCoursesByID() {
      let result = await fetch(
        "http://localhost:8080/student/class/" + this.selectedClass.id
      );
      let respons = await result.json();
      console.log(respons);
    },
    async getStudentEducation() {
      let result = await fetch(
        "http://localhost:8080/student/education/" + this.selectedEducation.id
      );
      let respons = await result.json();
      this.listOfAttendance.length = 0;
      respons.forEach(element => {
        if (element) {
          this.listOfAttendance.push(element);
        }
      });
      console.log(respons);
    }
  },
  computed: {
    rows: {
      get() {
        return this.listOfAttendance;
      }
    },
    getCourses() {
      return this.$store.state.AllCourse;
    },
    getClasses() {
      return this.$store.state.AllClass;
    },
    getEducations() {
      return this.$store.state.AllEducation;
    }
  },
  async created() {
    await this.$store.dispatch("getAllCourses");
    await this.setCourses();
    await this.$store.dispatch("getAllClasses");
    await this.setClasses();
    await this.$store.dispatch("getAllEducations");
    await this.setEducations();
  }
};
</script>