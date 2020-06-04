<template>
  <div id="app" class="d-flex flex-column">
    <Navbar v-if="$route.path != '/'" />
    <router-view />
  </div>
</template>

<script>
import Navbar from "./components/Navbar.vue";

export default {
  name: "app",
  components: { Navbar },
  async created() {
    await this.$store.dispatch("getMessage");
    await this.$store.dispatch("getAllUsers");
    await this.$store.dispatch("updateLoggedUser")
  },

};
</script>

