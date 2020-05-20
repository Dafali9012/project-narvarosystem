<template>
  <div class="root d-flex flex-column container-fluid">
    
    <div class="content row mt-3">
      <TeacherSideBar/>
      
      <div class="main col-9">
        <h1>Rapport</h1>

         <vue-bootstrap4-table ref="table"
            :rows="rows"
            :columns="columns"
            :config="config"
          ></vue-bootstrap4-table>

          
          
        
        <download-excel
	class   = "btn btn-primary"
	:data   = "rows"
	:fields = "json_fields"
	name    = "filename.xls">

	Export

</download-excel>
        
      </div>
      
    </div>
  </div>
</template>

<script>

import VueBootstrap4Table from "vue-bootstrap4-table";
import downloadExcel from 'vue-json-excel'
import TeacherSideBar from "@/components/teacher/TeacherSideBar.vue";


export default {
  components: {     
    TeacherSideBar,
    downloadExcel,
    VueBootstrap4Table    
  },
 data: function() {
    return {
      json_fields: {
            'Namn': 'namn',
            'Kursnamn': 'course',
            'Närvaro': 'närvaro'
            
        },
      
      rows: [
        {
          namn: "David Glane",
          course: "Databas hantering",         
          närvaro: "95%",
         
        },
        {
           namn: "Daniel ",
          course: "Databas hantering",         
          närvaro: "55%",
        },
        {
           namn: "Hang",
          course: "Databas hantering",         
          närvaro: "65%",
        },
        {
           namn: "Alexandra ",
          course: "Databas hantering",         
          närvaro: "10%",
        },
        {
           namn: "Petru",
          course: "Databas hantering",         
          närvaro: "99%",
        },
      ],
      columns: [
        {
          label: "Namn",
          name: "namn",
        },
        {
          label: "KursNamn",
          name: "course",
        },
        
        {
          label: "Närvaro",
          name: "närvaro",
        },
        
      ],
      config: {
        checkbox_rows: false,
        rows_selectable: false,
        pagination: false,
        pagination_info: false,
        show_refresh_button: false,
        show_reset_button: false,
        global_search: {
          visibility: false,
        },
        card_title: "Mina Kurser",
      },
    };
  },
};
</script>