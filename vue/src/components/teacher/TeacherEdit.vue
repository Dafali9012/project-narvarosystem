<template>
  <div class="user d-flex flex-column container-fluid">
    <div class="row">
      <div clas="col">
        <Navbar />
      </div>
    </div>
    <div class="content row mt-3">
      <UserSideBar/>
      
      <div class="main col-9">
        <h1>Edit</h1>
      </div>
    </div>
  </div>
</template>


<script>

import TeacherSideBar from "@/components/user/TeacherSideBar.vue";


export default {
  components: {     
    TeacherSideBar    
  }
};
</script>