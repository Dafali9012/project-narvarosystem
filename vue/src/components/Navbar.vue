<template>
  <div class="navbar text-cream">
    <div class="logo d-flex">
      <router-link class="navbar-brand link" to="/">
        <img src="@/assets/images/logo.png" class="logo ml-3" />
      </router-link>
    </div>
    <div class="d-flex align-items-center justify-content-between">
      <router-link to="/">
        <p class="no-margin unselectable text-cream ml-5">Hem</p>
      </router-link>
      <router-link to="/">
        <p class="no-margin unselectable text-cream ml-5">PIM</p>
      </router-link>
      <router-link v-if="userLogged && userRole == 'STUDENT'" to="/user">
        <p class="no-margin unselectable text-cream ml-5">Profil</p>
      </router-link>
      <router-link v-if="userLogged && userRole == 'ADMIN'" to="/admin">
        <p class="no-margin unselectable text-cream ml-5">Profil</p>
      </router-link>
      <router-link v-if="userLogged && userRole == 'TEACHER'" to="/teacher">
        <p class="no-margin unselectable text-cream ml-5">Profil</p>
      </router-link>
      <div v-if="this.$store.state.loggedInUser.userID"  >
    <a href="http://localhost:8080/logout">
          <p class="no-margin unselectable text-cream ml-5" v-on:click='logout'>Logga ut</p>
        </a>
    </div>
     <div v-else>
      <router-link to="/login">
        <p class="no-margin unselectable text-cream ml-5">Login</p>
      </router-link>
       </div>
    </div>
  </div>
</template>


<script>

export default {
 
  methods: {
    logout() {
      this.$store.dispatch('logout')}
    },
    computed:{
      userRole(){
        return this.$store.state.loggedInUser.roles[0].role
      },
       userLogged(){
        return this.$store.state.logged
      }
    }
}
</script>