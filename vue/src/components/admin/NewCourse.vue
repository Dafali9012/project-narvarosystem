<template>
  <div class="root d-flex justify-content-center">
    <div class="main d-flex flex-column">
      <h2 class="align-self-start">Skapa ny kurs</h2>
      <div class="line rounded" />

      <form>
        <div class="mt-5 d-flex justify-content-center">
          <input class="form-control" type="text" placeholder="Kursnamn" />
          <input class="form-control" type="number" placeholder="Poäng" />
        </div>

        <div class="mt-4 d-flex unselectable">
          <label for="from" style="margin-left:9%">Från:</label>
          <label for="to" style="margin-left:39%">Till:</label>
        </div>
        <div class="d-flex justify-content-center">
          <input class="form-control" type="date" id="from" />
          <input class="form-control" type="date" id="to" />
        </div>
        <div class="mt-4 d-flex justify-content-center">
          <select class="form-control full-width" id="teacher" name="teacher">
            <option value="teacher">Lärare</option>
          </select>
        </div>
        <div class="mt-4 d-flex justify-content-center">
          <textarea class="form-control full-width" type="text" rows="3" placeholder="Beskrivning" />
        </div>
        <div class="button-create mt-4 d-flex justify-content-end">
          <button v-on:click="createCourse" type="button" class="btn btn-primary">Skapa</button>
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
.full-width {
  width: 84%;
}
.button-create {
  margin-right: 8%;
}
</style>

<script>
export default {
  methods: {
    createCourse() {
      console.log("skapa kurs");
    }
  }
};
</script>