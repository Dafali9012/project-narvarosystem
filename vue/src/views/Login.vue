<template>
  <div class="container">
    <div class="row">
      <div class="col d-flex border-box row wrap">
        <div class="col-lg-8 col-sm-12 wrapper1"></div>
        <div class="col-4 wrapper2">
          <h2>Välkommen</h2>
          <form @submit.prevent="springLogin" class="inputs">
            <div>
              <input v-model="email" class="inputField" type="email" name="email" placeholder="Email" />
              <font-awesome-icon :icon="['fas', 'user']" class="fa-lg" id="icon" />
            </div>
            <div>
              <input
                v-model="password"
                class="inputField"
                type="password"
                name="password"
                placeholder="Lösenord"
              />
              <font-awesome-icon :icon="['fas', 'key']" class="fa-lg" id="icon" />
            </div>
            <div class="d-flex mt-5 align-items-center justify-content-around">
              <div class="d-flex flex-column">
                <div class="d-flex justify-content-center">
                  <input type="checkbox" id="remember" name="remember" />
                  <label for="remember">Kom ihåg mig</label>
                </div>
                <span class="extras">
                  <a class="redirect ml-2" href="/reset">Glömt lösenord?</a>
                </span>
              </div>
              <button type="submit" class="btn btn-info border" id="submitButton">
                <span>Logga in</span>
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      email: "",
      password: ""
    };
  },
  methods: {
   async springLogin() {
      const credentials =
        "username=" +
        encodeURIComponent(this.email) +
        "&password=" +
        encodeURIComponent(this.password);

      let response = await fetch("/rest/login", {
        method: "POST",
        redirect: "manual",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: credentials
      });
      console.log(response)
      if (response.status == "500") {
        window.confirm("Inloggningen misslyckades");
      } else {
        this.$store.dispatch("updateLoggedUser");
        this.$router.push('/welcome')
      }
    },

  }
};
</script>

<style scoped>
.container {
  max-width: 100vw;
}
.wrap {
  padding: 0;
}
#remember {
  width: 10% !important;
  margin-top: 3px;
}
.redirect {
  color: rgba(0, 0, 0, 0.658);
  text-decoration: none;
}
.redirect:visited {
  color: rgba(0, 0, 0, 0.658);
  text-decoration: none;
}
h2 {
  padding-bottom: 100px;
  font-size: 60px;
}
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
.inputs {
  align-items: center;
}
.inputField {
  font-family: "Nunito", sans-serif;
  font-size: 16px;
  color: rgba(0, 0, 0, 0.658);
  width: 50%;
  height: 45px;
  background: transparent;
  outline: none;
  border: none;
  border-bottom: 1.5px solid rgba(0, 0, 0, 0.356);
  margin-bottom: 30px;
  align-items: center;
  padding-left: 20px;
  font-size: 20px;
}

.btn {
  width: 150px;
  height: 50px;
  font-size: 25px;
  text-align: center;
  background: rgb(238, 238, 238);
  color: #f7f7f7;
  border-radius: 10px;
  border-color: #f7f7f7;
  background-color: #518ee2;
  cursor: pointer;
  transition: all 0.5s;
}
.btn span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}
.btn span:after {
  content: "\00bb";
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}
.btn:hover span {
  padding-right: 25px;
}
.btn:hover span:after {
  opacity: 1;
  right: 0;
}
/*
@media screen and (max-width: 500px) {
  .wrapper1 {
  }
}
*/
</style>
