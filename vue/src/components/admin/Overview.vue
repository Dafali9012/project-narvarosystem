<template>
  <div class="root d-flex justify-content-center">
    <div class="main d-flex flex-column width-84">
      <div class="d-flex flex-column">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable my-2">Utbildningar</p>
          </div>
        </div>
        <AllEducation></AllEducation>
      </div>
      <br />

      <div class="d-flex flex-column">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable my-2">Klasser</p>
          </div>
        </div>
        <AllClass></AllClass>
      </div>

      <br />
      <div class="d-flex flex-column">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable my-2">Kurser</p>
          </div>
        </div>
        <AllCourse></AllCourse>
      </div>
    </div>
  </div>
</template>
<script>
import AllClass from "@/components/admin/AllClass.vue";
import AllEducation from "@/components/admin/AllEducation.vue";
import AllCourse from "@/components/admin/AllCourse.vue";

export default {
  components: {
    AllClass,
    AllEducation,
    AllCourse
  }
};
</script>