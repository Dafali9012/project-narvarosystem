<template>
    <div class="user-sidebar col-3">
        <div class="d-flex flex-column align-items-center text-white">
          <img
            src="https://www.fivestardestination.com/wp-content/uploads/2019/03/Just-white-square-300x300.png"
            class="avatar rounded-circle"
          />
          <h5 class="unselectable">Du är inloggad som Admin</h5>
          <div class="line rounded" />
          <div class="mt-5">
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['far','id-badge']" class="align-self-center ml-1" />
              <router-link class="ml-3 unselectable menu-link" to="/user/edit">Redigera information</router-link>
            </div>
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','book-open']" class="align-self-center" />
              <router-link class="ml-3 unselectable menu-link" to="/user/classes">Mina kurser</router-link>
            </div>
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','book-open']" class="align-self-center" />
              <router-link class="ml-3 unselectable menu-link" to="/user/scheme">Schema</router-link>
            </div>            
            <div class="option d-flex align-self-center">
              <font-awesome-icon :icon="['fas','comments']" class="align-self-center" />
              <p class="ml-3 unselectable menu-link">PIM</p>
            </div>
          </div>
        </div>
      </div>
</template>