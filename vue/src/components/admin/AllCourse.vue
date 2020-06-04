<template>
<vue-bootstrap4-table :rows="rows" :columns="columns" :config="config">
          </vue-bootstrap4-table>
</template>
<script>

import VueBootstrap4Table from 'vue-bootstrap4-table';

export default {
  components: {       
    VueBootstrap4Table    
  },
   data: function() {

        return {
            
            columns: [
           {
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
            {
              label: "Utbildning",
              name: "edID",              
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
                        placeholder: "Sök",
                        visibility: true, 
                                            
                    },
                card_title: "Kurser"

            }
    }
           
  },
  async created() {
    await this.$store.dispatch("getAllCourses")

  },
   computed: {
     rows:{
      get(){        
        return this.$store.state.AllCourse;
      }
    },
   }
  

 


  
};
</script>