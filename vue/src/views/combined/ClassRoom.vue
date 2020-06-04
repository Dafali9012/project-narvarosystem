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
              <div class="row" style="margin-top:10%;">
                <h3 class="col-12 text-left">Klassrum</h3>
                <div
                  class="content-line rounded background-primary"                  
                />
              </div>

              <draggable>
    
              </draggable>

              
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import CombinedSidebar from "@/components/CombinedSidebar.vue"
  import draggable from 'vuedraggable'

export default {
  components: {
    CombinedSidebar,
    draggable
  }
};
</script>

