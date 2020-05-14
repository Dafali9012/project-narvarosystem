<template>
  <div class="user d-flex flex-column container-fluid">  
    <div class="content row mt-3">
      <UserSideBar/>    
      <div class="main col-9 mt-5">
        <div class="con-header mt-5">
          <h1>Redigera information</h1>
         </div> 
         <div class="editform mt-5">
           <form v-for="(user, index) in user" :key="user.name">
            <div class="form-row">
              <div class="form-group col-md-6">      
                <input type="text" class="form-control" v-model="user.FirstName" placeholder="Förnamn">
              </div>
              <div class="form-group col-md-6">              
                <input type="text" class="form-control" v-model="user.LastName"  placeholder="Efternamn">
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">      
                <input type="email" class="form-control" v-model="user.Email" placeholder="E-post">
              </div>
              <div class="form-group col-md-6">              
                <input type="text" class="form-control" v-model="user.Phone"  placeholder="Telefonnummer">
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">      
                <input type="text" class="form-control" v-model="user.sin" placeholder="Personnummer" disabled>
              </div>
              <div class="form-group col-md-6">              
                <input type="text" class="form-control" v-model="user.Adress" placeholder="Adress">
              </div>
            </div>
              <div class="float-right">
                <input type='button' value='Redigera' @click='updateRecord(index,user.id);'>&nbsp;
              </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import UserSideBar from "@/components/user/UserSideBar.vue";


export default {
  components: {     
    UserSideBar    
  }
  ,methods: {
    updateRecord: function(index, id){
      var FirstName = this.user[index].FirstName;
      var LastName = this.user[index].LastName;
      var Email = this.user[index].Email;
      var Phone = this.user[index].Phone;
      var Sin = this.user[index].Sin;
      var Adress = this.user[index].Adress;
      var Password = this.user[index].Password;
    }
  }
};
</script>