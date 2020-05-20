<template>
    <div class="user-sidebar col-3">
        <div class="d-flex flex-column align-items-center text-white">
          <img
            src="https://www.fivestardestination.com/wp-content/uploads/2019/03/Just-white-square-300x300.png"
            class="avatar rounded-circle"
          />
          <h5 class="unselectable">Du är inloggad som Lärare</h5>
          <div class="line rounded" />
          
          <div class="row mt-2 mb-2">
            <div class="col-6">
              <p class="text-left"><strong>Förnamn:</strong></p>
              <p class="text-left"><strong>Efternamn:</strong></p>
              <p class="text-left"><strong>E-post:</strong></p>             
            </div>  
            <div class="col-6">
              <p class="text-right">{{user.name}}</p>
              <p class="text-right">{{user.lastName}}</p>
              <p class="text-right">{{user.email}}</p>             
            </div>
          </div> 
          
          <div class="line rounded" />
          <div class="mt-5">
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','cog']" class="align-self-center ml-1" />
              <router-link class="ml-3 unselectable menu-link" to="/teacher/edit">Redigera information</router-link>
            </div>
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','graduation-cap']" class="align-self-center" />
              <router-link class="ml-3 unselectable menu-link" to="/teacher/classes">Mina klasser</router-link>
            </div>
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','book-open']" class="align-self-center" />
              <router-link class="ml-3 unselectable menu-link" to="/teacher/course">Mina kurser</router-link>
            </div>
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','calendar-alt']" class="align-self-center" />
              <router-link class="ml-3 unselectable menu-link" to="/teacher/presence">Närvaro/frånvaro</router-link>
            </div>  
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','list']" class="align-self-center" />
              <router-link class="ml-3 unselectable menu-link" to="/teacher/report">Rapport</router-link>
            </div>           
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','comments']" class="align-self-center" />
              <p class="ml-3 unselectable menu-link">PIM</p>
            </div>
          </div>
        </div>
      </div>
</template>
<script>
export default {
  data() {
    return {
      user: this.$store.state.loggedInUser
    };
  },
  
};
</script>