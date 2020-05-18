<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <UserSideBar/>
      
      <div class="main col-9 mt-5">
            <div class="row ml-5">
              <div class="col-6">                
                <VueCal ref="vuecal" :time="false" hide-weekends show-week-numbers active-view="month" :disable-views="['years', 'year', 'week']"  style="height: 500px"   :cell-click-hold="false"
  editable-events
  :events="events"
  @cell-dblclick="$refs.vuecal.createEvent(
    customEventCreation()
  )"  ></VueCal>
              </div>
              <div class="col-6">                
                <h1 @click="modalopen">Saker</h1>
              </div>
            </div>
      </div>
    </div>

 

    <div v-if="modalOpen" data-toggle="modal">
      <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="false">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      ...
    </div>
  </div>
</div>
  
    </div>
    </div>
    
   

</template>

<script>
import UserSideBar from "@/components/user/UserSideBar.vue";
import VueCal from 'vue-cal'



export default {
        components: {
            VueCal, 
            UserSideBar
        },
        data:function () { return {

          modalOpen : false,

          

  events: [ 
    {
      start: '2020-05-15',
      end: '2020-05-15',
      title: 'Need to go shopping',
      content: '<i class="v-icon material-icons">shopping_cart</i>',
      class: 'leisure'
    },
    {
      start: '2020-05-22',
      end: '2020-05-22',
      title: 'Golf with John',
      content: '<i class="v-icon material-icons">golf_course</i>',
      class: 'sport'
    },
    {
      start: '2020-05-25',
      end: '2020-05-25',
      title: 'Dad\'s birthday!',
      content: '<i class="v-icon material-icons">cake</i>',
      class: 'sport'
      }
      ]       
      }  
      
      }, methods:{
        modalopen: function () {
          
       
            this.modalOpen = true
            console.log(this.modalOpen)
        },
        customEventCreation() { 
         
         
          /*const dateTime = $event*/

         /* this.modalOpen = true

          console.log(this.modalOpen)*/
        

          /*console.log(dateTime)*/

      /*
         
     

    // Check if date format is correct before creating event.
    if (dateTime) {
      this.$refs.vuecal.createEvent(
        // Formatted start date and time or JavaScript Date object.
        dateTime,
        // Event duration in minutes (Integer).
        120,
        // Custom event props (optional).
        { title: 'New Event', content: 'yay! 🎉', class: 'blue-event' }
      )
    }*/
        }
      }

    
}
</script>
