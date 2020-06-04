<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-sm-9 d-flex">
        <div class="root d-flex justify-content-center">
          <div class="main d-flex flex-column">
            <h2 class="align-self-start">Användarinformation</h2>
            <div class="content-line rounded" />


             <div class="container mt-5">
            <div class="jumbotron">
                <div class="row">
                    <div class="col-6">
                        <p>Förnamn:</p>
                        <p>Efternamn:</p>
                        <p>E-post:</p>
                        <p>Telefonnummer</p>
                        <p>Personnummer</p>
                    </div>
                    <div class="col-6">
                        <p>{{user.first_name}}</p>
                        <p>{{user.last_name}}</p>
                        <p>{{user.email}}</p>
                        <p>{{user.phone_number}}</p>
                        <p>{{user.ssn}}</p>
                    </div>
                </div>
            </div>

            <div class="d-flex flex-column mt-5">
              <div class="d-flex justify-content-between background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Mina Klasser</p>
                </div>
              </div>
              <vue-bootstrap4-table
                :rows="class_rows"
                :columns="class_columns"
                :config="class_config"
              ></vue-bootstrap4-table>
            </div>

          <div class="d-flex flex-column mt-5">
              <div class="d-flex justify-content-between background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Mina Kurser</p>
                </div>
              </div>
              <vue-bootstrap4-table
                :rows="course_rows"
                :columns="course_columns"
                :config="course_config"
              ></vue-bootstrap4-table>
            </div>


           </div>
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
      user:  this.$store.state.loggedInUser,
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
  mounted() {        
    this.$store.dispatch("getMyCourseTeacher", this.$store.state.loggedInUser.id); 
    this.$store.dispatch("getMyClassTeacher", this.$store.state.loggedInUser.id);     
  },
  methods: {},
  computed: {   
    class_rows: {
      get() {
        return this.$store.state.MyClassTeacher
      }
    }, 
    course_rows: {      
      get() {
        return this.$store.state.MyCourseTeacher
      }
    },    
  }

};
</script>