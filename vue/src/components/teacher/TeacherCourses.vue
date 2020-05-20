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
           
            columns: [{
              label: "Kurs",
              name: "name",              
              sort: true,
              
            },
            {
              label: "Poäng",
              name: "point",              
              sort: true,
              
            },
            {
              label: "Beskrivning",
              name: "description",              
              sort: false,
              
            },
            {
              label: "Startdatum",
              name: "startDate",              
              sort: true,
              
            },
            {
              label: "Slutdatum",
              name: "endDate",              
              sort: true,
              
            },            
                
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
    computed: {
    rows: {
      get() {
        return this.$store.state.MyCourseAsTeacher
      }
    }
  }

};
</script>