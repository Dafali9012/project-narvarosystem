<template>
<div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-sm-9 d-flex">
        <div class="root d-flex justify-content-center">
          <div class="main d-flex flex-column">
            <h2 class="align-self-start">Redigera konto</h2>
            <div class="content-line rounded" />

            <form @submit.prevent="updateAccount()">
              <div class="mt-5 d-flex justify-content-center" >
                <input
                  disabled
                  :value="getLoggedUser.first_name"
                  class="form-control"
                  type="text"
                  placeholder="Förnamn"
                  style="width: 35%"
                  id="first-name"
                />
                <input
                  
                  class="form-control"
                  type="text"
                  placeholder="Efternamn"
                  style="width: 35%"
                  id="last-name"
                />
              </div>
              <div class="mt-5 d-flex justify-content-center">
                <input
                  
                  class="form-control"
                  type="text"
                  placeholder="Telefon"
                  style="width: 20%"
                  id="telephone"
                />
                <input
                  
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
                  <span>Spara</span>
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
  components: {
    CombinedSidebar
  },
  computed: {
    getLoggedUser() {
      return this.$store.state.loggedInUser
    }
  },
  data() {
    return {
      accountIndex:1
    }
  },
  methods: {
    updateAccount() {

    }
  }
}
</script>