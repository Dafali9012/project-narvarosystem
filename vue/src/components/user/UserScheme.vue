<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <UserSideBar/>
      
      <div class="main col-9 mt-5">
    
            <div class="row ml-5">
              <div class="col-6">                
                <VueCal class="vuecal--blue-theme" ref="vuecal" :time="false" hide-weekends show-week-numbers active-view="month" :disable-views="['years', 'year', 'week']"  style="height: 500px"   :cell-click-hold="false"
  editable-events
  :events="events"
  @cell-dblclick="$refs.vuecal.createEvent(
    customEventCreation($event)
  )"  ></VueCal>
              </div>
              <div class="col-6">                
                <h1>Saker</h1>
              </div>
            </div>
      </div>  
    </div>
     <div class="modal-mask" v-show="show" transition="modal">
    <div class="modal-wrapper">
      <div class="modal-container">
        <div class="modal-header">
          <slot name="header">Skapa ny lektion</slot>
        </div>

        <div class="modal-body">
          <slot name="body">
              <div class="form-row">
                <div class="form-group col-md-12">
                  <label for="inputName">Namn</label>
                  <input type="text" class="form-control w-100" id="inputName">
                </div>
                <div class="form-group col-md-12">
                  <label for="inputDate">Datum</label>
                  <input type="text" class="form-control w-100" id="inputDate">
                </div>
                 <div class="form-group col-md-12">
                   <label for="inputCourse">Kurs</label>
                    <select id="inputCourse" class="form-control w-100">
                    <option selected>Välj...</option>
                      <option>Java 101</option>
                      <option>Databashantering</option>
                     </select>
                 </div>
              </div>

          </slot>
        </div>

        <div class="modal-footer">
          <slot name="footer">
            <button class="modal-button" v-on:click="close" >Stäng</button>
            <button class="modal-button" v-on:click="commit" >Skapa</button>
          </slot>
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
          dateTime : "",
          title : "",
          course: "",
          show : false,

          events: [ 
            {
              start: '2020-05-15', 
              end: '2020-05-15',              
              title: 'Lektion 101',
              content: 'Lektion Om....',
              course: 'Java 101'
              
            },
            {
              start: '2020-05-22', 
              end: '2020-05-22',              
              title: 'Lektion 102',
              content: 'Lektion Om....',
              course: 'Java 101'
            },
            {
              start: '2020-05-25', 
              end: '2020-05-25',              
              title: 'Lektion 103',
              content: 'Lektion Om....',
              course: 'Java 101'
              }
              ]       
              }  
      
      }, methods:{
       
        customEventCreation($event, dateTime ) { 
         
          this.show = true
         
          dateTime = $event

          console.log(dateTime)

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
        },
        close: function() {
          this.show = false
        },
        commit: function(){
          //
        }
           
        
      }
      

    
}
</script>

<style scoped>
.modal-mask{
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, .5);
  display: table;
  transition: opacity .3s ease;}

.modal-wrapper{
  display: table-cell;
  vertical-align: middle;}

.modal-container{
  width: 300px;
  margin: 0px auto;
  padding: 20px 20px 30px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
  transition: all .3s ease;
  font-family: Helvetica, Arial, sans-serif;}

.modal-header h3{
  
    margin-top: 0;
    color: #42b983;}

.modal-body{
  margin: 20px 0;}

.modal-button{
  float: right;}

.modal-enter,
.modal-leave{
  opacity: 0;}

.modal-enter .modal-container,
.modal-leave .modal-container{
  transform: scale(1.1);}

</style>
