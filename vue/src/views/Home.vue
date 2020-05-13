<template>
  <div class="home">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
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
  }
}
</script>
