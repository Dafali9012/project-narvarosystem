<template>
  <div class="navbar text-cream container-fluid">
    <div class="row logo navrow">
      <div class="col-8 logo d-flex">
        <router-link class="navbar-brand link align-self-start" to="/">
          <img src="@/assets/images/logo.png" class="logo ml-3" />
        </router-link>
      </div>
      <div class="col-4 d-flex align-items-center justify-content-between">
        <router-link to="/">
          <p class="no-margin unselectable text-cream">Hem</p>
        </router-link>
        <router-link to="/">
          <p class="no-margin unselectable text-cream">PIM</p>
        </router-link>
        <router-link to="/">
          <p class="no-margin unselectable text-cream">Profil</p>
        </router-link>
        <router-link to="/login">
          <p class="no-margin unselectable text-cream">Logout</p>
        </router-link>
      </div>
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
  width: 100vw;
  background-color: #28343a;
}
.logo {
  height: 100%;
}
</style>