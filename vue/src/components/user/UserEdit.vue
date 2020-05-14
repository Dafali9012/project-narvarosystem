<template>
  <div class="user d-flex flex-column container-fluid">  
    <div class="content row mt-3">
      <UserSideBar/>
      
      <div class="main col-9 mt-5">
        <div class="con-header mt-5">
          <h1>Redigera information</h1>
         </div> 

         <div class="editform mt-5">
           <form>

            <div class="form-row">
              <div class="form-group col-md-6">      
                <input type="text" class="form-control" placeholder="Förnamn">
              </div>
              <div class="form-group col-md-6">              
                <input type="text" class="form-control"  placeholder="Efternamn">
              </div>
            </div>

            <div class="form-row">
              <div class="form-group col-md-6">      
                <input type="email" class="form-control" placeholder="E-post">
              </div>
              <div class="form-group col-md-6">              
                <input type="text" class="form-control"  placeholder="Telefonnummer">
              </div>
            </div>


            <div class="form-row">
              <div class="form-group col-md-6">      
                <input type="text" class="form-control" placeholder="Personnummer" disabled>
              </div>
              <div class="form-group col-md-6">              
                <input type="text" class="form-control"  placeholder="Adress">
              </div>
            </div>
            
              <div class="float-right">
                <button class="btn btn-primary">Redigera</button>
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
};
</script>