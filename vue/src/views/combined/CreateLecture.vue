<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex justify-content-center">
          <div class="main d-flex flex-column">
            <h2 class="align-self-start">Skapa lektion</h2>            
            <div class="content-line rounded" />
            <div class="mt-5">
            <form @submit.prevent="createLecture">                  
                  <div class="form-group">
                    <label for="setCourse">Välj Kurs</label>
                    <select class="form-control" id="course" name="course">
                      <option value disabled selected>Kurser</option>
                      <option
                        :value="course.id"
                        v-for="course in getAllCourses"
                        :key="course.id"
                      >{{course.name}}</option>
                    </select>                    
                  </div>                  
                  <div class="form-group">
                      <label for="setDate">Välj Datum</label>
                      <input
                      type="date"                      
                      id="setDate"                      
                      class="form-control"/>
                  </div>
                  <button type="submit" class="button button-primary float-right mt-5">Skapa</button>
                </form>
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
  components: {
    CombinedSidebar
  },
  created() {
    this.$store.dispatch("getAllCourses");
  },
  computed:{
    
    getAllCourses() {
      return this.$store.state.AllCourse
    }
  },
  

  methods: {
     async createLecture() {
      let newLecture = {
        course_id: document.getElementById("course").value,
        date: document.getElementById("setDate").value
      };

      let response = await fetch("http://localhost:8080/lecture", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newLecture)
      });

      let result = await response.json();
      console.log("POST:" + result);
    }   
    
  }
};
</script>