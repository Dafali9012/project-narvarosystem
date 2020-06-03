import Vue from 'vue'
import VueRouter from 'vue-router'
import VueMoment from 'vue-moment'
import store from '@/store'

import 'vue-cal/dist/i18n/sv.js'
import 'vue-cal/dist/vuecal.css'

import Login from '@/views/Login.vue'
import Overview from '@/views/combined/Overview.vue'
import CreateAccount from '@/views/combined/CreateAccount.vue'
import CreateEducation from '@/views/combined/CreateEducation.vue'
import CreateClass from '@/views/combined/CreateClass.vue'
import CreateCourse from '@/views/combined/CreateCourse.vue'
import CreateRole from '@/views/combined/CreateRole.vue'
import CreateLecture from '@/views/combined/CreateLecture.vue'
import PimMessage from '@/components/PimMessage.vue'
import Report from '@/views/combined/Report.vue'
import ClassRoom from '@/views/combined/ClassRoom.vue'

import CalendarStudent from '@/views/combined/CalendarStudent.vue'
import CalendarTeacher from '@/views/combined/CalendarTeacher.vue'

import StudentInformation from '@/views/combined/StudentInformation.vue'
import TeacherInformation from '@/views/combined/TeacherInformation.vue'

import Welcome from '@/views/combined/Welcome.vue'
import notfound from '@/views/combined/404.vue'


//import receivedmessage from '@/components/receivedmessage.vue'

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
      beforeEnter:(to, from, next) => {         
        if (store.state.loggedInUser.role.access_report == true) {   
          next();
        } else {                
          next('/');
        }
      }
    },
    {
      path: '/overview',
      name: 'Overview',
      component: Overview,
      beforeEnter:(to, from, next) => {         
        if (store.state.loggedInUser.role.access_overview == true) {   
          next();
        } else {                
          next('/');
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
          next('/');
        }
      }
    },
    {
      path: '/classroom',
      name: 'ClassRoom',
      component: ClassRoom,
      beforeEnter:(to, from, next) => {         
        if (store.state.loggedInUser.role.access_classroom == true) {   
          next();
        } else {                
          next('/');
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
          next('/');
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
          next('/');
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
          next('/');
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
          next('/');
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
          next('/');
        }
      }
    },
    {
      path: '/create-lecture',
      name: 'CreateLecture',
      component: CreateLecture,
      beforeEnter:(to, from, next) => {         
        if (store.state.loggedInUser.role.create_lecture == true) {   
          next();
        } else {                
          next('/');
        }
      }
    },
    {
      path: '/student-information',
      name: 'StudentInformation',
      component: StudentInformation,
      beforeEnter:(to, from, next) => {         
        if (store.state.loggedInUser.role.access_student_info == true) {   
          next();
        } else {                
          next('/');
        }
      }
    },
    {
      path: '/teacher-information',
      name: 'TeacherInformation',
      component: TeacherInformation,
      beforeEnter:(to, from, next) => {         
        if (store.state.loggedInUser.role.access_teacher_info == true) {   
          next();
        } else {                
          next('/');
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
          next('/');
        }
      }
    },
    {
      path: '/calendar-teacher',
      name: 'CalendarTeacher',
      component: CalendarTeacher,
      beforeEnter: (to, from, next) => {   
        if (store.state.loggedInUser.role.access_calendar_teacher == true) {
          next();
        } else {                
          next('/');
        }
      }
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router