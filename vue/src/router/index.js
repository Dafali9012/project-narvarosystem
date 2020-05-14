import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home.vue'


import Admin from '@/views/Admin.vue'


//import About from '@/views/About.vue'
import User from '@/views/User.vue'
import Teacher from '@/views/Teacher.vue'
import Login from '@/views/Login.vue'

import Navbar from "../components/Navbar.vue";

import UClasses from "../components/user/UserClasses.vue"
import UEdit from "../components/user/UserEdit.vue"
import UScheme from "../components/user/UserScheme.vue"

import TClasses from "../components/teacher/TeacherClasses.vue"
import TCourse from "../components/teacher/TeacherCourses.vue"
import TEdit from "../components/teacher/TeacherEdit.vue"
import TPresence from "../components/teacher/TeacherPresence.vue"
import TRapport from "../components/teacher/TeacherRapport.vue"


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
    path: '/admin',
    name: 'Admin',
    component: Admin
},
{
    path: '/user',
    name: 'User',
    component: User
  },  
  {
    path: '/user/edit',
    name: 'UEdit',
    component: UEdit
  },
  {
    path: '/user/classes',
    name: 'UClasses',
    component: UClasses

  },
  {
    path: '/user/scheme',
    name: 'UScheme',
    component: UScheme
  }, 
  {
    path: '/teacher',
    name: 'Teacher',
    component: Teacher
  },
  {
    path: '/teacher/edit',
    name: 'TEdit',
    component: TEdit
  },
  {
    path: '/teacher/classes',
    name: 'TClasses',
    component: TClasses
  },
  {
    path: '/teacher/course',
    name: 'TCourse',
    component: TCourse
  }, 
  {
    path: '/teacher/presence',
    name: 'TPresence',
    component: TPresence
  }, 
  {
    path: '/teacher/rapport',
    name: 'TRapport',
    component: TRapport
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
