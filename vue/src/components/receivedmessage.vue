<template>
  <div class="container-fluid mt-2">
    <fieldset disabled>
      <div class>
        <h5
          class="text-secondary text-left rounded border bg-white shadow p-2 m-3"
        >Från: {{message.senderID}}</h5>
        <h5
          class="text-secondary text-left rounded border bg-white shadow p-2 m-3"
        >Datum: {{message.date}}</h5>
        <h5
          class="text-secondary text-left rounded border bg-white shadow p-2 m-3"
        >Ämne: {{message.subject}}</h5>
      </div>
      <div class="row mt-5">
        <div class="col m-3 rounded">
          <h5
            class="text-secondary rounded shadow-lg text-left border bg-white w-100 p-3"
          >{{message.message}}</h5>
        </div>
      </div>
    </fieldset>
    <div class="container-fluid d-flex justify-content-end">
      <button class="shadow button button-primary" v-on:click="back">Gå tillbacka</button>
      <button class="shadow button button-primary" v-on:click="deleteMessage">Ta bort</button>
      <button v-if="getUser.name != message.senderID " class="shadow button button-primary">Svara</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message: {}
    };
  },
  methods: {
    back() {
      this.$router.push("/admin");
    },
    setMessage() {
      this.message = this.getMessage;
      this.getSender.forEach(user => {
        if (this.message.senderID == user.userID) {
          this.message.senderID = user.name;
        }
      });
    },
    deleteMessage: async function() {
      let result = await fetch(
        "http://localhost:8080/message/" + this.message.messageID,
        { method: "DELETE" }
      );
      if (result.status == 200) {
        this.$router.push("/admin");
      }
    }
  },
  computed: {
    getMessage() {
      return this.$store.state.messageToDelete;
    },
    getSender() {
      return this.$store.state.AllUser;
    },
    getUser() {
      return this.$store.state.loggedInUser;
    }
  },
  created() {
    this.setMessage();
  }
};
</script>

<style scoped>
</style>