<template>
    <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex justify-content-center">
          <div class="main d-flex flex-column">
            <h2 class="align-self-start">Skapa ny roll</h2>
            <div class="content-line rounded" />

            <form @submit.prevent="createRole">
              <div class="mt-5 d-flex justify-content-center">
              </div>
                
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
                  <input class="form-check-input" type="checkbox" id="create_class">
                  <label class="form-check-label" for="create_class">Skapa Klass</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input"  type="checkbox" id="create_account">
                  <label class="form-check-label" for="create_account">Skapa Konto</label>
                </div> 
                <div class="form-check form-check-inline">
                  <input class="form-check-input"   type="checkbox" id="create_course">
                  <label class="form-check-label" for="create_course">Skapa Kurs</label>
                </div>   
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="create_education" >
                  <label class="form-check-label" for="create_ceducation">Skapa Utbildning</label>
                </div> 
                <div class="form-check form-check-inline">
                  <input class="form-check-input"  type="checkbox" id="create_role" >
                  <label class="form-check-label" for="create_role">Skapa Roll</label>
                </div>  
                                           
              </div>

              <div class="mt-4 d-flex justify-content-center">  
                <div class="form-check form-check-inline">
                  <input class="form-check-input"   type="checkbox" id="access_overview" >
                  <label class="form-check-label" for="create_overview">Skapa Overview</label>
                </div>              
                <div class="form-check form-check-inline">
                  <input class="form-check-input"  type="checkbox" id="access_messages" >
                  <label class="form-check-label" for="create_message">Se Meddelande</label>
                </div>    
                <div class="form-check form-check-inline">
                  <input class="form-check-input"  type="checkbox" id="access_classes_courses" >
                  <label class="form-check-label" for="access_classes_courses">Se kurser/klasser</label>
                </div>    
                <div class="form-check form-check-inline">
                  <input class="form-check-input"  type="checkbox" id="access_calendar" >
                  <label class="form-check-label" for="access_calendar">Se kalendar</label>
                </div>          
              </div>


              <div class="button-create mt-4 d-flex justify-content-end">
                <button type="submit" class="btn btn-primary">Skapa</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import CombinedSidebar from "@/components/CombinedSidebar.vue";

export default {
  created() {
    
  },
  components: {
    CombinedSidebar
  },
  computed: {
    
  },
  methods: {
    async createRole() {  
      

      let item = document.getElementsByClassName('form-check-input');
      let i;
      for (i = 0; i < item.length; i++) {
      if (item[i].checked) {
          item[i].setAttribute('value', "true")
      } else {
          item[i].setAttribute('value', "false");
      }
      }
    
      

      let newRole = {
        //name: document.getElementById("role_name").value,
        //create_class: document.getElementById("create_class").value
        name: document.getElementById("role_name").value,
        create_class: document.getElementById("create_class").value,
        create_account: document.getElementById("create_account").value,
        create_course: document.getElementById("create_course").value,
        create_education: document.getElementById("create_education").value,
        create_role: document.getElementById("create_role").value,
        access_overview: document.getElementById("access_overview").value,
        access_messages: document.getElementById("access_messages").value,
        access_classes_courses: document.getElementById("access_classes_courses").value,
        access_calendar: document.getElementById("access_calendar").value,       
      };



      console.log(this.newRole);

      let response = await fetch("http://localhost:8080/role", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newRole)
      });
      let result = await response.json();
      console.log(result);
    }
  }
};
</script>