<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex flex-column container-fluid">
          <div class="content row mt-3">
            <UserSideBar />

            <div class="main col-9 mt-5">
              <div class="row ml-5">
                <div class="col-12">
                  <VueCal
                    class="vuecal--blue-theme"
                    ref="vuecal"
                    :time="false"
                    hide-weekends                    
                    show-week-numbers
                    active-view="week"
                    :disable-views="['years', 'year', 'month', 'day']"
                    style="height: 500px"
                    :cell-click-hold="false"
                    editable-events
                    :events="events" 
                    locale="sv"                    
                  ></VueCal>
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
  },created() {    
    this.$store.dispatch("getMyLectureTeacher", this.$store.state.loggedInUser.id);    
    
    
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
