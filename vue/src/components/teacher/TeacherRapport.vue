<template>
  <div class="root d-flex flex-column container-fluid">
    
    <div class="content row mt-3">
      <TeacherSideBar/>
      
      <div class="main col-9">
        <h1>Rapport</h1>
      </div>
    </div>
  </div>
</template>


<script>

import TeacherSideBar from "@/components/teacher/TeacherSideBar.vue";


export default {
  components: {     
    TeacherSideBar    
  }
};
</script>