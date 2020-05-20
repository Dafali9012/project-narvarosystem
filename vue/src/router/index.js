import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home.vue'
//import store from '@/store'


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
import TRapport from "../components/teacher/TeacherReport.vue"


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
        component: Admin,
       
    },
    {
      path: '/user/:id',
      name: 'User',
      component: User,
      meta:{ authUser: true }
    },  
    {
      path: '/user/:id/edit',
      name: 'UEdit',
      component: UEdit,
    },
    {
      path: '/user/:id/classes',
      name: 'UClasses',
      component: UClasses

    },
    {
      path: '/user/:id/scheme',
      name: 'UScheme',
      component: UScheme
    }, 
    {
      path: '/teacher/:id',
      name: 'Teacher',
      component: Teacher,
    },
    {
      path: '/teacher/:id/edit',
      name: 'TEdit',
      component: TEdit
    },
    {
      path: '/teacher/:id/classes',
      name: 'TClasses',
      component: TClasses
    },
    {
      path: '/teacher/:id/course',
      name: 'TCourse',
      component: TCourse
    }, 
    {
      path: '/teacher/:id/presence',
      name: 'TPresence',
      component: TPresence
    }, 
    {
      path: '/teacher/:id/report',
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

/*router.beforeEach((to, from, next) => {
  if(to.matched.some(record => record.meta.authUser)){

    if(store.state.logged){
      
      if(store.state.loggedInUser.roles[0].role == "ADMIN"){
        router.push('/admin')
      } else {
        next();
      }
     
      if(store.state.loggedInUser.roles[0].role == "TEACHER"){
        router.push('/teacher/')
      } else {
        next();
      }

      if(store.state.loggedInUser.roles[0].role == "STUDENT"){
        router.push('/user/')
      } else {
        next();
      }
    }
    
    else{
      router.push('/login')
    }

  } else {
    next();
  }
});*/
export default router
