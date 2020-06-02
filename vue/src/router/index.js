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
    component: Overview
  },
  {
    path: '/pimmessage',
    name: 'PimMessage',
    component: PimMessage
  },
  {
    path: '/message',
    name: 'Message',
    component: receivedmessage
  },
  {
    path: '/classes',
    name: 'Classes',
    component: Classes
  },
  {
    path: '/users',
    name: 'Users',
    component: Users
  },
  {
    path: '/courses',
    name: 'Courses',
    component: Courses
  },
  {
    path: '/create-account',
    name: 'CreateAccount',
    component: CreateAccount
  },
  {
    path: '/create-class',
    name: 'CreateClass',
    component: CreateClass
  },

  {
    path: '/create-education',
    name: 'CreateEducation',
    component: CreateEducation
  },
  {
    path: '/create-course',
    name: 'CreateCourse',
    component: CreateCourse
  },
  {
    path: '/create-role',
    name: 'CreateRole',
    component: CreateRole
  },
  {
    path: '/calendar-student',
    name: 'CalendarStudent',
    component: CalendarStudent
  },
  {
    path: '/calendar-teacher',
    name: 'CalendarTeacher',
    component: CalendarTeacher,
    beforeEnter: (to, from, next) => {         
      if (store.state.loggedInUser.role.access_calendar_teacher == true) {   
        next();
      } else {                
        next(false);
      }
    }
  },
  {
    path: '/edit-information',
    name: 'EditInformation',
    component: EditInformation
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