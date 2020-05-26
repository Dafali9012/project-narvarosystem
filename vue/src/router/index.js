import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '@/store'

import Combined from '@/views/combined/Combined.vue'

import Login from '@/views/Login.vue'
import Overview from '@/views/combined/Overview.vue'
import Classes from '@/views/combined/Classes.vue'




Vue.use(VueRouter)

const routes = [{
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/overview',
    name: 'Overview',
    component: Overview
  },
  {
    path: '/classes',
    name: 'Classes',
    component: Classes
  },
  {
    path: '/combined',
    name: 'Combined',
    component: Combined
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.authUser)) {

    if (store.state.logged) {

      if (store.state.loggedInUser.roles[0].role == "ADMIN") {
        router.push('/admin')
      } else {
        next();
      }

      if (store.state.loggedInUser.roles[0].role == "TEACHER") {
        router.push('/teacher')
      } else {
        next();
      }

      if (store.state.loggedInUser.roles[0].role == "STUDENT") {
        router.push('/user')
      } else {
        next();
      }
    } else {
      router.push('/')
    }

  } else {
    next();
  }
});

export default router