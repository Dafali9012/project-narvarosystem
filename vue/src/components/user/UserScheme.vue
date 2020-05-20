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
      
      }, 
       
        
   
      

    
}
</script>

