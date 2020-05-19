<template>
  <div  class="home">
    <HelloWorld msg="Welcome to Your Vue.js App"/> 
    <button v-on:click="logU">CLICK</button>
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
  methods:{
    logU: function(){
      console.log(this.$store.state.loggedInUser)
      console.log(this.$store.state.logged)
    }
  }
 }
</script>
