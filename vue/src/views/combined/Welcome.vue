<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex flex-column container-fluid">
          <div class="content row mt-3 justify-content-center" style="user-select: none;">
            <div class="main col-9 mt-5">
              <div class="row" style="margin-top:10%; justify-content: center;">
                <h1 class="effect col-12 display-2">Välkommen</h1>
                <div
                  class="content-line rounded mt-5 background-primary"
                  style="width:20%; height: 5px;"
                />
              </div>
              <h1 class="effect mt-5 mb-5 display-3">{{this.$store.state.loggedInUser.first_name}}</h1>
              <img
                class="effect"
                draggable="false"
                src="https://www.logolynx.com/images/logolynx/32/3256e8dfb19563bf290338cab4daa0a5.png"
                style="user-select: none; width: 155px; height: 150px; border-radius: 180px;"
              />
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
  }
};
</script>

<style scoped>
.effect:hover {
  -webkit-transform: scale(1.1);
  transform: scale(1.05);
  transition: all 1s;
  -webkit-touch-callout: none;
  -webkit-user-select: none;
  -khtml-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}
.effect {
  transition: all 1s;
}
</style>