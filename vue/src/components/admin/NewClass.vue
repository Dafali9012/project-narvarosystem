<template>
  <div class="root d-flex justify-content-center">
    <div class="main d-flex flex-column">
      <h2 class="align-self-start">Skapa ny klass</h2>
      <div class="content-line rounded" />

      <form>
        <div class="mt-5 d-flex justify-content-center">
          <select class="form-control width-42" id="teacher" name="teacher" v-model="classroom.edID">
            <option value="">Utbildning</option>
            <option v-for="education in allEducation" :key="education.edID">{{education.name}}</option>
          </select>
          <select  class="form-control" id="leader" name="leader" v-model="classroom.teacherID">
            <option  value="" disabled selected>Ansvarig</option>
            <option v-for="ecPers in ecPersonal" :key="ecPers.id">{{ecPers.name}}</option>
          </select>
        </div>
        <div class="mt-4 d-flex justify-content-center">
          <input class="form-control width-84" type="text" placeholder="Klassnamn" v-model="classroom.name"/>
        </div>

        <div class="mt-4 d-flex unselectable">
          <label for="from" style="margin-left:9%">Från:</label>
          <label for="to" style="margin-left:39%">Till:</label>
        </div>
        <div class="d-flex justify-content-center">
          <input class="form-control" type="date" id="from" v-model="classroom.startDate"/>
          <input class="form-control" type="date" id="to" v-model="classroom.endDate"/>
        </div>
        <div class="button-create mt-4 d-flex justify-content-end">
          <button v-on:click="addClass" type="button" class="btn btn-primary">Skapa</button>
        </div>
      </form>
      <button v-on:click="cons">Click</button>
    </div>
  </div>
</template>

<script>
export default {
  data(){
    return{
      ecPersonal:[],
      allEducation:[],
      classroom:{
        name: "",
        startDate: "",
        endDate: "",
        edID: "",
        teacherID:""
      }
    }
  },
  computed:{
    getUsers(){
      return this.$store.state.AllUser;
    },
    getAllEducation(){
      return this.$store.state.AllEducation
    }
  },
  methods: {
    getPersonal(){
      this.getUsers.forEach(user  => {
        if(user.roles[0].roleID == 3){
          this.ecPersonal.push(user)
        }
      });
    },
    setSelectedTeacher(){
      this.ecPersonal.forEach( user => {
       if(user.name == this.classroom.teacherID){
        this.classroom.teacherID = user.userID
      }
     })
    },
    setEducation(){
      this.getAllEducation.forEach(education => {
        this.allEducation.push(education)
      })
    },
    setSelectedEducation(){
      this.allEducation.forEach(education => {
       if(education.name == this.classroom.edID){
        this.classroom.edID = education.edID
      }
     })
    },
    cons(){
      console.log(this.classroom)
    },
 async addClass(){
      this.setSelectedTeacher()
      this.setSelectedEducation()
      let response = await fetch("http://localhost:8080/classroom", {
        method: "post",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(this.classroom)
      });
      let result = await response.json();
      console.log(result)
    }
  },
  async created(){
    this.setEducation()
    this.getPersonal()
    
  }
};
</script>