<template>
  <div class="root d-flex justify-content-center">
    <div class="main d-flex justify-content-center width-84">
      <div class="flex-grow-1">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable">Filtrering</p>
          </div>
        </div>
        <div class="d-flex justify-content-center bg-lightblue">
          <p class="text-cream">Empty</p>
        </div>
      </div>

      <div class="flex-grow-1 ml-3">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable">Användare</p>
          </div>
          <div class="d-flex justify-content-end align-items-center">
            <font-awesome-icon
              :icon="['fas','plus-circle']"
              class="align-self-center mr-3 text-cream"
            />
          </div>
        </div>
        <div class="d-flex justify-content-center bg-white">Empty</div>
      </div>
    </div>
  </div>
</template>