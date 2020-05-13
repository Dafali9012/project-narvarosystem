<template>
  <div class="root d-flex justify-content-center">
    <div class="main d-flex flex-column">
      <h2 class="align-self-start">Skapa nytt konto</h2>
      <div class="line rounded" />

      <div v-if="this.accountIndex==0" class="unselectable mt-5 d-flex justify-content-center">
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
          <font-awesome-icon :icon="['fas','chalkboard-teacher']" class="align-self-center mr-3" />
          <p class="no-margin">Skapa nytt EC konto</p>
        </div>
      </div>

      <form>
        <div class="mt-5 d-flex justify-content-center">
          <input class="form-control" type="text" placeholder="Förnamn" />
          <input class="form-control" type="text" placeholder="Efternamn" />
        </div>
        <div class="mt-4 d-flex justify-content-center">
          <input class="form-control" type="text" placeholder="Epost" />
          <input class="form-control" type="text" placeholder="Telefonnummer" />
        </div>
        <div class="mt-4 d-flex justify-content-center">
          <input class="form-control" type="text" placeholder="Personnummer" />
          <input class="form-control" type="text" placeholder="Adress" />
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
          <button v-on:click="createAccount" type="button" class="btn btn-primary">Skapa</button>
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped>
.root {
  width: 100%;
  height: 100%;
}
.main {
  width: 65%;
  margin-top: 5%;
  margin-left: 0%;
}
.line {
  height: 0.1em;
  width: 100%;
  background-color: #28343a;
}
input,
select {
  width: 40%;
  margin-left: 2%;
  margin-right: 2%;
}
.button-account {
  height: 5vh;
  width: 40%;
}
.button-create {
  margin-right: 8%;
}
</style>

<script>
export default {
  data() {
    return {
      accountIndex: 0
    };
  },
  methods: {
    changeAccountType(value) {
      this.accountIndex = value;
    },
    createAccount() {
      if (this.accountIndex == 0) {
        console.log("skapa student account");
      } else if (this.accountIndex == 1) {
        console.log("skapa ec account");
      }
    }
  }
};
</script>