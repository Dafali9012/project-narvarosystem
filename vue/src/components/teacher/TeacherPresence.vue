<template>
  <div class="root d-flex flex-column container-fluid">    
    <div class="content row mt-3">
      <TeacherSideBar/>
      
       <div class="main col-9 mt-5">
    
            <div class="row ml-5">
              <div class="col-6">                
                <VueCal class="vuecal--blue-theme"  ref="vuecal" :time="true" hide-weekends show-week-numbers active-view="week" :disable-views="['years', 'year', 'month']" style="height: 500px"   :cell-click-hold="false"
  editable-events
  :events="events"
  ></VueCal>
              </div>
              <div class="col-6">                
                <h1>Saker</h1>
                <form>
                  <div class="form-group">
                    <label for="inputname">Namn</label>
                    <input type="text" class="form-control" v-model="Ititle"  id="inputname" placeholder="Namn">
                  </div>
                  <div class="form-group">
                    <label for="inputstart">Start</label>
                    <input type="text" class="form-control" v-model="Istart"  id="inputstart" placeholder="Start">
                  </div>
                  <div class="form-group">
                    <label for="inputend">Slut</label>
                    <input type="text" class="form-control" v-model="Iend" id="inputend" placeholder="Slut">
                  </div>
                  <div class="form-group">
                    <label for="inputcontent">Beskrivning</label>
                    <input type="text" class="form-control" v-model="Icontent"  id="inputcontent" placeholder="Beskrivning">
                  </div>
                  <div class="form-group">
                    <label for="inputcourse">Kurs</label>
                    <input type="text" class="form-control"  v-model="Icourse" id="inputcourse" placeholder="Kurs">
                  </div>
                </form>
                <a class="btn btn-primary" @click="events.push({start: Istart,
    end: Iend,
    title: Ititle,
    course: Icourse,
    course: Icontent,
    class: 'lec'})">Skapa</a>
              </div>
            </div>
            </div>
    
    
    
    </div>
  </div>
</template>


<script>

import TeacherSideBar from "@/components/teacher/TeacherSideBar.vue";
import VueCal from 'vue-cal'

import 'vue-cal/dist/vuecal.css'


export default {
  components: {     
    TeacherSideBar,
    VueCal    
  },
 data:function () { return {
          Istart : "",
          Iend : "",
          Ititle : "",
          Icourse : "",
          Icontent: "",
         

          events: [ 
            {
              start: '2020-05-15 08:30', 
              end: '2020-05-15 16:30',              
              title: 'Lektion 101',
              content: 'Lektion Om....',
              course: 'Java 101',              
              class: 'lec',
              
            },
            {
              start: '2020-05-22 08:30', 
              end: '2020-05-22 16:30',              
              title: 'Lektion 102',
              content: 'Lektion Om....',
              course: 'Java 101',
              class: 'lec'
            },
            {
              start: '2020-05-25 08:30', 
              end: '2020-05-25 16:30',              
              title: 'Lektion 103',
              content: 'Lektion Om....',
              course: 'Java 101',
              class: 'lec',
              }
              ]       
              }  
      
      }, methods:{
       
      },
       
}
</script>
<style>
.vuecal__event.lec{background-color: rgba(253, 156, 66, 0.9) !important}


</style>

