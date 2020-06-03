<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex flex-column container-fluid">
          <div class="content row mt-3">
           

            <div class="main col-9 mt-5">
              <div class="row ml-5">
                <div class="col-6">
                        <VueCal
                    class="vuecal--blue-theme"
                    ref="vuecal"
                    :time="false"
                    hide-weekends                    
                    show-week-numbers
                    active-view="week"
                    :disable-views="['years', 'year', 'month', 'day']"                    
                    :cell-click-hold="false"                    
                    :events="events" 
                    locale="sv"                    
                  ></VueCal>
                </div>
                <div class="col-6">
                  
                 <h1 class="d-flex text-align-left"> Skapa ny lektion</h1>

                  <form @submit.prevent="createLecture">                  
                  <div class="form-group">
                    <label for="setCourse">Välj Kurs</label>
                    <select class="form-control" id="course" name="course">
                      <option value disabled selected>Kurser</option>
                      <option
                        :value="course.id"
                        v-for="course in getMyCourses"
                        :key="course.id"
                      >{{course.name}}</option>
                    </select>                    
                  </div>
                  <div class="form-group">
                    <label for="setClass">Välj Klass</label>
                    <select class="form-control" id="setClass" disabled>
                      <option>1</option>
                      <option>2</option>
                      <option>3</option>
                      <option>4</option>
                      <option>5</option>
                    </select>
                  </div>
                  <div class="form-group">
                    <label for="setStudent">Välj Elev</label>
                    <select class="form-control" id="setStudent" disabled>
                      <option>1</option>
                      <option>2</option>
                      <option>3</option>
                      <option>4</option>
                      <option>5</option>
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
    </div>
  </div>
</template>

<script>
import CombinedSidebar from "@/components/CombinedSidebar.vue";
import VueCal from "vue-cal";

import moment from 'moment'



export default {
  components: {
    VueCal,
    CombinedSidebar
  },
  data: function() {
    return {
      events: []    
    };    
  },mounted() {    
    this.$store.dispatch("getMyLectureTeacher", this.$store.state.loggedInUser.id);
    this.$store.dispatch("getMyCourseTeacher", this.$store.state.loggedInUser.id);
    console.log("id: " + this.$store.state.loggedInUser.id)
    
  },
  methods: {
    getmyEvents(){
      let i;
      for (i = 0; i < this.getMyLectures.length; i++) {
      let newEvent = {
        title: "Lektion " + String(this.getMyLectures[i].id),
        start: moment(this.getMyLectures[i].date).format('YYYY-MM-DD'),
        end: moment(this.getMyLectures[i].date).format('YYYY-MM-DD'),
        class: "lec"
      }
      this.events.push(newEvent)      
      }
    },
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

   
  },
  computed:{
    getMyLectures() {      
      return this.$store.state.MyLectureTeacher
    },
    getshit(){
      return this.getmyEvents();
    },
    getMyCourses() {
      return this.$store.state.MyCourseTeacher
    }
  }
}
</script>
<style>
.vuecal__event.lec {
  background-color: rgba(17, 83, 206, 0.9) !important;
  height: 100px;
  color: white;
}
</style>
