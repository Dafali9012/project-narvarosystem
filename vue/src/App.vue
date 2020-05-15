<template>
  <div id="app" class="d-flex flex-column">
    <Navbar v-if="$route.name != 'login'" />
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

