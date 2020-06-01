<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex justify-content-center">
          <div class="main d-flex justify-content-center width-84">
            <div class="filter-window">
              <div class="d-flex justify-content-between  background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Filtrering</p>
                </div>
              </div>
              <div class="d-flex flex-column align-items-center bg-lightblue text-cream">
                <input class="form-control my-3 width-84" type="text" placeholder="Sök" />
                <div class="d-flex mb-2 width-84">
                  <input id="ec" type="checkbox" style="width:auto !important;" />
                  <label class="no-margin" for="ec">EC Personal</label>
                </div>
                <div class="d-flex mb-2 width-84">
                  <input id="teacher" type="checkbox" style="width:auto !important;" />
                  <label class="no-margin" for="teacher">Lärare</label>
                </div>
                <div class="d-flex mb-2 width-84">
                  <input id="consult" type="checkbox" style="width:auto !important;" />
                  <label class="no-margin" for="consult">Konsult</label>
                </div>
                <div class="d-flex mb-2 width-84">
                  <input id="student" type="checkbox" style="width:auto !important;" />
                  <label class="no-margin" for="student">Student</label>
                </div>
              </div>
            </div>

            <div class="results-window ml-3">
              <div class="d-flex justify-content-between  background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Användare</p>
                </div>
                <div class="d-flex justify-content-end align-items-center">
                  <font-awesome-icon
                    :icon="['fas','plus-circle']"
                    class="align-self-center mr-3 text-cream"
                  />
                </div>
              </div>

              <vue-bootstrap4-table
                :rows="rows"
                :columns="columns"
                :config="config"
                @on-select-row="getInfo($event)"
              ></vue-bootstrap4-table>
              <button class="button button-primary">
                <span>DELETE</span>
                {{selectedName}}
              </button>
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
  data: function() {
    return {
      selectedName: "",
      columns: [
        {
          label: "Förnamn",
          name: "first_name",
          sort: true
        },
        {
          label: "Efternamn",
          name: "last_name",
          sort: true
        },
        {
          label: "Telefon",
          name: "phone_number",
          sort: false
        },
        {
          label: "E-post",
          name: "email",
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
        card_title: "Alla användare"
      }
    };
  },
  created() {
    this.$store.dispatch("getAllUsers");
  },
  computed: {
    rows: {
      get() {
        return this.$store.state.AllUser;
      }
    }
  }
};
</script>