<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex justify-content-center">
          <div class="main d-flex flex-column width-84">
            <h2 class="align-self-start">Överblick</h2>
            <div class="content-line rounded mb-5" />
            <div class="d-flex flex-column">
              <div class="d-flex justify-content-between background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Utbildningar</p>
                </div>
              </div>
              <vue-bootstrap4-table :rows="edu_rows" :columns="edu_columns" :config="edu_config"></vue-bootstrap4-table>
            </div>
            <br />

            <div class="d-flex flex-column">
              <div class="d-flex justify-content-between background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Klasser</p>
                </div>
              </div>
              <vue-bootstrap4-table
                :rows="class_rows"
                :columns="class_columns"
                :config="class_config"
              ></vue-bootstrap4-table>
            </div>

            <br />
            <div class="d-flex flex-column">
              <div class="d-flex justify-content-between background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Kurser</p>
                </div>
              </div>
              <vue-bootstrap4-table
                :rows="course_rows"
                :columns="course_columns"
                :config="course_config"
              ></vue-bootstrap4-table>
            </div>
          </div>
        </div>
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
  data() {
    return {
      class_columns: [
        {
          label: "Klass",
          name: "classID",
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
      class_config: {
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
      },

      edu_columns: [
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
      edu_config: {
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
      },

      course_columns: [
        {
          label: "Kurs",
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
      course_config: {
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
        card_title: "Kurser"
      }
    };
  },
  created() {
    this.$store.dispatch("getAllClasses");
    this.$store.dispatch("getAllCourses");
    this.$store.dispatch("getAllEducations");
  },
  methods: {},
  computed: {
    class_rows: {
      get() {
        return this.$store.state.AllClass;
      }
    },
    edu_rows: {
      get() {
        return this.$store.state.AllEducation;
      }
    },
    course_rows: {
      get() {
        return this.$store.state.AllCourse;
      }
    }
  }
};
</script>