<template>
  <div class="col d-flex border-box row wrap">
    <div class="col-lg-8 col-sm-12 wrapper1"></div>
    <div class="col-4 wrapper2">
      <h2>Välkommen</h2>
      <form class="inputs">
        <div>
          <input
            class="inputField"
            type="text"
            name="email"
            placeholder="Email"
          />
          <font-awesome-icon :icon="['fas','user-graduate']" class="" id="icon" />
        </div>
        <div>
          <input
            class="inputField"
            type="password"
            name="password"
            placeholder="Lösenord"
          />
          <font-awesome-icon :icon="['fas','user-graduate']" class="" id="icon" />
        </div>
        <div class="d-flex row mt-5 align-items-center justify-content-around">
        <div class="d-flex flex-column">
            <input type="checkbox" id="remember" name="remember">
            <label for="remember"> Kom ihåg mig </label>
        <span class="extras">
          <a class="redirect" href="/reset">Glömt lösenord?</a>
        </span>
        </div>
        <input type="button" value="Logga in" class="btn" /> <!-- v-on:click="login" -->
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
    name: 'Login',
}
</script>

<style scoped>
#remember {
    
}
.redirect {
  color:rgba(0, 0, 0, 0.658);
  text-decoration: none;
}
.redirect:visited {
  color:rgba(0, 0, 0, 0.658);
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