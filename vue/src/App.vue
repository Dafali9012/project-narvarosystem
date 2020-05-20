<template>
  <div id="app" class="d-flex flex-column">
    <Navbar v-if="$route.path != '/fuckyou'" />
    <router-view />
  </div>
</template>

<script>
import Navbar from "./components/Navbar.vue";

export default {
  name: "app",
  components: { Navbar },
  created(){
    this.$store.dispatch("updateLoggedUser");
  }
};
</script>

