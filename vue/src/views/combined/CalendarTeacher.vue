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
                  ></VueCal>
                </div>
                <div class="col-6">
                  <h1 class="d-flex text-align-left"> Lägg till</h1>
                  
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

export default {
  components: {
    VueCal,
    CombinedSidebar
  },
  data: function() {
    return {
    // events: [
       // {
          //start: this.$store.state.MyLectureTeacher.date,          
          //title: "Lecktion " + this.$store.state.MyLectureTeacher.id,
          //content: "Lektion Om....",
          //course: "Java 101"
      //  }
        
     // ]
    };    
  },mounted() {    
    this.$store.dispatch("getMyLectureTeacher", this.$store.state.loggedInUser.id);
  }, 
  computed:{
   events: {
       get(){    

<<<<<<< Updated upstream
        let myevents = this.$store.state.MyLectureTeacher

        
         
        return myevents
=======
        return this.$store.state.MyLectureTeacher

        
         
>>>>>>> Stashed changes
       }
     }
  },
   

};
</script>