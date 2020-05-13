<template>
  <div class="newaccount container">
    <div class="row">
      <div class="col unselectable text-darkgray d-flex flex-column">
        <h2 class="title align-self-start">Skapa nytt konto</h2>
        <div class="line rounded" />
        <div class="account-selector d-flex justify-content-center">
          <div
            class="account-button border border-bottom-0 border-dark d-flex align-items-center justify-content-center"
          >
            <font-awesome-icon :icon="['fas','user-graduate']" class="align-self-center mr-3" />
            <p class="no-margin">Skapa nytt elevkonto</p>
          </div>
          <div
            class="account-button border border-dark d-flex align-items-center justify-content-center"
          >
            <font-awesome-icon :icon="['fas','chalkboard-teacher']" class="align-self-center mr-3" />
            <p class="no-margin">Skapa nytt EC konto</p>
          </div>
        </div>
        <form>
          <div class="mt-5">
            <input type="text" placeholder="Förnamn" />
            <input type="text" placeholder="Efternamn" />
          </div>
          <div class="mt-4">
            <input type="text" placeholder="Epost" />
            <input type="text" placeholder="Telefonnummer" />
          </div>
          <div class="mt-4">
            <input type="text" placeholder="Personnummer" />
            <input type="text" placeholder="Adress" />
          </div>
          <div class="mt-4">
            <select id="education" name="education">
              <option value="education">Utbildning</option>
            </select>
            <select id="class" name="class">
              <option value="class">Klass</option>
            </select>
          </div>
          <div class="button mt-4 d-flex justify-content-end">
              <button type="button" class="btn btn-primary">Skapa</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<style scoped>
form {
  width: 80%;
}
input,
select {
  width: 36%;
  margin-left: 1%;
  margin-right: 1%;
}
.title {
  margin-top: 10%;
}
.newaccount {
  width: 100%;
  height: 100%;
}
.line {
  height: 0.1em;
  width: 80%;
  background-color: #28343a;
}
.account-selector {
  margin-top: 2%;
  width: 80%;
}
.account-button {
  height: 5vh;
  width: 40%;
}
.button {
    width:87%;
}
</style>