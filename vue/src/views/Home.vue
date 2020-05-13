<template>
  <div  class="home">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <a v-if="this.$store.state.loggedInUser.userId" href="http://localhost:8080/logout">
          <button v-on:click="logout" type="button" class="btn btn-info border" id="logoutButton">Logga ut</button>
        </a>
        <router-link to="/login">
          <button type="button" class="btn btn-info border" id="loginButton">Logga in</button>
        </router-link>
  </div>
  
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  },
  methods: {
    logout() {
      this.$store.dispatch('logout')}
    },
}
</script>
