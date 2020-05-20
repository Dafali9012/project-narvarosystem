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
          <select class="form-control" id="edu-leader" v-model="selectedPersonName">
            <option value="">Utbildningsledare</option>
            <option v-for="ecPers in ecPersonal" :key="ecPers.id">{{ecPers.name}}</option>
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
  data(){
    return{
      ecPersonal:[],
      selectedPersonName:"",
      selectedEcPersonalID: 0
    }
  },
  computed:{
  getEcPersonal(){
      return this.$store.state.AllUser
    }
  },
  methods: {
    setEcPersonal(){
      this.getEcPersonal.forEach(user  => {
        if(user.roles[0].roleID == 4){
          this.ecPersonal.push(user)
        }
      });
    },
    setSelectedPerson(){
     this.ecPersonal.forEach( user => {
       if(user.name == this.selectedPersonName){
         console.log(user.userID)
         this.selectedEcPersonalID = user.userID
      }
     })
    },
    async createEducation() {
      this.setSelectedPerson()
      let newEducation = {
        name: document.getElementById("edu-name").value,
        point: parseFloat(document.getElementById("edu-points").value),
        leaderId: this.selectedEcPersonalID,
        description: document.getElementById("edu-desc").value
      };
      console.log(newEducation)
      let response = await fetch("http://localhost:8080/education", {
        method: "post",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newEducation)
      });
      let result = await response.json();
      console.log(result);
    }
  },
  created(){
    this.setEcPersonal()
  }
};
</script>