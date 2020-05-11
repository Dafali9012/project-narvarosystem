<template>
  <div class="user d-flex flex-column container-fluid">
    <div class="row">
      <div clas="col">
        <Navbar/>
      </div>
    </div>
    <div class="content row mt-3">
      <div class="sidebar col-3"></div>
      <div class="main col-9"></div>
    </div>
  </div>
</template>

<style scoped>
.user {
  height: 100vh;
}
.content {
  flex-grow: 1;
}
p {
  margin: 0;
}
.sidebar {
  background-color: #0e6dee;
  border-top-right-radius: 25vh;
}
</style>

<script>
import Navbar from "@/components/Navbar.vue";

export default {
  components: {
    Navbar
  }
};
</script>