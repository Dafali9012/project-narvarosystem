<template>
  <div class="root d-flex justify-content-center">
    <div class="main d-flex flex-column">
      <h2 class="align-self-start">Skapa ny utbildning</h2>
      <div class="content-line rounded" />

      <form>
        <div class="mt-5 d-flex justify-content-center">
          <input class="form-control" type="text" placeholder="Utbildningsnamn" />
          <input class="form-control" type="number" placeholder="Poäng" />
        </div>
        <div class="mt-4 d-flex justify-content-center">
          <textarea class="form-control width-84" type="text" rows="6" placeholder="Beskrivning" />
        </div>
            
        <div class="button-create mt-4 d-flex justify-content-end">
          <button v-on:click="createEducation" type="button" class="btn btn-primary">Skapa</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    createEducation() {
      console.log("skapa utbildning");
    }
  }
};
</script>