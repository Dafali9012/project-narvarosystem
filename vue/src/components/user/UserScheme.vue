<template>
  <div class="user d-flex flex-column container-fluid">
    <div class="row">
      <div clas="col">
        <Navbar />
      </div>
    </div>
    <div class="content row mt-3">
      <UserSideBar/>
      
      <div class="main col-9 mt-5">
        <calendar
                :first-day="1"
                :all-events="events"
        ></calendar>
     

      </div>
    </div>
  </div>
</template>


<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script src="https://unpkg.com/vue-i18n/dist/vue-i18n.js"></script>


<script>

import UserSideBar from "@/components/user/UserSideBar.vue";




export default {
 
        components: {
          UserSideBar,
            Calendar
        }
    }
</script>