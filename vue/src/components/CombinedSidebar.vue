<template>
  <div class="d-flex flex-column align-items-center text-white">
    <img src="https://image.flaticon.com/icons/svg/2206/2206314.svg" class="avatar" />
    <h5
      class="unselectable"
    >{{this.$store.state.loggedInUser.first_name}} {{this.$store.state.loggedInUser.last_name}}</h5>
    <div class="sidebar-line rounded" />

    <div class="mt-5">
      <router-link
        v-if="this.$store.state.loggedInUser.role.access_overview"
        to="/overview"
        class="option d-flex align-self-center"
      >
        <font-awesome-icon :icon="['fas','list']" class="text-cream align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Överblick</p>
      </router-link>
      <router-link
        v-if="this.$store.state.loggedInUser.role.create_account"
        to="/create-account"
        class="option d-flex align-self-center"
      >
        <font-awesome-icon :icon="['far','id-badge']" class="text-cream align-self-center ml-1" />
        <p class="ml-3 unselectable menu-link no-margin">Skapa nytt konto</p>
      </router-link>
      <router-link
        v-if="this.$store.state.loggedInUser.role.create_education"
        to="/create-education"
        class="option d-flex align-self-center"
      >
        <font-awesome-icon :icon="['fas','graduation-cap']" class="text-cream align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Skapa ny utbildning</p>
      </router-link>
      <router-link
        v-if="this.$store.state.loggedInUser.role.create_course"
        to="/create-course"
        class="option d-flex align-self-center"
      >
        <font-awesome-icon :icon="['fas','book-open']" class="text-cream align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Skapa ny kurs</p>
      </router-link>
      <router-link
        v-if="this.$store.state.loggedInUser.role.create_class"
        to="/create-class"
        class="option d-flex align-self-center"
      >
        <font-awesome-icon :icon="['fas','chalkboard']" class="text-cream align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Skapa ny klass</p>
      </router-link>
  
      <!-- <router-link v-if="this.$store.state.loggedInUser.role.create_education" to="/users" class="option d-flex align-self-center">
        <font-awesome-icon :icon="['fas','list']" class="align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Lista över användare</p>
      </router-link> -->
      <router-link to="/report" class="option d-flex align-self-center">
        <font-awesome-icon :icon="['fas','chart-bar']" class="align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Rapport</p>
      </router-link>
     
      <router-link
        v-if="this.$store.state.loggedInUser.role.access_messages"
        to="/pimmessage"
        class="option d-flex align-self-center"
      >
        <font-awesome-icon :icon="['fas','comments']" class="text-cream align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">PIM</p>
      </router-link>
      <router-link
        v-if="this.$store.state.loggedInUser.role.access_calendar"
        to="/calendar/student"
        class="option d-flex align-self-center"
      >
        <font-awesome-icon :icon="['fas','chart-bar']" class="text-cream align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Kalendar Elev</p>
      </router-link>
      <!--
      <router-link to="/calendar/teacher" class="option d-flex align-self-center">
        <font-awesome-icon :icon="['fas','chart-bar']" class="align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Kalendar Lärare</p>
      </router-link>
      -->
      <router-link
        v-if="this.$store.state.loggedInUser.role.create_role"
        to="/create-role"
        class="option d-flex align-self-center"
      >
        <font-awesome-icon :icon="['fas','chart-bar']" class="text-cream align-self-center" />
        <p class="ml-3 unselectable menu-link no-margin">Skapa Roll</p>
      </router-link>
    </div>
  </div>
</template>
<script>
export default {
  methods: {},
  computed: {}
};
</script>