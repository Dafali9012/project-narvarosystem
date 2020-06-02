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
              v-if="this.accountIndex == 0"
              class="unselectable mt-5 d-flex justify-content-center"
            >
              <div
                class="button-account border border-bottom-0 border-dark d-flex align-items-center justify-content-center fa-lg"
              >
                <font-awesome-icon :icon="['fas', 'user-graduate']" class="align-self-center mr-3" />
                <p class="no-margin">Skapa nytt studentkonto</p>
              </div>
              <div
                v-on:click="changeAccountType(1)"
                class="button-account border border-gray d-flex align-items-center justify-content-center menu-link"
                style="transition: all 0.5s;"
              >
                <font-awesome-icon
                  :icon="['fas', 'chalkboard-teacher']"
                  class="align-self-center text-muted mr-3"
                />
                <p class="no-margin text-muted">Skapa nytt EC konto</p>
              </div>
            </div>

            <div v-else class="unselectable mt-5 d-flex justify-content-center">
              <div
                v-on:click="changeAccountType(0)"
                class="button-account border border-gray d-flex align-items-center justify-content-center menu-link"
                style="transition: all 0.5s;"
              >
                <font-awesome-icon
                  :icon="['fas', 'user-graduate']"
                  class="align-self-center text-muted mr-3"
                />
                <p class="no-margin text-muted">Skapa nytt studentkonto</p>
              </div>
              <div
                class="button-account border border-bottom-0 border-dark d-flex align-items-center justify-content-center fa-lg"
              >
                <font-awesome-icon
                  :icon="['fas', 'chalkboard-teacher']"
                  class="align-self-center mr-3"
                />
                <p class="no-margin">Skapa nytt EC konto</p>
              </div>
            </div>

            <form @submit.prevent="createAccount()">
              <div class="mt-5 d-flex justify-content-center" >
                <input
                  v-model="name"
                  class="form-control"
                  type="text"
                  placeholder="Förnamn"
                  style="width: 35%"
                  id="first-name"
                />
                <input
                  v-model="lastName"
                  class="form-control"
                  type="text"
                  placeholder="Efternamn"
                  style="width: 35%"
                  id="last-name"
                />
              </div>
              <div class="mt-5 d-flex justify-content-center">
                <input
                  v-model="phone"
                  class="form-control"
                  type="text"
                  placeholder="Telefon"
                  style="width: 20%"
                  id="telephone"
                />
                <input
                  v-model="email"
                  class="form-control"
                  type="text"
                  placeholder="Email"
                  style="width: 40%"
                  id="email"
                />
              </div>
              <div class="mt-4 d-flex justify-content-center">
                <input
                  class="form-control"
                  type="text"
                  placeholder="Personnummer"
                  style="width: 20%"
                  id="ssn"
                />
                <input
                  id="password"
                  class="form-control"
                  style="width: 40%; "
                  type="password"
                  placeholder="Lösenord"
                />
              </div>
              <div class="mt-4 d-flex justify-content-start"></div>
              <div
                v-if="this.accountIndex == 0"
                class="pic-input mt-4 d-flex flex-column"
                style="margin-left: 30%"
              >
                <p>Användarbild:</p>
                <input class="form-control no-margin mb-4 height-100 width-100" type="file" />
              </div>
              <div class="d-flex justify-content-center mt-4">
                <select class="form-control" id="role" name="role" style="width: 40%;">
                  <option disabled selected>Välj roll</option>
                  <option
                    :value="role.id"
                    v-for="role in getRoles"
                    :key="role.id"
                  >{{ role.name }}</option>
                </select>
              </div>
              <div v-if="this.accountIndex == 0" class="mt-4 d-flex justify-content-center">
                <select class="form-control" id="education" name="education" style="width: 35%">
                  <option disabled selected>Välj utbildning</option>
                  <option
                    :value="education.id"
                    v-for="education in getEducations"
                    :key="education.id"
                  >{{ education.name }}</option>
                </select>
                <select class="form-control" id="class" name="class" style="width: 35%">
                  <option disabled selected>Välj klass</option>
                  <option
                    :value="edClass.id"
                    v-for="edClass in getClasses"
                    :key="edClass.id"
                  >{{ edClass.name }}</option>
                </select>
              </div>
              
              <div class="button-create mt-4 d-flex justify-content-end">
                <button type="submit" class="button button-primary" style="margin-left: 20%">
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
  created() {
    this.$store.dispatch("getRoles");
    this.$store.dispatch("getAllEducations");
    this.$store.dispatch("getAllClasses");
  },
  computed: {
    getRoles() {
      return this.$store.state.roles;
    },
    getEducations() {
      return this.$store.state.AllEducation;
    },
    getClasses() {
      return this.$store.state.AllClass;
    }
  },
  data() {
    return {
      accountIndex: 0
    };
  },
  components: {
    CombinedSidebar
  },
  methods: {
    changeAccountType(value) {
      this.accountIndex = value;
    },
    async createAccount() {
      let response;
      let result;

      let newUser = {
        first_name: document.getElementById("first-name").value,
        last_name: document.getElementById("last-name").value,
        email: document.getElementById("email").value,
        phone_number: document.getElementById("telephone").value,
        password: document.getElementById("password").value,
        ssn: document.getElementById("ssn").value,
        role_id: document.getElementById("role").value
      };

      response = await fetch("http://localhost:8080/user", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newUser)
      });

      result = await response.json();
      console.log(result);

      if (this.accountIndex == 1) {
        let newPersonnel = {
          user_id: result.id
        };

        response = await fetch("http://localhost:8080/personnel", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(newPersonnel)
        });
      } else if (this.accountIndex == 0) {
        let newStudent = {
          user_id: result.id,
          class_id: document.getElementById("class").value,
          picture: null
        };

        response = await fetch("http://localhost:8080/student", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(newStudent)
        });
      }
    }
  }
};
</script>
