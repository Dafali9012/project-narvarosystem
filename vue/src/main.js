import 'bootstrap/dist/css/bootstrap.min.css'
import 'jquery/src/jquery.js'
import 'popper.js/dist/popper.min.js'
import 'bootstrap/dist/js/bootstrap.min.js'
import '@/style/style.css'

import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

/*import VueBootstrap4Table from 'vue-bootstrap4-table'
import {Calendar} from 'vue-bootstrap-calendar' 
import {messages} from 'vue-bootstrap-calendar'*/

import {
  library
} from '@fortawesome/fontawesome-svg-core'
import {
  faIdBadge
} from '@fortawesome/free-regular-svg-icons'
import {
  faBookOpen,
  faList,
  faGraduationCap,
  faChartBar,
  faComments,
  faChalkboard,
  faUserGraduate,
  faChalkboardTeacher,
  faCalendarAlt,
  faCog
} from '@fortawesome/free-solid-svg-icons'
import {
  FontAwesomeIcon
} from '@fortawesome/vue-fontawesome'

library.add(faIdBadge, faList, faGraduationCap, faBookOpen, faChartBar, faComments, faChalkboard, faUserGraduate, faChalkboardTeacher, faCog, faCalendarAlt)

Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')