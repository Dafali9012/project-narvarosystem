<template>
  <div id="app">
    <Navbar></Navbar>
    <router-view/>
    <button v-on:click="logU">CLICK</button>
  </div>
</template>

<script>
import Navbar from "./components/Navbar.vue";



export default {
  name: "app",
  components: { Navbar },  
  methods:{
    logU: function(){
      console.log(this.$store.state.loggedInUser)
    }
  }
};
</script>

