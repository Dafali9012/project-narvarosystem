<template>
  <div class="root d-flex justify-content-center">
    <div class="main d-flex justify-content-center width-84">
      <div class="filter-window">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable my-2">Filtrering</p>
          </div>
        </div>
        <div class="d-flex flex-column align-items-center bg-lightblue text-cream">
          <input class="form-control my-3 width-84" type="text" placeholder="Sök" />
          <div class="d-flex mb-2 width-84">
            <input id="ec" type="checkbox" style="width:auto !important;" />
            <label class="no-margin" for="ec">EC Personal</label>
          </div>
          <div class="d-flex mb-2 width-84">
            <input id="teacher" type="checkbox" style="width:auto !important;" />
            <label class="no-margin" for="teacher">Lärare</label>
          </div>
          <div class="d-flex mb-2 width-84">
            <input id="consult" type="checkbox" style="width:auto !important;" />
            <label class="no-margin" for="consult">Konsult</label>
          </div>
          <div class="d-flex mb-2 width-84">
            <input id="student" type="checkbox" style="width:auto !important;" />
            <label class="no-margin" for="student">Student</label>
          </div>
        </div>
      </div>

      <div class="results-window ml-3">
        <div class="d-flex justify-content-between bg-primary">
          <div class="d-flex align-items-center">
            <p class="no-margin ml-3 text-cream unselectable my-2">Rapport</p>
          </div>
          <div class="d-flex justify-content-end align-items-center">
            <font-awesome-icon
              :icon="['fas','plus-circle']"
              class="align-self-center mr-3 text-cream"
            />
          </div>
        </div>
        <div class="bg-white container-fluid">
          <div class="row">
            <div class="col-2 d-flex">
              <p>Förnamn</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-2 d-flex">
              <p>Efternamn</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-2 d-flex">
              <p>E-post</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-2 d-flex">
              <p>Telefon</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-2 d-flex">
              <p>Roll</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>