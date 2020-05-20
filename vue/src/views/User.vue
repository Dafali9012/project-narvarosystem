<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="row">
      <div clas="col">
        <Navbar />
      </div>
    </div>
    <div class="content row mt-3">
      <UserSideBar />

      <div class="main col-9">
        <h1>Välkommen</h1>
      </div>
    </div>
  </div>
</template>

<script>
import UserSideBar from "@/components/user/UserSideBar.vue";

export default {
  components: {
    UserSideBar
  },
  mounted() {
    console.log(this.$store.state.loggedInUser.userID);
    this.$store.dispatch("getMyCourse", this.$store.state.loggedInUser.userID);
  }
};
</script>
