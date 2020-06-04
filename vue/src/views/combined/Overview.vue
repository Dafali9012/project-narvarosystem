<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex justify-content-center">
          <div class="main d-flex flex-column width-84">
            <h2 class="align-self-start">Överblick</h2>
            <div class="content-line rounded mb-5" />

            <div class="d-flex flex-column">
              <div class="d-flex justify-content-between background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Användare</p>
                </div>
              </div>
              <vue-bootstrap4-table :rows="user_rows" :columns="user_columns" :config="user_config" @on-select-row="getUser($event)"></vue-bootstrap4-table>
              <div><strong>Utvald användare: </strong><p>{{selectedUser}}</p></div>
              <button class="button button-primary" v-on:click="deleteUSer"> <span> Radera </span> </button>
            </div>

            <div class="d-flex flex-column mt-5">
              <div class="d-flex justify-content-between background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Roller</p>
                </div>
              </div>
              <vue-bootstrap4-table
                :rows="role_rows"
                :columns="role_columns"
                :config="role_config"
                @on-select-row="getRole($event)"
              ></vue-bootstrap4-table>
            </div>
            <div><strong>Utvald roll: </strong><p>{{selectedRole}}</p></div>
            <button class="button button-primary" v-on:click="deleteRole"> <span> Radera </span> </button> 

            <div class="d-flex flex-column mt-5">
              <div class="d-flex justify-content-between background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Utbildningar</p>
                </div>
              </div>
              <vue-bootstrap4-table :rows="edu_rows" :columns="edu_columns" :config="edu_config" @on-select-row="getEdu($event)"></vue-bootstrap4-table>
            </div>
            <div><strong>Utvald utbildning: </strong><p>{{selectedEdu}}</p></div>
            <button class="button button-primary" v-on:click="deleteEdu"> <span> Radera </span> </button> 
            

            <div class="d-flex flex-column mt-5">
              <div class="d-flex justify-content-between background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Klasser</p>
                </div>
              </div>
              <vue-bootstrap4-table
                :rows="class_rows"
                :columns="class_columns"
                :config="class_config"
                @on-select-row="getClass($event)"
              ></vue-bootstrap4-table>
            </div>
            <div><strong>Utvald klass: </strong><p>{{selectedClass}}</p></div>
            <button class="button button-primary" v-on:click="deleteClass"> <span> Radera </span> </button> 
           

            
            <div class="d-flex flex-column mt-5">
              <div class="d-flex justify-content-between background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Kurser</p>
                </div>
              </div>
              <vue-bootstrap4-table
                :rows="course_rows"
                :columns="course_columns"
                :config="course_config"
                @on-select-row="getCourse($event)"
              ></vue-bootstrap4-table>
            </div>
            <div><strong>Utvald Kurs: </strong><p>{{selectedCourse}}</p></div>
            <button class="button button-primary" v-on:click="deleteCourse"> <span> Radera </span> </button> 
          

          <div class="d-flex flex-column mt-5">
              <div class="d-flex justify-content-between background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Lektioner</p>
                </div>
              </div>
              <vue-bootstrap4-table
                :rows="lec_rows"
                :columns="lec_columns"
                :config="lec_config"
                @on-select-row="getLecture($event)"
              ></vue-bootstrap4-table>
            </div>
            <div><strong>Utvald Kurs: </strong><p>{{selectedLecture}}</p></div>
            <button class="button button-primary" v-on:click="deleteLecture"> <span> Radera </span> </button> 


          </div>
        </div>
        </div>



        
     
    </div>
  </div>
</template>

<script>
import CombinedSidebar from "@/components/CombinedSidebar.vue";
import VueBootstrap4Table from "vue-bootstrap4-table";

export default {
  components: {
    CombinedSidebar,
    VueBootstrap4Table
  },
  data() {
    return {
      selectedUser: "",
      selectedRole: "",
      selectedCourse: "",
      selectedClass: "",
      selectedEdu: "",
      selectedLecture: "",

       user_columns: [
        {
          label: "Förstname",
          name: "first_name",
          sort: true
        },
        {
          label: "Efternamn",
          name: "last_name",
          sort: true
        },
        {
          label: "E-post",
          name: "email" ,              
          sort: true
        },
        {
          label: "Telefon",
          name: "phone_number" ,              
          sort: true
        },
        
        {
          label: "Personnummer",
          name: "ssn",
          sort: true
        },
        {
          label: "Roll",
          name: "role.name",
          sort: true
        }
      ],
      user_config: {
        checkbox_rows: true,        
        pagination: false,
        pagination_info: false,
        show_refresh_button: false,
        show_reset_button: false,
        global_search: {
          placeholder: "Sök",
          visibility: true
        },
       
      },

      role_columns: [
        {
          label: "Namn",
          name: "name",
          sort: true
        },
        {
          label: "Skapa Klass",
          name: "create_class",
          sort: true
        },
        {
          label: "Skapa Konto",
          name: "create_account" ,              
          sort: true
        },
        {
          label: "Skapa Kurs",
          name: "create_course" ,              
          sort: true
        },
        
        {
          label: "Skapa Utbildning",
          name: "create_education",
          sort: true
        },
        {
          label: "Skapa Roll",
          name: "create_role",
          sort: true
        },
        {
          label: "Skapa Lektion",
          name: "create_lecture",
          sort: true
        },
        {
          label: "Se Överblick",
          name: "access_overview",
          sort: true
        },
        {
          label: "Se Klassrum",
          name: "access_classroom",
          sort: true
        },
        {
          label: "Lärare Information",
          name: "access_teacher_info",
          sort: true
        },
        {
          label: "Elev Information",
          name: "access_student_info",
          sort: true
        },
        {
          label: "Lärare Kalendar",
          name: "access_calendar_teacher",
          sort: true
        },
        {
          label: "Elev Kalendar",
          name: "access_calendar_student",
          sort: true
        },
      ],
      role_config: {
        checkbox_rows: true,        
        pagination: false,
        pagination_info: false,
        show_refresh_button: false,
        show_reset_button: false,
        global_search: {
          placeholder: "Sök",
          visibility: true
        },
       
      },

       lec_columns: [
        {
          label: "Lektion",
          name: "id",
          sort: true
        },
        {
          label: "Datum",
          name: "date",
          sort: true
        }, 
        {
          label: "Kurs",
          name: "course.name",
          sort: true
        },     
        
        
      ],
      lec_config: {
        checkbox_rows: true,        
        pagination: false,
        pagination_info: false,
        show_refresh_button: false,
        show_reset_button: false,
        global_search: {
          placeholder: "Sök",
          visibility: true
        },
       
      },


      class_columns: [
        {
          label: "Klass",
          name: "id",
          sort: true
        },
        {
          label: "Namn",
          name: "name",
          sort: true
        },
        {
          label: "Ansvarig Förstnamn",
          name: "classManager.userec.first_name" ,              
          sort: true
        },
        {
          label: "Ansvarig Efternamn",
          name: "classManager.userec.last_name" ,              
          sort: true
        },
        
        {
          label: "Utbildning",
          name: "educationOfClass.name",
          sort: true
        }
      ],
      class_config: {
        checkbox_rows: true,        
        pagination: false,
        pagination_info: false,
        show_refresh_button: false,
        show_reset_button: false,
        global_search: {
          placeholder: "Sök",
          visibility: true
        },
       
      },

      edu_columns: [
        {
          label: "Utbildning",
          name: "name",
          sort: true
        },        
        {
          label: "Beskrivning",
          name: "description",
          sort: false
        },
        {
          label: "Ansvarig Förstnamn",
          name: "educationManager.userec.first_name",
          sort: true
        },
        {
          label: "Ansvarig Eftertnamn",
          name: "educationManager.userec.last_name",
          sort: true
        },
        {
          label: "Ort",
          name: "city.name",
          sort: true
        }

      ],
      edu_config: {
        checkbox_rows: true,        
        pagination: false,
        pagination_info: false,
        show_refresh_button: false,
        show_reset_button: false,
        global_search: {
          placeholder: "Sök",
          visibility: true
        },
        
      },

      course_columns: [
        {
          label: "Kurs",
          name: "name",
          sort: true
        },
        {
          label: "Poäng",
          name: "points",
          sort: true
        },
        {
          label: "Beskrivning",
          name: "description",
          sort: false
        },
        {
          label: "Startdatum",
          name: "date_start",
          sort: true
        },
        {
          label: "Slutdatum",
          name: "date_end",
          sort: true
        },
        {
          label: "Utbildning",
          name: "education.name",
          sort: true
        }
      ],
      course_config: {
        checkbox_rows: true,        
        pagination: false,
        pagination_info: false,
        show_refresh_button: false,
        show_reset_button: false,
        global_search: {
          placeholder: "Sök",
          visibility: true
        },
        
      }
    };
  },
  created() {
    this.$store.dispatch("getAllClasses");
    this.$store.dispatch("getAllCourses");
    this.$store.dispatch("getAllEducations");
    this.$store.dispatch("getAllUsers");
    this.$store.dispatch("getAllLectures");
    this.$store.dispatch("getRoles");
  },
  methods: {
     getUser($event){
      this.selectedUser = $event.selected_item.first_name + " " +  $event.selected_item.last_name ;
    },
    getRole($event){
      this.selectedRole = $event.selected_item.name;
    },
    getCourse($event){
      this.selectedCourse = $event.selected_item.name;
    },
    getClass($event){
      this.selectedClass = $event.selected_item.name;
    },
    getEdu($event){
      this.selectedEdu = $event.selected_item.name;
    },
    getLecture($event){
      this.selectedLecture = $event.selected_item.id;
    },
    deleteUSer: async function(){
      let userToDelete = this.user_rows.find( u => u.first_name === this.selectedUser);
      let result = await fetch("http://localhost:8080/user/"+userToDelete.id ,{method: 'DELETE'})
      console.log(result)      
    },
    deleteRole: async function(){
      let roleToDelete = this.role_rows.find( u => u.name === this.selectedRole);
      let result = await fetch("http://localhost:8080/role/"+roleToDelete.id ,{method: 'DELETE'})
      console.log(result)      
    },
    deleteCourse: async function(){
      let courseToDelete = this.course_rows.find( u => u.name === this.selectedCourse);
      let result = await fetch("http://localhost:8080/course/"+courseToDelete.id ,{method: 'DELETE'})
      console.log(result)      
    },
    deleteClass: async function(){
      let classToDelete = this.class_rows.find( u => u.name === this.selectedClass);
      let result = await fetch("http://localhost:8080/class/"+classToDelete.id ,{method: 'DELETE'})
      console.log(result)      
    },
    deleteEdu: async function(){
      let eduToDelete = this.edu_rows.find( u => u.name === this.selectedEdu);
      let result = await fetch("http://localhost:8080/education/"+eduToDelete.id ,{method: 'DELETE'})
      console.log(result)      
    },
    deleteLecture: async function(){
      let lectureToDelete = this.lec_rows.find( u => u.id === this.selectedLecture);
      let result = await fetch("http://localhost:8080/lecture/"+lectureToDelete.id ,{method: 'DELETE'})
      console.log(result)      
    },
    
  },
  computed: {
    role_rows: {
      get() {
        return this.$store.state.roles;
      }
    },
    class_rows: {
      get() {
        return this.$store.state.AllClass;
      }
    },
    edu_rows: {
      get() {
        return this.$store.state.AllEducation;
      }
    },
    course_rows: {
      get() {
        return this.$store.state.AllCourse;
      }
    },
    lec_rows: {
      get() {
        return this.$store.state.AllLecture;
      }
    },
    user_rows: {
      get() {
        return this.$store.state.AllUser;
      }
    }
  }
};
</script>