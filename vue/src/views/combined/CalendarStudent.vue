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
                    :on-event-click="onEventClick"
                    locale="sv"
                  ></VueCal>
                </div>

                <div class="col-6">
                  
                 <h1 class="d-flex text-align-left">Lämna närvaro</h1>

                  <form @submit.prevent="createAttendance">                  
                  <div class="form-group">                    
                    <label for="lectid">Lektion</label>
                    <input type="text" disabled :value="selectedEvent.id" id="lecid" class="form-control" :placeholder="selectedEvent.title">
                  </div>
                  <div class="form-group">                    
                    <label for="lecdatum">Datum</label>
                    <input type="text" disabled :value="selectedEvent.start" id="lecdatum" class="form-control" :placeholder="selectedEvent.start">
                  </div>

                  <div class="form-group">     
                    <label for="lecdatum">Närvaro/Frånvaro</label>
                     <select class="form-control" id="present" name="present">
                  <option value disabled selected>Välj</option>
                  <option value="true">Närvarande</option>
                  <option value="false">Frånvarnde</option>
                  </select>   
                  </div>                  
                  <button type="submit" class="button button-primary float-right mt-5">Lämna</button>
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

import moment from "moment";

export default {
  components: {
    VueCal,
    CombinedSidebar
  },
  data: function() {
    return { 
      selectedEvent: {},  
      events: [],      
     
    };    
  },mounted() {    
    this.$store.dispatch("getMyLectureStudent", this.$store.state.loggedInUser.id);  
    this.$store.dispatch("getMyStudentID", this.$store.state.loggedInUser.id);   
  },
  methods: {
    async createAttendance() {      
      let newAttendance = {
        present: document.getElementById("present").value,
        lecture_id: document.getElementById("lecid").value,
        student_id: this.$store.state.MyStudentID[0].id
      };

      let response = await fetch("http://localhost:8080/attendance", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newAttendance)
      });

      let result = await response.json();
      console.log("POST:" + result);
    },

    getmyEvents() {
      let i;
      for (i = 0; i < this.getMyLectures.length; i++) {
        let newEvent = {
          title: "Lektion " + String(this.getMyLectures[i].id),
          start: moment(this.getMyLectures[i].date).format("YYYY-MM-DD"),
          end: moment(this.getMyLectures[i].date).format("YYYY-MM-DD"),
          id: this.getMyLectures[i].id,
          class: "lec"
        };
        this.events.push(newEvent);
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
    },
    onEventClick(event) {
      this.selectedEvent = event;
    }
  },
  computed: {
    getMyLectures() {
      return this.$store.state.MyLectureStudent;
    },
    getshit() {
      return this.getmyEvents();
    }
  }
};
</script>
<style>
.vuecal__event.lec {
  background-color: rgba(17, 83, 206, 0.9) !important;
  height: 100px;
  color: white;
}
</style>
