<template>
  <div class="root d-flex justify-content-center">
    <div class="main d-flex flex-column">
      <h2 class="align-self-start">Skapa ny utbildning</h2>
      <div class="content-line rounded" />

      <form>
        <div class="mt-5 d-flex justify-content-center">
          <input class="form-control" type="text" placeholder="Utbildningsnamn" id="edu-name" />
          <input class="form-control" type="number" placeholder="Poäng" id="edu-points" />
        </div>

        <div class="mt-4 d-flex justify-content-center">
          <select class="form-control" id="edu-leader">
            <option value="9">Utbildningsledare</option>
          </select>
        </div>

        <div class="mt-4 d-flex justify-content-center">
          <textarea
            class="form-control width-84"
            type="text"
            rows="6"
            placeholder="Beskrivning"
            id="edu-desc"
          />
        </div>
        <div class="button-create mt-4 d-flex justify-content-end">
          <button v-on:click="createEducation" type="button" class="button button-primary"> <span> Skapa </span> </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    async createEducation() {
      let newEducation = {
        name: document.getElementById("edu-name").value,
        point: parseFloat(document.getElementById("edu-points").value),
        leaderId: parseInt(document.getElementById("edu-leader").value),
        description: document.getElementById("edu-desc").value
      };

      let response = await fetch("http://localhost:8080/education", {
        method: "post",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newEducation)
      });
      let result = await response.json();
      console.log(result);
    }
  }
};
</script>