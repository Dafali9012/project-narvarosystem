<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-sm-9 d-flex">
        <div class="root d-flex justify-content-center">
          <div class="main d-flex flex-column">
            <h2 class="align-self-start">Skapa nytt konto</h2>
            <div class="content-line rounded" />

            <div
              v-if="this.accountIndex==0"
              class="unselectable mt-5 d-flex justify-content-center"
            >
              <div
                class="button-account border border-bottom-0 border-dark d-flex align-items-center justify-content-center"
              >
                <font-awesome-icon :icon="['fas','user-graduate']" class="align-self-center mr-3" />
                <p class="no-margin">Skapa nytt studentkonto</p>
              </div>
              <div
                v-on:click="changeAccountType(1)"
                class="button-account border border-gray d-flex align-items-center justify-content-center menu-link"
              >
                <font-awesome-icon
                  :icon="['fas','chalkboard-teacher']"
                  class="align-self-center text-muted mr-3"
                />
                <p class="no-margin text-muted">Skapa nytt EC konto</p>
              </div>
            </div>

            <div v-else class="unselectable mt-5 d-flex justify-content-center">
              <div
                v-on:click="changeAccountType(0)"
                class="button-account border border-gray d-flex align-items-center justify-content-center menu-link"
              >
                <font-awesome-icon
                  :icon="['fas','user-graduate']"
                  class="align-self-center text-muted mr-3"
                />
                <p class="no-margin text-muted">Skapa nytt studentkonto</p>
              </div>
              <div
                class="button-account border border-bottom-0 border-dark d-flex align-items-center justify-content-center"
              >
                <font-awesome-icon
                  :icon="['fas','chalkboard-teacher']"
                  class="align-self-center mr-3"
                />
                <p class="no-margin">Skapa nytt EC konto</p>
              </div>
            </div>

            <form @submit.prevent="createAccount()">
              <div class="mt-5 d-flex justify-content-center">
                <input v-model="name" class="form-control" type="text" placeholder="Förnamn" />
                <input v-model="lastName" class="form-control" type="text" placeholder="Efternamn" />
              </div>
              <div class="mt-4 d-flex justify-content-center">
                <input v-model="phone" class="form-control" type="text" placeholder="Telefon" />
                <input v-model="email" class="form-control" type="text" placeholder="Email" />
              </div>
              <div class="mt-4 d-flex justify-content-center">
                <input v-model="sin" class="form-control" type="text" placeholder="Personnummer" />
                <input v-model="address" class="form-control" type="text" placeholder="Address" />
              </div>
              <div class="mt-4 d-flex justify-content-center">
                <input
                  v-model="password"
                  class="form-control"
                  type="password"
                  placeholder="Lösenord"
                />
              </div>
              <div
                v-if="this.accountIndex==0"
                class="pic-input mt-4 d-flex flex-column align-items-start"
              >
                <p>Användarbild:</p>
                <input class="form-control no-margin width-100" type="file" placeholder="Bild" />
              </div>
              <div v-if="this.accountIndex==0" class="mt-4 d-flex justify-content-center">
                <select class="form-control" id="education" name="education">
                  <option value="education">Utbildning</option>
                </select>
                <select class="form-control" id="class" name="class">
                  <option value="class">Klass</option>
                </select>
              </div>
              <div class="button-create mt-4 d-flex justify-content-end">
                <button v-on:click="createAccount" type="submit" class="button button-primary">
                  <span>Skapa</span>
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CombinedSidebar from "@/components/CombinedSidebar.vue";

export default {
  data() {
    return {
      accountIndex: 0,
      name: "",
      lastName: "",
      email: "",
      phone: "",
      sin: "",
      address: "",
      password: ""
    };
  },
  components: {
    CombinedSidebar
  },
  methods: {
    changeAccountType(value) {
      this.accountIndex = value;
    },
    createAccount: async function() {
      if (this.accountIndex == 0) {
        var newUser = {
          name: this.name,
          lastName: this.lastName,
          email: this.email,
          phone: this.phone,
          sin: this.sin,
          address: this.address,
          password: this.password,
          roles: [
            {
              role: "STUDENT",
              roleID: 2
            }
          ]
        };
        console.log("skapa student account");
        const url = "http://localhost:8080/user";
        await fetch(url, {
          method: "POST",
          body: JSON.stringify(newUser),
          headers: {
            "Content-Type": "application/json"
          }
        });
      } else if (this.accountIndex == 1) {
        newUser = {
          name: this.name,
          lastName: this.lastName,
          email: this.email,
          phone: this.phone,
          sin: this.sin,
          address: this.address,
          password: this.password,
          roles: [
            {
              role: "TEACHER",
              roleID: 3
            }
          ]
        };
        const url = "http://localhost:8080/user";
        await fetch(url, {
          method: "POST",
          body: JSON.stringify(newUser),
          headers: {
            "Content-Type": "application/json"
          }
        });
        console.log("skapa ec account");
      }
    }
  }
};
</script>