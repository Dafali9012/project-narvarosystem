import Vue from 'vue'
import VueRouter from 'vue-router'
import store from "../store/index.js"
import VueMoment from 'vue-moment'


import 'vue-cal/dist/i18n/sv.js'
import 'vue-cal/dist/vuecal.css'

import Login from '@/views/Login.vue'
import Overview from '@/views/combined/Overview.vue'
import Classes from '@/views/combined/Classes.vue'
import Users from '@/views/combined/Users.vue'
import Courses from '@/views/combined/Courses.vue'
import CreateAccount from '@/views/combined/CreateAccount.vue'
import CreateEducation from '@/views/combined/CreateEducation.vue'
import CreateClass from '@/views/combined/CreateClass.vue'
import CreateCourse from '@/views/combined/CreateCourse.vue'
import PimMessage from '@/components/PimMessage.vue'
import EditInformation from '@/views/combined/EditInformation.vue'
import Report from '@/views/combined/Report.vue'

import CalendarStudent from '@/views/combined/CalendarStudent.vue'
import CalendarTeacher from '@/views/combined/CalendarTeacher.vue'
import CreateRole from '@/views/combined/CreateRole.vue'
import Welcome from '@/views/combined/Welcome.vue'
import notfound from '@/views/combined/404.vue'

// import TClasses from "../components/teacher/TeacherClasses.vue"
// import TCourse from "../components/teacher/TeacherCourses.vue"
// import TEdit from "../components/teacher/TeacherEdit.vue"
// import TPresence from "../components/teacher/TeacherPresence.vue"
// import TRapport from "../components/teacher/TeacherReport.vue"
// import Pim from '../views/Pim.vue'
import receivedmessage from '@/components/receivedmessage.vue'





Vue.use(VueRouter)
Vue.use(VueMoment)


const routes = [
  { path: '*', name: "404", component: notfound},
  
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/welcome',
      name: 'Welcome',
      component: Welcome,
    },

  {
    path: '/report',
    name: 'Report',
    component: Report,
  },
  {
    path: '/overview',
    name: 'Overview',
    component: Overview,
    beforeEnter:(to, from, next) => {         
      if (store.state.loggedInUser.role.access_overview == true) {   
        next();
      } else {                
        next('/login');
      }
    }
  },
  {
    path: '/pimmessage',
    name: 'PimMessage',
    component: PimMessage,
    beforeEnter:(to, from, next) => {         
      if (store.state.loggedInUser.role.access_messages == true) {   
        next();
      } else {                
        next('/login');
      }
    }
  },
  {
    path: '/message',
    name: 'Message',
    component: receivedmessage
  },
  {
    path: '/classes',
    name: 'Classes',
    component: Classes,
    beforeEnter:(to, from, next) => {         
      if (store.state.loggedInUser.role.access_classes_courses == true) {   
        next();
      } else {                
        next('/login');
      }
    }
  },
  {
    path: '/users',
    name: 'Users',
    component: Users
  },
  {
    path: '/courses',
    name: 'Courses',
    component: Courses,
    beforeEnter:(to, from, next) => {         
      if (store.state.loggedInUser.role.access_courses == true) {   
        next();
      } else {                
        next('/login');
      }
    }
  },
  {
    path: '/create-account',
    name: 'CreateAccount',
    component: CreateAccount,
    beforeEnter:(to, from, next) => {         
      if (store.state.loggedInUser.role.create_account == true) {   
        next();
      } else {                
        next('/login');
      }
    }
  },
  {
    path: '/create-class',
    name: 'CreateClass',
    component: CreateClass,
    beforeEnter:(to, from, next) => {         
      if (store.state.loggedInUser.role.create_class == true) {   
        next();
      } else {                
        next('/login');
      }
    }
  },

  {
    path: '/create-education',
    name: 'CreateEducation',
    component: CreateEducation,
    beforeEnter:(to, from, next) => {         
      if (store.state.loggedInUser.role.create_education == true) {   
        next();
      } else {                
        next('/login');
      }
    }
  },
  {
    path: '/create-course',
    name: 'CreateCourse',
    component: CreateCourse,
    beforeEnter:(to, from, next) => {         
      if (store.state.loggedInUser.role.create_course == true) {   
        next();
      } else {                
        next('/login');
      }
    }
  },
  {
    path: '/create-role',
    name: 'CreateRole',
    component: CreateRole,
    beforeEnter:(to, from, next) => {         
      if (store.state.loggedInUser.role.create_role == true) {   
        next();
      } else {                
        next('/login');
      }
    }
  },
  {
    path: '/calendar-student',
    name: 'CalendarStudent',
    component: CalendarStudent,
    beforeEnter:(to, from, next) => {         
      if (store.state.loggedInUser.role.access_calendar_student == true) {   
        next();
      } else {                
        next('/login');
      }
    }
  },
  {
    path: '/calendar-teacher',
    name: 'CalendarTeacher',
    component: CalendarTeacher,
    beforeEnter:(to, from, next) => {         
      if (store.state.loggedInUser.role.access_calendar_teacher == true) {   
        next();
      } else {                
        next('/login');
      }
    }
  },
  {
    path: '/edit-information',
    name: 'EditInformation',
    component: EditInformation,
    beforeEnter:(to, from, next) => {         
      if (store.state.loggedInUser.role.access_user_edit == true) {   
        next();
      } else {                
        next('/login');
      }
    }
  }

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