<template>
  <div class="user d-flex flex-column container-fluid">
    <div class="row">
      <div clas="col">
        <Navbar />
      </div>
    </div>
    <div class="content row mt-3">
      <div class="sidebar col-3">
        <div class="d-flex flex-column align-items-center text-white">
          <img
            src="https://www.fivestardestination.com/wp-content/uploads/2019/03/Just-white-square-300x300.png"
            class="avatar rounded-circle"
          />
          <h5 class="unselectable">Du är inloggad som Admin</h5>
          <div class="line rounded" />
          <div class="mt-5">
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['far','id-badge']" class="align-self-center ml-1" />
              <p class="ml-3 unselectable menu-link">Skapa nytt konto</p>
            </div>
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','graduation-cap']" class="align-self-center" />
              <p class="ml-3 unselectable menu-link">Skapa ny utbildning</p>
            </div>
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','book-open']" class="align-self-center" />
              <p class="ml-3 unselectable menu-link">Skapa ny kurs</p>
            </div>
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','chalkboard']" class="align-self-center" />
              <p class="ml-3 unselectable menu-link">Skapa ny klass</p>
            </div>
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','list']" class="align-self-center" />
              <p class="ml-3 unselectable menu-link">Overview</p>
            </div>
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','list']" class="align-self-center" />
              <p class="ml-3 unselectable menu-link">Lista över användare</p>
            </div>
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','chart-bar']" class="align-self-center" />
              <p class="ml-3 unselectable menu-link">Rapport</p>
            </div>
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','comments']" class="align-self-center" />
              <p class="ml-3 unselectable menu-link">PIM</p>
            </div>
          </div>
        </div>
      </div>
      <div class="main col-9">
        <NewAccount />
      </div>
    </div>
  </div>
</template>

<style scoped>
.avatar {
  margin-top: 15%;
  margin-bottom: 10%;
  width: 30%;
}
.line {
  height: 0.1em;
  width: 75%;
  background-color: #44c7c9;
}
.option {
  margin-top: 5%;
  font-size: 1.5rem;
}
.user {
  height: 100vh;
}
.content {
  flex-grow: 1;
}
p {
  margin: 0;
}
.sidebar {
  background-color: #0e6dee;
  border-top-right-radius: 15vh;
}
</style>

<script>
import Navbar from "@/components/Navbar.vue";
import NewAccount from "@/components/NewAccount.vue";
//import NewEducation from "@/components/NewEducation.vue";
//import NewCourse from "@/components/NewCourse.vue";
//import NewClass from "@/components/NewClass.vue";

export default {
  components: {
    Navbar,
    NewAccount,
    //NewEducation
    //NewCourse
    //NewClass
  }
};
</script>