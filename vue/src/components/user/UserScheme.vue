<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <UserSideBar/>
      
      <div class="main col-9 mt-5">
            <div class="row ml-5">
              <div class="col-6">                
                <VueCal :time="false" hide-weekends active-view="month" :disable-views="['years', 'year', 'week']"   editable-events :events="events" style="height: 500px" ></VueCal>
              </div>
              <div class="col-6">                
                <h1>Saker</h1>
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
        }
}
</script>
