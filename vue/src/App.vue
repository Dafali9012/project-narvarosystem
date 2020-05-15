<template>
  <div id="app">
    <Navbar v-if="$route.name != 'Login'"/>
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

