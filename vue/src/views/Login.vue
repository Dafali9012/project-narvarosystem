<template>
  <div class="col d-flex border-box row wrap">
    <div class="col-lg-8 col-sm-12 wrapper1">
        
    </div>
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
        </div>
        <div>
          <input
            class="inputField"
            type="password"
            name="password"
            placeholder="Lösenord"
          />
        </div>
        <input type="button" value="Logga in" class="btn mt-5"/>
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