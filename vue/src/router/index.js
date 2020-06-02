import Vue from 'vue'
import VueRouter from 'vue-router'
import VueMoment from 'vue-moment'
//import store from '@/store'

import 'vue-cal/dist/i18n/sv.js'
import 'vue-cal/dist/vuecal.css'


import Combined from '@/views/combined/Combined.vue'
import Login from '@/views/Login.vue'
import receivedmessage from '@/components/receivedmessage.vue'




Vue.use(VueRouter)
Vue.use(VueMoment)


const routes = [{
    path: '/',
    name: 'Login',
    component: Login

  },
  

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

/*
router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.authUser)) {

    if (store.state.logged) {
      router.push('/overview')

      // if (store.state.loggedInUser.role_id == 1) {

      // } else {
      //   next();
      // }

      // if (store.state.loggedInUser.roles[0].role == 3) {
      //   router.push('/teacher')
      // } else {
      //   next();
      // }

      // if (store.state.loggedInUser.roles[0].role == 2) {
      //   router.push('/user')
      // } else {
      //   next();
      // }
    } else {
      router.push('/')
    }

  } else {
    next();
  }
});
*/
export default router