<template>
  <div class="root d-flex flex-column container-fluid">    
    <div class="content row mt-3">
      <TeacherSideBar/>
      
      <div class="main col-9 mt-5">
        <div class="con-header mt-5">
          <h1>Redigera information</h1>
         </div> 

         <div class="editform mt-5 col-12">
         
          
           <form>
            <div class="form-row">
              <div class="form-group col-6">      
                <input type="text" class="form-control w-100" placeholder="Förnamn">
              </div>
              <div class="form-group col-6">              
                <input type="text" class="form-control w-100"  placeholder="Efternamn">
              </div>
            </div>

            <div class="form-row">
              <div class="form-group col-6">      
                <input type="email" class="form-control w-100" placeholder="E-post">
              </div>
              <div class="form-group col-6">              
                <input type="text" class="form-control w-100"  placeholder="Telefonnummer">
              </div>
            </div>


            <div class="form-row">
              <div class="form-group col-6">      
                <input type="text" class="form-control w-100" placeholder="Personnummer" disabled>
              </div>
              <div class="form-group col-6">              
                <input type="text" class="form-control w-100"  placeholder="Adress">
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

import TeacherSideBar from "@/components/teacher/TeacherSideBar.vue";


export default {
  components: {     
    TeacherSideBar    
  }
};
</script>