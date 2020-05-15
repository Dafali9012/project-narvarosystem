<template>
  <div id="app" class="d-flex flex-column">
    <Navbar></Navbar>
    <router-view />
  </div>
</template>

<script>
import Navbar from "./components/Navbar.vue";

export default {
  name: "app",
  components: { Navbar }
};
</script>

