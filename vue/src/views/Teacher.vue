<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <TeacherSideBar />

      <div class="main col-sm-9 col-lg-12">
        <h1>Välkommen</h1>
      </div>
    </div>
  </div>
</template>


<script>
import TeacherSideBar from "@/components/teacher/TeacherSideBar.vue";

export default {
  components: {
    TeacherSideBar
  },
  mounted() {    
    this.$store.dispatch("getMyCourseAsTeacher", this.$store.state.loggedInUser.userID);
    this.$store.dispatch("getMyClassAsTeacher", this.$store.state.loggedInUser.userID);
  }
};
</script>