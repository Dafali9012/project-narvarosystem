<template>
  <div class="col d-flex border-box row wrap">
    <div class="col-lg-8 col-sm-12 wrapper1">
        
    </div>
    <div class="col-4 wrapper2">
      <h2>Välkommen</h2>
      <form @submit.prevent="springLogin" class="inputs">
        <div>
          <input
          v-model="name"
            class="inputField"
            type="name"
            name="name"
            placeholder="name"
          />
        </div>
        <div>
          <input
          v-model="password"
            class="inputField"
            type="password"
            name="password"
            placeholder="password"
          />
        </div>
        <button type="submit" class="btn btn-info border mt-4" id="submitButton">Logga in</button>
      </form>
    </div>
    
    <!-- <form
      @submit.prevent="springLogin"
      class="col border rounded py-3 pl-5 text-left bg-light p-0 rounded"
      autocomplete="off"
    >
      <p class="font-weight-bold">Logga in</p>
      <div class="row d-flex mt-4">
        <input
          v-model="name"
          type="name"
          name="name"
          class="form-control col-4 ml-3"
          placeholder=""
          required
        />
        <label for="name" class="col-9 formlabel mt-2 ml-2">name</label>
      </div>
      <div class="row d-flex mt-4">
        <input
          v-model="password"
          type="password"
          name="password"
          class="form-control col-4 ml-3"
          placeholder=""
          required
        />
        <label for="password" class="col-9 formlabel mt-2 ml-2">Password</label>
      </div>
      <button type="submit" class="btn btn-info border mt-4" id="submitButton">Logga in</button>
    </form> -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: "",
      password: ""
    };
  },
  methods: {
    springLogin: async function() {
      const credentials =
        "username=" +
        encodeURIComponent(this.name) +
        "&password=" +
        encodeURIComponent(this.password);

      let response = await fetch("/rest/login", {
        method: "POST",
        redirect: "manual",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: credentials
        
      });

      if (response.url.includes("error")) {
        window.confirm("Inloggningen misslyckades");
      } else {

        this.$store.dispatch('updateLoggedUser')
        this.$router.push("/");
        console.log(this.$store.state.loggedInUser)
        
      }
    }
  }
};
</script>

<style scoped>
    .wrap {
    padding: 0;
    }
    .wrapper1 {
    background-image: url("../assets/images/EC-utb.png");
    background-size: 100%;
    background-repeat: no-repeat;
    height: 100vh;
}
    .wrapper2 {
    align-content: center;
    padding-top: 20vh;
    border-bottom-right-radius: 5px;
}
    .inputField {
    font-family: "Nunito", sans-serif;
    font-size: 16px;
    color: rgb(59, 59, 59);
    line-height: 1.2;
    width: 250px;
    height: 45px;
    background-position: center;
    padding: 0 5px 0 38px;
    box-shadow: 0 0 10px #2727279f inset;
    background-color: rgba(255, 255, 255, 0.9);
    border: 1px solid #2b2b2b;
    transition: all 0.5s ease;
    margin-top: 10px;
    border-radius: 5px;
}

    .btn {
    width: 125px;
    height: 50px;
    font-size: 25px;
    text-align: center;
    background: rgb(238, 238, 238);
    color: #f7f7f7;
    border-radius: 10px;
    border-color: #f7f7f7;
    background-color: #0e6dee;
    align-self: flex-end;
}
@media screen and (max-width: 500px) {
  .wrapper1 {
  }
}
</style>