<template>  

  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />   
        </div>   
      <div class="col-9 d-flex">
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
                    v-on:click="showEducationRapport"
                  >{{education.name}}</option>
                </select>
                <select class="form-control mb-2 width-84" id="course">
                  <option value="course">Kurs</option>
                  <option
                    v-for="course in courses"
                    :key="course.id"
                    :value="course"
                    @click="selectedCourse = course"
                    v-on:click="showCourseRapport"
                  >{{course.name}}</option>
                </select>
                <select class="form-control mb-4 width-84" id="class">
                  <option value="class">Klass</option>
                  <option
                    v-for="c in classes"
                    :key="c.id"
                    :value="c"
                    @click="selectedClass = c"
                    v-on:click="showClassRapport"
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
                :fetch="fetchData"
                :fields="json_fields"
                name="rapport.xls"
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
                <vue-bootstrap4-table
                  ref="table"
                  :rows="rows"
                  :columns="columns_kurs"
                  :config="config"
                ></vue-bootstrap4-table>
              </div>
              <download-excel
                class="button button-primary"
                :fetch="fetchData"
                :fields="json_fields_kurs"
                name="rapport.xls"
              >
                <span>Exportera</span>
              </download-excel>
            </div>

            <!-- Class_Rapport -->
            <div class="results-window ml-3" v-if="raport_class">
              <div class="d-flex justify-content-between bg-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Klass Rapport</p>
                </div>
                <div class="d-flex justify-content-end align-items-center">
                  <font-awesome-icon
                    :icon="['fas','plus-circle']"
                    class="align-self-center mr-3 text-cream"
                  />
                </div>
              </div>
              <div class="bg-white container-fluid">
                <vue-bootstrap4-table
                  ref="table"
                  :rows="rows"
                  :columns="columns_class"
                  :config="config"
                ></vue-bootstrap4-table>
              </div>
              <download-excel
                class="button button-primary"
                :fetch="fetchData"
                :fields="json_fields_class"
                name="filename.xls"
              >
                <span>Exportera</span>
              </download-excel>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import VueBootstrap4Table from "vue-bootstrap4-table";
import downloadExcel from "vue-json-excel";
import CombinedSidebar from "@/components/CombinedSidebar"

export default {
  components: {
    CombinedSidebar,
    downloadExcel,
    VueBootstrap4Table
  },
  data() {
    return {
      raport_utbildning: true,
      raport_kurs: false,
      raport_class: false,
      selectedEducation: {},
      selectedClass: {},
      selectedCourse: {},
      listOfAttendance: [],
      courses: [],
      classes: [],
      educations: [],
      data: {
        type: Array,
        required: false,
        default: null
      },
      json_fields: {
        'Förnamn': 'userstudent.first_name',
        'Efternamn': 'userstudent.last_name',
      },

      json_fields_kurs: {
        'Förnamn': 'student.userstudent.first_name',
        'Efternamn': 'student.userstudent.last_name',
        'Datum': 'lecture.date',
        'Present': 'present'
      },
      json_fields_class: {
        'Förnamn': 'student.userstudent.first_name',
        'Efternamn': 'student.userstudent.last_name',
        'Datum': 'lecture.date',
        'Present': 'present'
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
          name: "student.userstudent.first_name"
        },
        {
          label: "Efternamn",
          name: "student.userstudent.last_name"
        },
        {
          label: "Datum",
          name: "lecture.date"
        },
        {
          label: "Present",
          name: "present"
        }
      ],
      // COLUMN_CLASS
      columns_class: [
        {
          label: "Förnamn",
          name: "student.userstudent.first_name"
        },
        {
          label: "Efternamn",
          name: "student.userstudent.last_name"
        },
        {
          label: "Datum",
          name: "lecture.date"
        },
        {
          label: "Present",
          name: "present"
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
        card_title: "Rapport"
      }
    };
  },
  methods: {
    fetchData(){
      return this.listOfAttendance
    },
    showCourseRapport() {
      this.raport_utbildning = false;
      this.raport_class = false;
      this.raport_kurs = true;
      this.listOfAttendance.length = 0;
      this.getCoursesByID();
    },
    showEducationRapport() {
      this.raport_utbildning = true;
      this.raport_class = false;
      this.raport_kurs = false;
      this.listOfAttendance.length = 0;
      this.getStudentEducation();
    },
    showClassRapport() {
      this.raport_utbildning = false;
      this.raport_class = true;
      this.raport_kurs = false;
      this.listOfAttendance.length = 0;
      this.getClassStudents();
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
          this.educations.push(education);
        }
      });
    },
    async getClassStudents() {
      let result = await fetch(
        "http://localhost:8080/attendance/class/" + this.selectedClass.id
      );
      let respons = await result.json();
      this.listOfAttendance.length = 0;

      respons.forEach(respons => {
        if (respons) {
          this.listOfAttendance.push(respons);
        }
      });
    },
    async getCoursesByID() {
      let result = await fetch(
        "http://localhost:8080/attendance/course/" + this.selectedCourse.id
      );
      let respons = await result.json();
      this.listOfAttendance.length = 0;

      respons.forEach(element => {
        if (element) {
          this.listOfAttendance.push(element);
        }
      });
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
  created() {
    this.$store.dispatch("getAllClasses");
    this.setClasses();
    this.$store.dispatch("getAllEducations");
    this.setEducations();
    this.$store.dispatch("getAllCourses");
    this.setCourses();
  }
};
</script>