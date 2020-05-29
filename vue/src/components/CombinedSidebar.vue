<template>
  <div class="d-flex flex-column align-items-center text-white">
    <img src="https://image.flaticon.com/icons/svg/2206/2206314.svg" class="avatar" />
    <h5 class="unselectable">Du är inloggad som Användare</h5>
    <div class="sidebar-line rounded" />
    <div class="test mt-5">
      <router-link to="/overview" class="option d-flex align-self-center menu-link">
        <font-awesome-icon :icon="['fas','list']" class="align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Överblick</p>
      </router-link>
      <router-link to="/create-account" class="option d-flex align-self-center menu-link">
        <font-awesome-icon :icon="['far','id-badge']" class="align-self-center ml-1" />
        <p class="ml-3 unselectable menu-link no-margin">Skapa nytt konto</p>
      </router-link>
      <router-link to="/create-education" class="option d-flex align-self-center menu-link">
        <font-awesome-icon :icon="['fas','graduation-cap']" class="align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Skapa ny utbildning</p>
      </router-link>
      <router-link to="/create-course" class="option d-flex align-self-center menu-link">
        <font-awesome-icon :icon="['fas','book-open']" class="align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Skapa ny kurs</p>
      </router-link>
      <router-link to="/create-class" class="option d-flex align-self-center menu-link">
        <font-awesome-icon :icon="['fas','chalkboard']" class="align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Skapa ny klass</p>
      </router-link>
      <router-link to="/users" class="option d-flex align-self-center menu-link">
        <font-awesome-icon :icon="['fas','list']" class="align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Lista över användare</p>
      </router-link>
      <router-link to="/overview" class="option d-flex align-self-center menu-link">
        <font-awesome-icon :icon="['fas','chart-bar']" class="align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Rapport</p>
      </router-link>
      <router-link to="/pimmessage" class="option d-flex align-self-center menu-link">
        <font-awesome-icon :icon="['fas','comments']" class="align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">PIM</p>
      </router-link>
    </div>
  </div>
</template>
<script>
export default {
  methods: {}
};
</script>