<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex justify-content-center">
          <div class="main d-flex flex-column">
            <h2 class="align-self-start">Skapa ny roll</h2>
            <div class="content-line rounded" />

            <form @submit.prevent="createRole">
              <div class="mt-5 d-flex justify-content-center"></div>

              <div class="mt-4 d-flex justify-content-center">
                <input
                  class="form-control width-84"
                  type="text"
                  placeholder="Ny Roll"
                  id="role_name"
                />
              </div>

              <div class="mt-4 d-flex justify-content-center">
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="create_class" />
                  <label class="form-check-label" for="create_class">Skapa Klass</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="create_account" />
                  <label class="form-check-label" for="create_account">Skapa Konto</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="create_course" />
                  <label class="form-check-label" for="create_course">Skapa Kurs</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="create_education" />
                  <label class="form-check-label" for="create_ceducation">Skapa Utbildning</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="create_lecture" />
                  <label class="form-check-label" for="create_lecture">Skapa Lektion</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="create_role" />
                  <label class="form-check-label" for="create_role">Skapa Roll</label>
                </div>
              </div>

              <div class="mt-4 d-flex justify-content-center">
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="access_overview" />
                  <label class="form-check-label" for="create_overview">Skapa Overview</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="access_messages" />
                  <label class="form-check-label" for="create_message">Se Meddelande</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="access_classroom" />
                  <label class="form-check-label" for="access_classroom">Se KlassRoom</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="access_report" />
                  <label class="form-check-label" for="access_report">Se Raport</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="access_teacher_info" />
                  <label class="form-check-label" for="access_teacher_info">Se Lärare Information</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="access_student_info" />
                  <label class="form-check-label" for="access_student_info">Se Elev Information</label>
                </div>

                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="access_calendar_teacher" />
                  <label class="form-check-label" for="access_calendar_teacher">Se lärarens kalendar</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="access_calendar_student" />
                  <label class="form-check-label" for="access_calendar_student">Se elevs kalendar</label>
                </div>
              </div>

              <div class="button-create mt-4 d-flex justify-content-end">
                <button type="submit" class="btn btn-primary">Skapa</button>
              </div>
            </form>
            <div class="alert alert-secondary mt-5" v-show="trigger" role="alert">
            {{ message }}
          </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import CombinedSidebar from "@/components/CombinedSidebar.vue";

export default {
  created() {},
  components: {
    CombinedSidebar
  },
  data() {
    return {
      trigger : false,
      message : ""

      };    
  }, 
  computed: {},
  methods: {
    async createRole() {
      let newRole = {
        name: document.getElementById("role_name").value,
        create_class: document.getElementById("create_class").checked,
        create_account: document.getElementById("create_account").checked,
        create_course: document.getElementById("create_course").checked,
        create_education: document.getElementById("create_education").checked,
        create_lecture: document.getElementById("create_lecture").checked,
        create_role: document.getElementById("create_role").checked,
        access_overview: document.getElementById("access_overview").checked,
        access_messages: document.getElementById("access_messages").checked,
        access_classroom: document.getElementById("access_classroom").checked,
        access_report: document.getElementById("access_report").checked,
        access_teacher_info: document.getElementById("access_teacher_info").checked,
        access_student_info: document.getElementById("access_student_info").checked,
        access_calendar_teacher: document.getElementById("access_calendar_teacher").checked,
        access_calendar_student: document.getElementById("access_calendar_student").checked
      };

      console.log(this.newRole);

      let response = await fetch("http://localhost:8080/role", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newRole)
      });
      let result = await response.json();
      console.log(result);

      this.trigger = true,
      this.message = "Du har skapat följande uppgifter: 'Name ': " + result.name + 
      "' Skapa klass': " + result.create_class +
      "' Skapa konto': " + result.create_account +
      "' Skapa kurs': " + result.create_course + 
       "' Skapa utbildning': " + result.create_education + 
       "' Skapa lektion': " + result.create_lecture + 
       "' Skapa roll': " + result.create_role + 
       "' Se överblick': " + result.access_overview + 
       "' Se meddelande': " + result.access_messaged + 
       "' Se Klassrum': " + result.access_classroom + 
       "' Se Raport': " + result.access_report + 
       "' Se Lärare Information': " + result.access_teacher_info + 
       "' Se Elevs Information': " + result.access_student_info + 
       "' Se Lärarens Kalendar': " + result.access_calendar_teacher + 
        "' Se Elevs Kalendar': " + result.access_calendar_student 
      ;
    }
  }
};
</script>