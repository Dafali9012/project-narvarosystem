<template>
  <div class="root d-flex flex-column container-fluid">    
    <div class="content row mt-3">
      <TeacherSideBar/>
      
      <div class="main col mt-5">
        <div class="con-header mt-5">
          <h1>Redigera information</h1>
         </div> 

         <div class="editform mt-5 col-12">
          <form>
            <div class="form-row">
              <div class="form-group col-6">
                <input
                  type="text"
                  class="form-control w-100"
                  :placeholder= "user.name"/>
              </div>
              <div class="form-group col-6">
                <input
                  type="text"
                  class="form-control w-100"
                  :placeholder= "user.lastName"
                />
              </div>
            </div>

            <div class="form-row">
              <div class="form-group col-6">
                <input
                  type="email"
                  class="form-control w-100"
                  :placeholder="user.email"
                />
              </div>
              <div class="form-group col-6">
                <input
                  type="text"
                  class="form-control w-100"
                  :placeholder="user.phone"
                />
              </div>
            </div>

            <div class="form-row">
              <div class="form-group col-6">
                <input
                  type="text"
                  class="form-control w-100"
                  :placeholder="user.sin"
                  disabled
                />
              </div>
              <div class="form-group col-6">
                <input
                  type="text"
                  class="form-control w-100"
                  :placeholder="user.address"
                />
              </div>
            </div>

            <div class="float-right">
              <button class="button button-primary">
                <span> Redigera </span>
              </button>
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
  },
  data() {
    return {
      user: this.$store.state.loggedInUser
    };
  },
};
</script>