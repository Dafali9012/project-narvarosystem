<template>
  <div class="container-fluid mt-2">
    <div v-if="replyMode" class="container-fluid p-5 shadow">
      <div class="input-group input-group-lg p-2">
        <div class="input-group-prepend"><h5 class="text-center py-2 alert alert-primary">Till:{{message.sender_id}}</h5></div>
      </div>
      <div class="input-group input-group-lg p-2">
        <div class="input-group-prepend"><h5 class="text-center py-2 alert alert-primary">Ämne: Re:{{message.subject}}</h5></div>
      </div>
      <div class="input-group">
        <div class="input-group-prepend"></div>
        <textarea v-model="messageReply" class="form-control alert alert-primary" aria-label="With textarea"></textarea>
      </div>
    </div>
    <fieldset disabled>
      <div class>
        <h5
          class="text-secondary text-left rounded border bg-white shadow p-2 m-3"
        >Från: {{message.sender_id}}</h5>
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
      <button class="shadow button button-primary" v-on:click="back">Gå tillbaka</button>
      <button class="shadow button button-primary" v-on:click="deleteMessage">Ta bort</button>
      <button
        v-on:click="reply_mode"
        v-if="getUser.first_name != message.sender_id && !replyMode"
        class="shadow button button-primary"
      >Svara</button>
      <button
        v-if="replyMode"
        v-on:click="reply"
        class="shadow button button-primary"
      >Skicka</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message: {},
      replyMode: false,
      messageReply:""
    };
  },
  methods: {
   async reply(){
      this.getSender.forEach(user => {
        if (this.message.sender_id == user.first_name) {
          this.message.sender_id = user.id;
        }
      });
      
      let reply_message = {
        date: new Date(),
        message:this.messageReply,
        receiver_id: this.message.sender_id,
        sender_id: this.message.receiver_id,
        subject: this.message.subject
      }
   
      let response = await fetch("http://localhost:8080/message", {
        method: "post",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(reply_message)
      });
      let result = await response.json();
      console.log('result',result);
      this.reply_mode();
      this.setMessage();
    },
    reply_mode(){
      if(this.replyMode){
        this.replyMode = false
      }else{
        this.replyMode = true
      }
    },
    back() {
      this.$router.push("/admin");
    },
    setMessage() {
      this.message = this.getMessage;
      this.getSender.forEach(user => {
        if (this.message.sender_id == user.id) {
          this.message.sender_id = user.first_name;
        }
      });
    },
    deleteMessage: async function() {
      let result = await fetch(
        "http://localhost:8080/message/" + this.message.message_id,
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
     this.$store.dispatch("getMessage");
  }
};
</script>

<style scoped>
</style>