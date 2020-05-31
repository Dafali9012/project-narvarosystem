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
                <div class="col-6">
                        <VueCal
                    class="vuecal--blue-theme"
                    ref="vuecal"
                    :time="true"
                    hide-weekends
                    show-week-numbers
                    active-view="week"
                    :disable-views="['years', 'year', 'month']"
                    style="height: 500px"
                    :cell-click-hold="false"
                    editable-events
                    :events="events"
                  ></VueCal>
                </div>
                <div class="col-6">
                  <h1 class="d-flex text-align-left"> Lägg till</h1>
                  <form>
                    <div class="form-group">
                      <label class="presenceLabel" for="inputname"></label>
                      <input
                        type="text"
                        class="form-control"
                        v-model="Ititle"
                        id="inputname"
                        placeholder="Namn"
                      />
                    </div>
                    <div class="form-group">
                      <label class="presenceLabel" for="inputstart"></label>
                      <input
                        type="text"
                        class="form-control"
                        v-model="Istart"
                        id="inputstart"
                        placeholder="Start"
                      />
                    </div>
                    <div class="form-group">
                      <label class="presenceLabel" for="inputend"></label>
                      <input
                        type="text"
                        class="form-control"
                        v-model="Iend"
                        id="inputend"
                        placeholder="Slut"
                      />
                    </div>
                    <div class="form-group">
                      <label class="presenceLabel" for="inputcontent"
                        ></label
                      >
                      <input
                        type="text"
                        class="form-control"
                        v-model="Icontent"
                        id="inputcontent"
                        placeholder="Beskrivning"
                      />
                    </div>
                    <div class="form-group">
                      <label class="presenceLabel" for="inputcourse"></label>
                      <input
                        type="text"
                        class="form-control"
                        v-model="Icourse"
                        id="inputcourse"
                        placeholder="Kurs"
                      />
                    </div>
                    <button v-on:click="
                      events.push({
                        start: Istart,
                        end: Iend,
                        title: Ititle,
                        course: Icourse,
                        course: Icontent,
                        class: 'lec',
                      })
                    " type="submit" class="button button-primary"> <span> Skapa </span> </button>
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

export default {
  components: {
    VueCal,
    CombinedSidebar
  },
  data: function() {
    return {
     /*events: [
        {
          start: "2020-05-15",
          end: "2020-05-15",
          title: "Lektion 101",
          content: "Lektion Om....",
          course: "Java 101"
        },
        {
          start: "2020-05-22",
          end: "2020-05-22",
          title: "Lektion 102",
          content: "Lektion Om....",
          course: "Java 101"
        },
        {
          start: "2020-05-25",
          end: "2020-05-25",
          title: "Lektion 103",
          content: "Lektion Om....",
          course: "Java 101"
        }
      ]*/
    };    
  },mounted() {    
    this.$store.dispatch("getMyLectureTeacher", this.$store.state.loggedInUser.id);
  },
  computed:{
     events: {
       get(){
         

          return 'start ' + this.$store.state.MyLectureTeacher.date + 'end' + this.$store.state.MyLectureTeacher.date + 'title' + this.$store.state.MyLectureTeacher.date.id
       }
     }
  },
 
   

};
</script>