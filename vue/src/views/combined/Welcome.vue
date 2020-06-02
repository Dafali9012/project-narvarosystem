<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex flex-column container-fluid">
          <div class="content row mt-3">
              <div class="main col-9 mt-5">
              <div class="row ml-5">
              <h1>Välkommen!!!</h1>
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
  }
}

</script>