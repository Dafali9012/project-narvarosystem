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
            rows: [
                ],
            columns: [
            {
              label: "id",
              name: "id",
              filter: {
                type: "simple",
                placeholder: "id"
              },
              sort: true,
              uniqueId: true
            },
            {
              label: "First Name",
              name: "name.first_name",
              filter: {
                type: "select",
                placeholder: "Enter first name",
                mode: "multi",
                options:[
                  {
                    "name" : "Irwin",
                    "value" : "Irwin"
                  },
                  {
                    "name" : "Don",
                    "value" : "Don"
                  },
                  {
                    "name" : "Lolita Paris",
                    "value" : "Lolita"
                  }
                ]
              },
              sort: true,
              // slot_name: "my_duplicate_id_column"
            },
            {
              label: "Last Name",
              name: "name.last_name",
              filter: {
                type: "simple",
                placeholder: "Enter last name",
                case_sensitive: true
              },
              sort: true,
            },
            {
              label: "Email",
              name: "email",
              filter: {
                type: "simple",
                placeholder: "Enter email"
              },
              sort: true,
              row_text_alignment: "text-left",
              column_text_alignment: "text-left",
            },
            {
              label: "City",
              name: "address.city",
              sort: true
            },
            {
              label: "Country",
              name: "address.country",
              filter: {
                type: "simple",
                placeholder: "Enter country"
              },
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
                card_title: "Klasser"
            }
    }
           
  },
  async created() {
    await this.$store.dispatch("getAllClasses");
  },

   mounted() {
         //
   }


  
};
</script>