<template>
  <div class="root d-flex flex-column container-fluid">   
    <div class="content row mt-3">
      <TeacherSideBar/>
      
      <div class="main col-9 mt-5">
        <div class="user-table mt-5">          
          <vue-bootstrap4-table :rows="rows" :columns="columns" :config="config">
          </vue-bootstrap4-table>
        </div> 
      </div>
    </div>
  </div>
</template>


<script>
import TeacherSideBar from "@/components/teacher/TeacherSideBar.vue";
import VueBootstrap4Table from 'vue-bootstrap4-table';

export default {
  components: {     
    TeacherSideBar,
    VueBootstrap4Table    
  },
   data: function() {
        return {
            rows: [{
                    "namn" : "Java 101",
                    "poäng" : "50",
                    "startdatum": "2020-09-01",
                    "slutdatum" : "2020-10-30",
                    "klass" : "Java19",
                    "utbildning" : "Java"
                },
                {
                  "namn" : "Databas hantering",
                    "poäng" : "100",
                    "startdatum": "2020-11-01",
                    "slutdatum" : "2020-12-30",
                    "klass" : "Java19",
                    "utbildning" : "Java"
                   
                },
                {
                  "namn" : "Projektledning",
                    "poäng" : "50",
                    "startdatum": "2020-01-01",
                    "slutdatum" : "2020-01-30",
                    "klass" : "Java20",
                    "utbildning" : "Java"
                    
                }],
            columns: [{
                    label: "Namn",
                    name: "namn",                  
                    
                },
                {
                    label: "Poäng",
                    name: "poäng",                    
                    
                },
                {
                    label: "Startdatum",
                    name: "startdatum",
                   
                },
                {
                    label: "Slutdatum",
                    name: "slutdatum",                 
                },
                {
                    label: "Klass",
                    name: "klass",                 
                },
                {
                    label: "Utbildning",
                    name: "utbildning",                 
                }
                
                ],
            config: {
                checkbox_rows: true,
                rows_selectable: true,
                pagination: false,
                pagination_info: false,
                show_refresh_button:  false,
                    show_reset_button:  false,
                global_search:  {                        
                        visibility:  false                        
                    },
                card_title: "Mina Kurser"
            }
        }
    },
};
</script>