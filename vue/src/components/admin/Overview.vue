<template>
  <div class="root d-flex justify-content-center">
    <div class="main d-flex flex-column width-84">
      <div class="d-flex flex-column">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable my-2">Utbildningar</p>
          </div>
          <div class="d-flex justify-content-end align-items-center">
            <input class="form-control width-100" type="text" placeholder="Sök" />
            <font-awesome-icon
              :icon="['fas','plus-circle']"
              class="align-self-center mx-3 text-cream"
            />
          </div>
        </div>
        <div class="bg-white container-fluid">
          <div class="row">
            <div class="col-3 d-flex">
              <p>Namn</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-3 d-flex">
              <p>Poäng</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-3 d-flex">
              <p>Ansvarig</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
          </div>
        </div>
      </div>

      <div class="d-flex flex-column">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable my-2">Klasser</p>
          </div>
          <div class="d-flex justify-content-end align-items-center">
            <input class="form-control width-100" type="text" placeholder="Sök" />
            <font-awesome-icon
              :icon="['fas','plus-circle']"
              class="align-self-center mx-3 text-cream"
            />
          </div>
        </div>
        <div class="bg-white container-fluid">
          <div class="row">
            <div class="col-2 d-flex">
              <p>Namn</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-2 d-flex">
              <p>Startdatum</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-2 d-flex">
              <p>Slutdatum</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-3 d-flex">
              <p>Ansvarig</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
          </div>
        </div>
      </div>

      <div class="d-flex flex-column">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable my-2">Kurser</p>
          </div>
          <div class="d-flex justify-content-end align-items-center">
            <input class="form-control width-100" type="text" placeholder="Sök" />
            <font-awesome-icon
              :icon="['fas','plus-circle']"
              class="align-self-center mx-3 text-cream"
            />
          </div>
        </div>
        <div class="bg-white container-fluid">
          <div class="row">
            <div class="col-2 d-flex">
              <p>Namn</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-2 d-flex">
              <p>Poäng</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-2 d-flex">
              <p>Startdatum</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-2 d-flex">
              <p>Slutdatum</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-3 d-flex">
              <p>Lärare</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>