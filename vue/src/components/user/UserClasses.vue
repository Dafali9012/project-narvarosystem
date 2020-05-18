<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <UserSideBar />

      <div class="main col-9 mt-5">
        <div class="user-table mt-5">
          <vue-bootstrap4-table
            :rows="rows"
            :columns="columns"
            :config="config"
          >
          </vue-bootstrap4-table>
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
    VueBootstrap4Table,
  },
  data: function() {
    return {
      rows: [
        {
          namn: "Java 101",
          poäng: "50",
          startdatum: "2020-09-01",
          slutdatum: "2020-10-30",
          närvaro: "95%",
          lärare: "David Glane",
        },
        {
          namn: "Databas hantering",
          poäng: "100",
          startdatum: "2020-11-01",
          slutdatum: "2020-12-30",
          närvaro: "75%",
          lärare: "Annika Ros",
        },
        {
          namn: "Projektledning",
          poäng: "50",
          startdatum: "2020-01-01",
          slutdatum: "2020-01-30",
          närvaro: "50%",
          lärare: "David Glane",
        },
      ],
      columns: [
        {
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
          label: "Närvaro",
          name: "närvaro",
        },
        {
          label: "Lärare",
          name: "lärare",
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
