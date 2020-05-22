<template>
  <div class="container">
    <h1 class="text-center pt-4">Welcome To Massage</h1>
    <h3 class="text-center">Do you like the Massage?</h3>
      <div  class="unselectable mt-5 d-flex justify-content-center">
        <div class="button-account border border-bottom-0 border-dark d-flex align-items-center justify-content-center">
          <font-awesome-icon :icon="['fas','user-graduate']" class="align-self-center mr-3" />
          <p class="no-margin">Skapa nytt studentkonto</p>
        </div>
        <div class="button-account border border-gray d-flex align-items-center justify-content-center menu-link">
          <font-awesome-icon
            :icon="['fas','chalkboard-teacher']"
            class="align-self-center text-muted mr-3"
          />
          <p class="no-margin text-muted">Skapa nytt EC konto</p>
        </div>
      </div>
      <div>
    <b-tabs content-class="mt-3" justified>
        <b-tab title="First" active><p>I'm the first tab</p></b-tab>
        <b-tab title="Second"><p>I'm the second tab</p></b-tab>
        <b-tab title="Very, very long title"><p>I'm the tab with the very, very long title</p></b-tab>
        <b-tab title="Disabled" disabled><p>I'm a disabled tab!</p></b-tab>
    </b-tabs>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>


</style>