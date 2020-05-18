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
          <input class="form-control my-4 width-84" type="text" placeholder="Sök" />

          <select class="form-control mb-2 width-84" id="education">
            <option value="education">Utbildning</option>
          </select>
          <select class="form-control mb-2 width-84" id="course">
            <option value="course">Kurs</option>
          </select>
          <select class="form-control mb-4 width-84" id="class">
            <option value="class">Klass</option>
          </select>
          <label class="align-self-start ml-4" for="from">Från:</label>
          <input class="form-control mb-2 width-84" type="date" id="from" />
          <label class="align-self-start ml-4" for="to">Till:</label>
          <input class="form-control mb-4 width-84" type="date" id="to" />
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
            <div class="col-3 d-flex">
              <p>Lektion</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-2 d-flex">
              <p>Datum</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-2 d-flex">
              <p>Status</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
            <div class="col-3 d-flex">
              <p>Kurs</p>
              <font-awesome-icon :icon="['fas','sort']" class="align-self-center ml-3" />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>