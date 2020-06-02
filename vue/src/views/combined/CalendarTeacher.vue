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
                    style="height: 500px"
                    :cell-click-hold="false"
                    editable-events
                    :events="events" 
                    locale="sv"                    
                  ></VueCal>
                </div>
                <div class="col-6">
                  
                 <h1 class="d-flex text-align-left"> Skapa ny lektion</h1>

                  <form>                  
                  <div class="form-group">
                    <label for="setCourse">Välj Kurs</label>
                    <select class="form-control" id="setCourse">
                      <option>1</option>
                      <option>2</option>
                      <option>3</option>
                      <option>4</option>
                      <option>5</option>
                    </select>
                  </div>
                  <div class="form-group">
                    <label for="setClass">Välj Klass</label>
                    <select class="form-control" id="setClass1">
                      <option>1</option>
                      <option>2</option>
                      <option>3</option>
                      <option>4</option>
                      <option>5</option>
                    </select>
                  </div>
                  <div class="form-group">
                    <label for="setStudent">Välj Elev</label>
                    <select class="form-control" id="setStudent">
                      <option>1</option>
                      <option>2</option>
                      <option>3</option>
                      <option>4</option>
                      <option>5</option>
                    </select>
                  </div>
                  <div class="form-group">
                      <label for="settDate">Välj Datum</label>
                      <input
                      type="date"                      
                      id="setDate"                      
                      class="form-control"/>
                  </div>
                  <button type="submit" class="btn btn-primary float-right">Skapa</button>
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
    // events: [
       // {
          //start: this.$store.state.MyLectureTeacher.date,          
          //title: "Lecktion " + this.$store.state.MyLectureTeacher.id,
          //content: "Lektion Om....",
          //course: "Java 101"
      //  }
        
     // ]
    };    
  },created() {    
    this.$store.dispatch("getMyLectureTeacher", 171);
    
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
    }
   
  },
  computed:{
    getMyLectures() {
      return this.$store.state.MyLectureTeacher
    },
    
    getshit(){
      return this.getmyEvents();
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
