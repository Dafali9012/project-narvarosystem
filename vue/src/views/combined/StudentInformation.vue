<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-sm-9 d-flex">
        <div class="root d-flex justify-content-center">
          <div class="main d-flex flex-column">
            <h2 class="align-self-start">Användarinformation</h2>
            <div class="content-line rounded" />


             <div class="container mt-5">
            <div class="jumbotron">
                <div class="row">
                    <div class="col-6">
                        <p>Förnamn:</p>
                        <p>Efternamn:</p>
                        <p>E-post:</p>
                        <p>Telefonnummer</p>
                        <p>Personnummer</p>
                    </div>
                    <div class="col-6">
                        <p>{{user.first_name}}</p>
                        <p>{{user.last_name}}</p>
                        <p>{{user.email}}</p>
                        <p>{{user.phone_number}}</p>
                        <p>{{user.ssn}}</p>
                    </div>                    
                </div>
                <hr>
                <div class="row">
                    <div class="col-6">
                        <p>Min Klass:</p>
                        <p>Klassansvarig:</p>
                        <p>Utbildning:</p>
                        <p>Utbildningsansvarig</p>                        
                    </div>
                    <div class="col-6">
                        <p>{{student[0].fuck.name}}</p>
                        <p>{{student[0].fuck.classManager.userec.first_name}} {{student[0].fuck.classManager.userec.last_name}}</p>
                        <p>{{student[0].fuck.educationOfClass.name}}</p>
                        <p>{{student[0].fuck.educationOfClass.educationManager.userec.first_name}} {{student[0].fuck.educationOfClass.educationManager.userec.last_name}}</p>                        
                    </div>                    
                </div>

            </div>

           </div>
             </div>
             </div>
      </div>
    </div>
  </div>
</template>

<script>
import CombinedSidebar from "@/components/CombinedSidebar.vue";

export default {
  components: {
    CombinedSidebar
  },  
  mounted() {        
    this.$store.dispatch("getMyStudentID", this.$store.state.loggedInUser.id);   
  },
  data() {
    return {
      user:  this.$store.state.loggedInUser,
      student: this.$store.state.MyStudentID
    };
  },  
};
</script>