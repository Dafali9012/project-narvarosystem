<template>
  <div class="user d-flex flex-column container-fluid">
    
    
    <div class="content row mt-3 h-100">
      <UserSideBar/>
      
      <div class="main col-9 h-100">
        <h1>Edit</h1>
      </div>
    </div>
  </div>
  
</template>


<script>

import UserSideBar from "@/components/user/UserSideBar.vue";


export default {
  components: {     
    UserSideBar    
  }
};
</script>