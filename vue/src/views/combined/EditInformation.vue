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
              <div class="mt-5 d-flex justify-content-center">
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
                  disabled
                  :value="getLoggedUser.last_name"
                  class="form-control"
                  type="text"
                  placeholder="Efternamn"
                  style="width: 35%"
                  id="last-name"
                />
              </div>
              <div class="mt-5 d-flex justify-content-center">
                <input
                  :value="getLoggedUser.phone_number"
                  class="form-control"
                  type="text"
                  placeholder="Telefon"
                  style="width: 20%"
                  id="telephone"
                />
                <input
                  disabled
                  :value="getLoggedUser.email"
                  class="form-control"
                  type="text"
                  placeholder="Email"
                  style="width: 40%"
                  id="email"
                />
              </div>
              <div class="mt-4 d-flex justify-content-center">
                <input
                  disabled
                  :value="getLoggedUser.ssn"
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
                  placeholder="Ändra lösenord"
                />
              </div>
              <div class="mt-4 d-flex justify-content-start"></div>
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
      return this.$store.state.loggedInUser;
    }
  },
  data() {
    return {};
  },
  methods: {
    updateAccount() {}
  }
};
</script>