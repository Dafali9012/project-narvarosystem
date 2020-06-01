<template>
  <div class="navbar text-cream">
    <div class="logo d-flex">
      <router-link class="navbar-brand link" to="/">
        <img src="@/assets/images/logo.png" class="logo ml-3" />
      </router-link>
    </div>
    <div class="d-flex align-items-center justify-content-between">
      <router-link to="/">
        <p class="no-margin unselectable text-cream font-weight-bold ml-5">Hem</p>
      </router-link>
      <router-link to="/pim">
        <p class="no-margin unselectable text-cream font-weight-bold ml-5">PIM</p>
      </router-link>
      <div>
        <a href="http://localhost:8080/logout">
          <p class="no-margin unselectable text-cream font-weight-bold ml-5">Logga ut</p>
        </a>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  computed: {
    userRole() {
      return this.$store.state.loggedInUser.roles[0].role;
    },
    userLogged() {
      return this.$store.state.logged;
    }
    }
}
</script>

<style scoped>
@media screen and (max-width: 500px) {
  .navbar {
  
  }
}
</style>
