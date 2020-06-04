<template>
  <div class="navbar text-cream">
    <div class="logo d-flex">
      <img src="@/assets/images/logo.png" class="height-100 ml-3" />
    </div>
    <div class="d-flex align-items-center justify-content-between">
      <router-link to="/">
        <p class="no-margin unselectable text-cream font-weight-bold ml-5">Hem</p>
      </router-link>
      <router-link to="/pimmessage">
        <p v-if="!isNewMessage.new" class="no-margin unselectable text-cream font-weight-bold ml-5">PIM</p>
        <p v-if="isNewMessage.new"  class="no-margin unselectable text-cream font-weight-bold ml-5">PIM<b-badge variant="light"> {{isNewMessage.numberOfUnreadMessages}}</b-badge></p>
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
export default {
  data() {
    return {
      newMessage: {}
    };
  },
  methods: {

  },
  created() {
    this.$store.dispatch("getMessage");
    this.setNewMessage();
  },
  computed: {
    isNewMessage() {
      return this.$store.state.newMessage;
    }
  }
};
</script>

<style scoped>
@media screen and (max-width: 500px) {
  .navbar {
  }
}
</style>
