<template>
  <div class="newaccount container">
    <div class="row">
      <div class="col unselectable text-darkgray d-flex flex-column">
        <h2 class="title align-self-start">Skapa ny Klass</h2>
        <div class="line rounded" />
        <form class="mt-5">
          <div class="mt-5">
            <select name="education" id="education">
              <option value="Alexandra">Utbildning</option>
            </select>
            <select name="leader" id="leader">
              <option value="Alexandra">Ansvarig</option>
            </select>
          </div>
           <div class="mt-4">
            <input type="text" placeholder="Klassnamn" style="width:73%">
          </div>
          <div class="mt-5">
            <label for="from">Från:</label>
            <input type="date" id="from" />
            <label for="to">Till:</label>
            <input type="date" id="to" />
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
  width: 87%;
}
</style>