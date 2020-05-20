<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <UserSideBar />

      <div class="main col-9 mt-5">
        <div class="user-table mt-5">
          <vue-bootstrap4-table :rows="rows" :columns="columns" :config="config"></vue-bootstrap4-table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import UserSideBar from "@/components/user/UserSideBar.vue";
import VueBootstrap4Table from "vue-bootstrap4-table";

export default {
  components: {
    UserSideBar,
    VueBootstrap4Table
  },
  data: function() {
    return {
      columns: [
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
              label: "Poäng",
              name: "point",              
              sort: true,
              
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
          visibility: false
        },
        card_title: "Mina Kurser"
      }
    };
  },
  computed: {
    rows: {
      get() {
        return this.$store.state.MyCourse;
      }
    }
  }
};
</script>
