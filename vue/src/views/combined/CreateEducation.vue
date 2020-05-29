<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
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
  data: function() {
    return {
      columns: [
        {
          label: "Utbildning",
          name: "name",
          sort: true
        },
        {
          label: "Poäng",
          name: "point",
          sort: true
        },
        {
          label: "Beskrivning",
          name: "description",
          sort: false
        },
        {
          label: "Lärare",
          name: "leaderId",
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
        card_title: "Utbildning"
      }
    };
  },
  async created() {
    await this.$store.dispatch("getAllEducations");
  },
  computed: {
    rows: {
      get() {
        return this.$store.state.AllEducation;
      }
    }
  }
};
</script>