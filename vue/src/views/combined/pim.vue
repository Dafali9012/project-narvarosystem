<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="row">
          <div class="col-9">
            <div class="tab-content" id="nav-tabContent">
              <div
                class="tab-pane fade show active"
                id="list-home"
                role="tabpanel"
                aria-labelledby="list-home-list"
              >
                <form action class="send-form">
                  <div class="form-group d-flex justify-content-center">
                    <label for="exampleFormControlInput1"></label>
                    <input
                      type="text"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Ämne"
                      v-model="message.subject"
                    />

                    <label for="exampleFormControlSelect1"></label>
                    <select
                      class="form-control"
                      id="exampleFormControlSelect1"
                      v-model="receiverUser"
                    >
                      <option>Mottagare</option>
                      <option v-for="user in allUsers" :key="user.user_id">{{user.first_name}}</option>
                    </select>
                  </div>
                  <div class="form-group text d-flex justify-content-end">
                    <label for="exampleFormControlTextarea1"></label>
                    <textarea
                      class="form-control"
                      id="exampleFormControlTextarea1"
                      rows="3"
                      placeholder="Innehållstext"
                      v-model="message.message"
                    ></textarea>
                  </div>
                  <div class="d-flex justify-content-center">
                    <button type="button" class="btn btn-primary" v-on:click="send">Skicka</button>
                  </div>
                </form>
              </div>
              <div
                class="tab-pane fade"
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
                id="list-messages"
                role="tabpanel"
                aria-labelledby="list-messages-list"
              >
                <vue-bootstrap4-table
                  :rows="rowsSent"
                  :columns="columnsSent"
                  :config="configSent"
                  @on-select-row="getInfo($event)"
                />
              </div>
            </div>
          </div>
          <div class="col-3 justify-content-end">
            <div class="list-group" id="list-tab" role="tablist">
              <a
                class="list-group-item list-group-item-action active"
                id="list-home-list"
                data-toggle="list"
                href="#list-home"
                role="tab"
                aria-controls="home"
              >Skicka</a>
              <a
                v-on:click="cons"
                class="list-group-item list-group-item-action"
                id="list-profile-list"
                data-toggle="list"
                href="#list-profile"
                role="tab"
                aria-controls="profile"
              >Mottagna</a>
              <a
                v-on:click="consSent"
                class="list-group-item list-group-item-action"
                id="list-messages-list"
                data-toggle="list"
                href="#list-messages"
                role="tab"
                aria-controls="messages"
              >Skickade</a>
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