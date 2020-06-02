<template>
  <div class="navbar text-cream">
    <div class="logo d-flex">
      <img src="@/assets/images/logo.png" class="height-100 ml-3" />
    </div>
    <div class="d-flex align-items-center justify-content-between">
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
export default {};
</script>

<style scoped>
@media screen and (max-width: 500px) {
  .navbar {
  }
}
</style>
