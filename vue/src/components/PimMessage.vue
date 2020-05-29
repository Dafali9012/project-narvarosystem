<template>
<div class="root d-flex flex-column container-fluid">
  <div class="content row mt-3">
    <div class="admin-sidebar col-3">
      <CombinedSidebar />
    </div>
      <div class="p-0" style="height: 60vh; ">
        <div class="col-9 d-flex align-items-center">
          <div class="list-group" id="list-tab" role="tablist">
            <a
              class="list-group-item list-group-item-action active"
              style="width: 200px; border-radius: 15px;"
              id="list-home-list"
              data-toggle="list"
              href="#list-home"
              role="tab"
              aria-controls="home"
            >
              <font-awesome-icon
                :icon="['fas', 'paper-plane']"
                class="align-self-center mr-2 fa-lg"
                id="icon"
              />Nytt meddelande
            </a>
            <a
              v-on:click="cons"
              class="list-group-item list-group-item-action mt-2"
              style="width: 135px; border-radius: 15px;"
              id="list-profile-list"
              data-toggle="list"
              href="#list-profile"
              role="tab"
              aria-controls="profile"
            >
              <font-awesome-icon
                :icon="['fas', 'inbox']"
                class="align-self-center mr-1 fa-md"
                id="icon"
              />Inkorg
            </a>
            <a
              v-on:click="consSent"
              class="list-group-item list-group-item-action mt-2"
              style="width: 135px; border-radius: 15px;"
              id="list-messages-list"
              data-toggle="list"
              href="#list-messages"
              role="tab"
              aria-controls="messages"
            >
              <font-awesome-icon
                :icon="['fas', 'share-square']"
                class="align-self-center mr-1 fa-md"
                id="icon"
              />Skickat
            </a>
          </div>
        </div>
        <div class="col-12 d-flex align-items-end" style>
          <div class="tab-content" id="nav-tabContent" style="width: 60%; margin-bottom: 5vh;">
            <div
              class="tab-pane fade show active"
              id="list-home"
              role="tabpanel"
              aria-labelledby="list-home-list"
            >
              <form action class="send-form">
                <div class="form-group">
                  <label for="exampleFormControlSelect1">Vem vill du skriva till?</label>
                  <select
                    required
                    class="form-control"
                    style="min-width: 100%; margin-left:0;"
                    id="exampleFormControlSelect1"
                    v-model="receiverUser"
                  >
                    <option value disabled selected>Mottagare</option>
                    <option v-for="user in allUsers" :key="user.userID">{{user.name}}</option>
                  </select>

                  <label for="exampleFormControlInput1"></label>
                  <input
                    type="text"
                    class="form-control"
                    style="min-width: 100%; margin-left:0;"
                    id="exampleFormControlInput1"
                    placeholder="Ämne"
                    v-model="message.subject"
                  />
                </div>
                <div class="form-group text d-flex">
                  <label for="exampleFormControlTextarea1"></label>
                  <textarea
                    style="resize: none; width: 100%;"
                    maxlength="500"
                    class="form-control"
                    id="exampleFormControlTextarea1"
                    rows="5"
                    placeholder="Skriv något ..."
                    v-model="message.message"
                  ></textarea>
                </div>
                <div class="d-flex justify-content-center">
                  <button type="button" class="button button-primary" v-on:click="send">
                    <span>Skicka</span>
                  </button>
                </div>
              </form>
            </div>
            <div
              class="tab-pane fade"
              style="margin-bottom: 10vh; width: 100%;"
              id="list-profile"
              role="tabpanel"
              aria-labelledby="list-profile-list"
            >
              <vue-bootstrap4-table
                :rows="rows"
                :columns="columns"
                :config="config"
                @on-select-row="getInfo($event)"
              ></vue-bootstrap4-table>
            </div>
            <div
              class="tab-pane fade"
              style="margin-bottom: 10vh"
              id="list-messages"
              role="tabpanel"
              aria-labelledby="list-messages-list"
            >
              <vueTable
                :rows="rowsSent"
                :columns="columnsSent"
                :config="configSent"
                @on-select-row="getInfo($event)"
              />
            </div>
          </div>
        </div>
      </div>
  </div>
</div>
</template>

<script>
import CombinedSidebar from "@/components/CombinedSidebar.vue";
import VueBootstrap4Table from "vue-bootstrap4-table";

export default {
  components: {
    VueBootstrap4Table,
    CombinedSidebar
  },
  name: "Pim",
  data() {
    return {
      columnsSent: [
        {
          label: "Ämne",
          name: "subject",
          sort: true
        },
        {
          label: "Meddelande",
          name: "message",
          sort: false
        },
        {
          label: "Till",
          name: "receiver_id",
          sort: true
        },
        {
          label: "Datum",
          name: "date",
          sort: true
        }
      ],
      columns: [
        {
          label: "Ämne",
          name: "subject",
          sort: true
        },
        {
          label: "Meddelande",
          name: "message",
          sort: false
        },
        {
          label: "Från",
          name: "sender_id",
          sort: true
        },
        {
          label: "Datum",
          name: "date",
          sort: true
        }
      ],
      config: {
        checkbox_rows: true,
        rows_selectable: true,
        pagination: false,
        pagination_info: false,
        show_refresh_button: false,
        show_reset_button: false,
        global_search: {
          placeholder: "Sök",
          visibility: false
        },
        card_title: "Mottagna meddelanden"
      },
      configSent: {
        checkbox_rows: true,
        rows_selectable: true,
        pagination: false,
        pagination_info: false,
        show_refresh_button: false,
        show_reset_button: false,
        global_search: {
          placeholder: "Sök",
          visibility: false
        },
        card_title: "Skickade meddelanden"
      },
      allUsers: [],
      loggedUser: {},
      receiverUser: {},
      message: {
        sender_id: "",
        receiver_id: "",
        subject: "",
        message: "",
        date: ""
      },
      userReceivedMessages: [],
      userSentMessages: []
    };
  },
  computed: {
    getUsers() {
      return this.$store.state.AllUser;
    },
    getLoggedUser() {
      return this.$store.state.loggedInUser;
    },
    getReceivedMessages() {
      return this.$store.state.Messages;
    },
    rows: {
      get() {
        return this.userReceivedMessages;
      }
    },
    rowsSent: {
      get() {
        return this.userSentMessages;
      }
    }
  },
  async created() {
    await this.setSentMessages();
    await this.setReceivedMassage();
    await this.setUsers();
    await this.setLoggedUser();
  },
  methods: {
    setUsers() {
      this.getUsers.forEach(user => {
        if (user) {
          this.allUsers.push(user);
        }
      });
    },

    setLoggedUser() {
      this.loggedUser = this.getLoggedUser;
    },

    setReceiver() {
      this.allUsers.forEach(user => {
        if (user.first_name == this.receiverUser) {
          this.receiverUser = user;
        }
      });
    },

    setReceivedMassage() {
      this.getReceivedMessages.forEach(message => {
        if (message.receiver_id == this.loggedUser.id) {
          this.allUsers.forEach(user => {
            if (message.sender_id == user.id) {
              message.sender_id = user.first_name;
            }
          });
          if (message.message.length >= 8) {
            message.message = message.message.substring(0, 10) + "...";
            this.userReceivedMessages.push(message);
          } else {
            this.userReceivedMessages.push(message);
          }
        }
      });
    },
    setSentMessages() {
      this.getReceivedMessages.forEach(message => {
        if (message.sender_id == this.loggedUser.id) {
          this.allUsers.forEach(user => {
            if (message.receiver_id == user.id) {
              message.receiver_id = user.first_name;
            }
          });
          if (message.message.length >= 8) {
            message.message = message.message.substring(0, 10) + "...";
            this.userSentMessages.push(message);
          } else {
            this.userSentMessages.push(message);
          }
        }
      });
    },
    async send() {
      this.setReceiver();
      this.message.sender_id = this.loggedUser.id;
      this.message.receiver_id = this.receiverUser.id;
      let today = new Date();
      this.message.date = today;
      let response = await fetch("http://localhost:8080/message", {
        method: "post",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(this.message)
      });
      let result = await response.json();
      console.log(result);
      console.log(this.message);
    },

    cons() {
      this.userReceivedMessages.length = 0;
      this.$store.dispatch("getMessage");
      this.setReceivedMassage();
    },

    consSent() {
      this.userSentMessages.length = 0;
      this.$store.dispatch("getMessage");
      this.setSentMessages();
    },

    getInfo($event) {
      this.$store.dispatch("getMessage");
      let selectedMessage = $event.selected_item;
      this.getReceivedMessages.forEach(message => {
        if (message.message_id == selectedMessage.message_id) {
          this.$store.dispatch("getMessage");
          this.$store.commit("setMessageToDelete", message);
        }
      });
      this.$router.push("/message");
    }
  }
};
</script>

<style scoped>
tr .overflow-hidden {
  background: blue !important;
  text-overflow: ellipsis !important;
}
#nav-tabContent {
  /*margin-top: 20vh;*/
}
</style>

