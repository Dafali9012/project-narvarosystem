<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <vue-bootstrap4-table :rows="rows" :columns="columns" :config="config"></vue-bootstrap4-table>
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
  methods: {
    helloWorld() {
      console.log("hello world!");
    }
  },
  data: function() {
    return {
      columns: [
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
          label: "Startdatum",
          name: "startDate",
          sort: true
        },
        {
          label: "Slutdatum",
          name: "endDate",
          sort: true
        },
        {
          label: "Utbildning",
          name: "edID",
          sort: true
        }
      ],
      config: {
        checkbox_rows: true,
        rows_selectable: true,
        pagination: false,
        pagination_info: false,
        show_refresh_button: false,
        show_reset_button: false,
        global_search: {
          placeholder: "Sök",
          visibility: true
        },
        card_title: "Klasser"
      }
    };
  },
  created() {
    this.$store.dispatch("getAllClasses");
  },
  computed: {
    rows: {
      get() {
        return this.$store.state.AllClass;
      }
    }
  }
};
</script>