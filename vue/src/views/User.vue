<template>
  <div class="user container-fluid">
    <div class="row">
        <div class="navbar d-flex justify-content-center col bg-primary text-white">
            <p>Temp Navbar</p>
        </div>
    </div>
    <div class="content d-flex row">
        <div class="sidebar col-3 flex-grow-1 bg-success">1</div>
        <div class="main col-9 bg-danger">2</div>
    </div>
  </div>
</template>

<style scoped>
    .sidebar, .main, .content {
        height: 96vh;
    }
    .navbar {
        height: 4vh;
    }
    p {
        margin:0;
    }
</style>