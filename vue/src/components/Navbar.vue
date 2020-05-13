<template>
  <div class="col navbar text-cream">
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
      <router-link to="/">
        <p class="no-margin unselectable text-cream ml-5">Profil</p>
      </router-link>
      <router-link to="/login">
        <p class="no-margin unselectable text-cream ml-5">Logout</p>
      </router-link>
    </div>
  </div>
</template>

<style scoped>
.link {
  height: 100%;
}
.navrow {
  width: 100%;
}
.navbar {
  height: 8vh;
  /*width: 100vw;*/
  background-color: #28343a;
}
.logo {
  height: 100%;
}
</style>