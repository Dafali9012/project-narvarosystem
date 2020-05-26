<template>
  <div class="d-flex flex-column align-items-center text-white">
    <img src="https://image.flaticon.com/icons/svg/2206/2206314.svg" class="avatar" />
    <h5 class="unselectable">Du är inloggad som Användare</h5>
    <div class="sidebar-line rounded" />
    <div class="mt-5">
      <div class="option d-flex align-self-center">
        <font-awesome-icon :icon="['far','id-badge']" class="align-self-center ml-1" />
        <p
          v-on:click="changeContent(0)"
          class="ml-3 unselectable menu-link no-margin"
        >Skapa nytt konto</p>
      </div>
      <div class="option d-flex align-self-center">
        <font-awesome-icon :icon="['fas','graduation-cap']" class="align-self-center" />
        <p
          v-on:click="changeContent(1)"
          class="ml-3 unselectable menu-link no-margin"
        >Skapa ny utbildning</p>
      </div>
      <div class="option d-flex align-self-center">
        <font-awesome-icon :icon="['fas','book-open']" class="align-self-center" />
        <p v-on:click="changeContent(2)" class="ml-3 unselectable menu-link no-margin">Skapa ny kurs</p>
      </div>
      <div class="option d-flex align-self-center">
        <font-awesome-icon :icon="['fas','chalkboard']" class="align-self-center" />
        <p
          v-on:click="changeContent(3)"
          class="ml-3 unselectable menu-link no-margin"
        >Skapa ny klass</p>
      </div>
      <div class="option d-flex align-self-center">
        <font-awesome-icon :icon="['fas','list']" class="align-self-center" />
        <p v-on:click="changeContent(4)" class="ml-3 unselectable menu-link no-margin">Overview</p>
      </div>
      <div class="option d-flex align-self-center">
        <font-awesome-icon :icon="['fas','list']" class="align-self-center" />
        <p
          v-on:click="changeContent(5)"
          class="ml-3 unselectable menu-link no-margin"
        >Lista över användare</p>
      </div>
      <div class="option d-flex align-self-center">
        <font-awesome-icon :icon="['fas','chart-bar']" class="align-self-center" />
        <p v-on:click="changeContent(6)" class="ml-3 unselectable menu-link no-margin">Rapport</p>
      </div>
      <div class="option d-flex align-self-center">
        <font-awesome-icon :icon="['fas','comments']" class="align-self-center" />
        <p v-on:click="changeContent(7)" class="ml-3 unselectable menu-link no-margin">PIM</p>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  methods: {
    changeContent(newContentIndex) {
      this.$store.commit("changeContentIndex", newContentIndex);
    }
  }
};
</script>