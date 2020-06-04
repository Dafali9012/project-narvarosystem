<template>
  <div class="navbar text-cream">
    <div class="logo d-flex">
      <img src="@/assets/images/logo.png" class="height-100 ml-3" />
    </div>
    <div class="d-flex align-items-center justify-content-between">
      <router-link to="/welcome">
        <p class="no-margin unselectable text-cream font-weight-bold ml-5">Hem</p>
      </router-link>
      <router-link to="/pimmessage">
        <p v-if="!isNewMessage" class="no-margin unselectable text-cream font-weight-bold ml-5">PIM</p>
        <p v-if="isNewMessage"  class="no-margin unselectable text-cream font-weight-bold ml-5">PIM {{nrOfNewMessage}}</p>
      </router-link>
      <div>
        <a id="logout" href="http://localhost:8080/logout" >
          <p class="no-margin unselectable text-cream font-weight-bold ml-5">Logga ut</p>
        </a>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {

    };
  },
  computed: {
    isNewMessage() {
      return this.$store.state.newMessage;
    },
    nrOfNewMessage() {
      return this.$store.state.numberOfUnreadMessages;
      
    }
  },

};

</script>

<style scoped>
@media screen and (max-width: 500px) {
  .navbar {
  }
}
</style>
