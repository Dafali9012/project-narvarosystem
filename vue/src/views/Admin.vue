<template>
  <div class="admin d-flex flex-column container-fluid">
    <div class="row">
      <Navbar/>
    </div>
    <div class="content row mt-3">
      <div class="admin-sidebar col-3">
        <div class="d-flex flex-column align-items-center text-white">
          <img
            src="https://www.fivestardestination.com/wp-content/uploads/2019/03/Just-white-square-300x300.png"
            class="avatar rounded-circle"
          />
          <h5 class="unselectable">Du är inloggad som Admin</h5>
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
              <p
                v-on:click="changeContent(2)"
                class="ml-3 unselectable menu-link no-margin"
              >Skapa ny kurs</p>
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
              <p
                v-on:click="changeContent(4)"
                class="ml-3 unselectable menu-link no-margin"
              >Overview</p>
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
      </div>
      <div class="main col-9">
        <NewAccount v-if="this.$store.state.contentIndex==0" />
        <NewEducation v-if="this.$store.state.contentIndex==1" />
        <NewCourse v-if="this.$store.state.contentIndex==2" />
        <NewClass v-if="this.$store.state.contentIndex==3" />
        <Overview v-if="this.$store.state.contentIndex==4" />
      </div>
    </div>
  </div>
</template>

<script>
// import Navbar from "@/components/Navbar.vue";
import NewAccount from "@/components/admin/NewAccount.vue";
import NewEducation from "@/components/admin/NewEducation.vue";
import NewCourse from "@/components/admin/NewCourse.vue";
import NewClass from "@/components/admin/NewClass.vue";
import Overview from "@/components/admin/Overview.vue";

export default {
  components: {
    // Navbar,
    NewAccount,
    NewEducation,
    NewCourse,
    NewClass,
    Overview
  },
  methods: {
    helloWorld() {
      console.log("hello world!");
    },
    changeContent(newContentIndex) {
      this.$store.commit("changeContentIndex", newContentIndex);
    }
  }
};
</script>