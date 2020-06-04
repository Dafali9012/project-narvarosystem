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

          <select class="form-control mb-2 width-84" id="education">
            <option value="education">Utbildning</option>
          </select>
          <select class="form-control mb-2 width-84" id="course">
            <option value="course">Kurs</option>
          </select>
          <select class="form-control mb-4 width-84" id="class">
            <option value="class">Klass</option>
          </select>
        </div>
      </div>

      <div class="results-window ml-3">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable my-2">Rapport</p>
          </div>
          <div class="d-flex justify-content-end align-items-center">
            <font-awesome-icon
              :icon="['fas','plus-circle']"
              class="align-self-center mr-3 text-cream"
            />
          </div>
        </div>
        <div class="bg-white container-fluid">
          
            <vue-bootstrap4-table ref="table"
            :rows="rows"
            :columns="columns"
            :config="config"
          ></vue-bootstrap4-table>

          
          
        </div>
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

export default {
  components: {
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