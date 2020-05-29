<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex justify-content-center">
          <div class="main d-flex flex-column width-84">
            <h2 class="align-self-start">Överblick</h2>
            <div class="content-line rounded mb-5" />
            <div class="d-flex flex-column">
              <div class="d-flex justify-content-between background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Utbildningar</p>
                </div>
              </div>
              <AllEducation></AllEducation>
            </div> 
            <br />

            <div class="d-flex flex-column">
              <div class="d-flex justify-content-between  background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Klasser</p>
                </div>
              </div>
              <AllClass></AllClass>
            </div>

            <br />
            <div class="d-flex flex-column">
              <div class="d-flex justify-content-between  background-primary">
                <div class="d-flex align-items-center">
                  <p class="no-margin ml-3 text-cream unselectable my-2">Kurser</p>
                </div>
              </div>
              <AllCourse></AllCourse>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CombinedSidebar from "@/components/CombinedSidebar.vue";
import AllClass from "@/components/admin/AllClass.vue";
import AllEducation from "@/components/admin/AllEducation.vue";
import AllCourse from "@/components/admin/AllCourse.vue";

export default {
  components: {
    CombinedSidebar,
    AllClass,
    AllEducation,
    AllCourse
  },
  methods: {
    helloWorld() {
      console.log("hello world!");
    }
  },
  created() {
    this.$store.dispatch("getAllusers");
    this.$store.dispatch("getAllEducations");
  }

};
</script>