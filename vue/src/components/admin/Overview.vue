<template>
  <div class="root d-flex justify-content-center">
    <div class="main d-flex flex-column width-84">
      <div class="d-flex flex-column">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable">Utbildningar</p>
          </div>
          <div class="d-flex justify-content-end align-items-center">
            <input class="form-control" type="text" placeholder="Sök" />
            <font-awesome-icon
              :icon="['fas','plus-circle']"
              class="align-self-center mx-3 text-cream"
            />
          </div>
        </div>
        <div class="d-flex justify-content-center bg-white">Empty</div>
      </div>

      <div class="d-flex flex-column">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable">Klasser</p>
          </div>
          <div class="d-flex justify-content-end align-items-center">
            <input class="form-control" type="text" placeholder="Sök" />
            <font-awesome-icon
              :icon="['fas','plus-circle']"
              class="align-self-center mx-3 text-cream"
            />
          </div>
        </div>
        <div class="d-flex justify-content-center bg-white">Empty</div>
      </div>

      <div class="d-flex flex-column">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable">Kurser</p>
          </div>
          <div class="d-flex justify-content-end align-items-center">
            <input class="form-control" type="text" placeholder="Sök" />
            <font-awesome-icon
              :icon="['fas','plus-circle']"
              class="align-self-center mx-3 text-cream"
            />
          </div>
        </div>
        <div class="d-flex justify-content-center bg-white">Empty</div>
      </div>
    </div>
  </div>
</template>