<template>
  <div class="user d-flex flex-column container-fluid">
    <div class="row">
      <div clas="col">
        <Navbar />
      </div>
    </div>
    <div class="content row mt-3">
      <div class="sidebar col-3">
        <div class="row d-flex flex-column align-items-center text-vit">
          <img
            src="https://www.fivestardestination.com/wp-content/uploads/2019/03/Just-white-square-300x300.png"
            class="avatar rounded-circle"
          />
          <h5 class="unselectable">Du är inloggad som Användare</h5>
          <div class="line rounded" />
          <h5 class="option unselectable">Option 1</h5>
          <h5 class="option unselectable">Option 2</h5>
          <h5 class="option unselectable">Option 3</h5>
        </div>
      </div>
      <div class="main col-9"></div>
    </div>
  </div>
</template>

<style scoped>
.avatar {
  margin-top: 15%;
  margin-bottom: 6%;
  width: 30%;
}
.line {
  height: 0.2em;
  width: 65%;
  background-color: #44c7c9;
}
.option {
  margin-top: 5%;
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
  border-top-right-radius: 25vh;
}
</style>

<script>
import Navbar from "@/components/Navbar.vue";

export default {
  components: {
    Navbar
  }
};
</script>