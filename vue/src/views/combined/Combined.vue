<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <NewAccount v-if="this.$store.state.contentIndex==0" />
        <NewEducation v-if="this.$store.state.contentIndex==1" />
        <NewCourse v-if="this.$store.state.contentIndex==2" />
        <NewClass v-if="this.$store.state.contentIndex==3" />
        <Overview v-if="this.$store.state.contentIndex==4" />
        <ListUsers v-if="this.$store.state.contentIndex==5" />
        <Report v-if="this.$store.state.contentIndex==6" />
      </div>
    </div>
  </div>
</template>

<script>
import CombinedSidebar from "@/components/CombinedSidebar.vue";
import NewAccount from "@/components/admin/NewAccount.vue";
import NewEducation from "@/components/admin/NewEducation.vue";
import NewCourse from "@/components/admin/NewCourse.vue";
import NewClass from "@/components/admin/NewClass.vue";
import Overview from "@/components/admin/Overview.vue";
import ListUsers from "@/components/admin/ListUsers.vue";
import Report from "@/components/admin/Report.vue";

export default {
  components: {
    CombinedSidebar,
    NewAccount,
    NewEducation,
    NewCourse,
    NewClass,
    Overview,
    ListUsers,
    Report
  },
  computed: {},
  methods: {
    helloWorld() {
      console.log("hello world!");
    }
  },
  async created() {
    await this.$store.dispatch("getAllusers");
    await this.$store.dispatch("getAllEducations");
  }
};
</script>