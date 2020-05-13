import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home.vue'

//import About from '@/views/About.vue'
import User from '@/views/User.vue'
import Login from '@/views/Login.vue'

import Navbar from "../components/Navbar.vue";

import Classes from "../components/user/UserClasses.vue"
import Edit from "../components/user/UserEdit.vue"
import Scheme from "../components/user/UserScheme.vue"


Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/',
    name: 'Navbar',
    component: Navbar
  },  
  {
    path: '/user',
    name: 'User',
    component: User
  },
  {
    path: '/user/edit',
    name: 'Edit',
    component: Edit
  },
  {
    path: '/user/classes',
    name: 'Classes',
    component: Classes
  },
  {
    path: '/user/scheme',
    name: 'Scheme',
    component: Scheme
  }, 
  {
    path: '/login',
    name: 'Login',
    component: Login
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
