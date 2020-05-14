<template>
  <div class="user d-flex flex-column container-fluid">    
    <div class="content row mt-3">
      <UserSideBar/>
      
      <div class="main col-9 mt-5">
          <div class="row ml-5">
              <div class="col-12 ml-5">
        <calendar
                :first-day="1"                
                :all-events="events"
        ></calendar>
     </div>
     </div>

      </div>
    </div>
  </div>
</template>



<script>

import UserSideBar from "@/components/user/UserSideBar.vue";
    import {Calendar} from 'vue-bootstrap-calendar';



export default {
 
       data() {
            return {
                events: []
            }
        },
        components: {
            Calendar,
            UserSideBar
        },
        mounted() {
            let me = this;
            setTimeout(function () {
                me.events = [ // you can make ajax call here
                    {
                        id:1,
                        title:'Event 1',
                        color: 'panel-danger',
                        date: new Date()
                    },
                  
                ];
            }, 1000);
        }
    
    }
</script>