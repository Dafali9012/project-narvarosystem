<template>
  <div class="root d-flex justify-content-center">
    <div class="main d-flex flex-column">
      <div>
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex d-row align-items-center">
            <p class="no-margin ml-3 text-cream unselectable">Utbildningar</p>
          </div>
          <div class="d-flex d-row justify-content-end align-items-center">
            <input type="text" class="form-control mr-3 width-100" placeholder="Sök" />
            <font-awesome-icon
              :icon="['fas','plus-circle']"
              class="align-self-center mr-3 text-cream"
            />
          </div>
        </div>
        <div class="d-flex justify-content-center bg-white">Empty</div>
      </div>

      <div>
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex d-row align-items-center">
            <p class="no-margin ml-3 text-cream unselectable">Klasser</p>
          </div>
          <div class="d-flex d-row justify-content-end align-items-center">
            <input type="text" class="form-control mr-3 width-100" placeholder="Sök" />
            <font-awesome-icon
              :icon="['fas','plus-circle']"
              class="align-self-center mr-3 text-cream"
            />
          </div>
        </div>
        <div class="d-flex justify-content-center bg-white">Empty</div>
      </div>

      <div>
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex d-row align-items-center">
            <p class="no-margin ml-3 text-cream unselectable">Kurser</p>
          </div>
          <div class="d-flex d-row justify-content-end align-items-center">
            <input type="text" class="form-control mr-3 width-100" placeholder="Sök" />
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