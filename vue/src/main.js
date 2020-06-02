import 'bootstrap/dist/css/bootstrap.min.css'
import 'jquery/src/jquery.js'
import 'popper.js/dist/popper.min.js'
import 'bootstrap/dist/js/bootstrap.min.js'
import '@/style/style.css'
import 'vue-cal/dist/vuecal.css'

import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'




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
  faPlusCircle,
  faCalendarAlt,
  faCog,
  faSort,
  faKey,
  faUser,
  faInbox,
  faShareSquare,
  faPaperPlane
} from '@fortawesome/free-solid-svg-icons'
import {
  FontAwesomeIcon
} from '@fortawesome/vue-fontawesome'

  faShareSquare
library.add(faIdBadge, faList, faGraduationCap, faBookOpen, faChartBar, faComments, faChalkboard, faUserGraduate, faChalkboardTeacher, faPlusCircle, faCog, faCalendarAlt, faKey, faUser, faSort, faInbox, faShareSquare, faPaperPlane)

Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false


new Vue({ 
  router,
  store,
  render: h => h(App)
}).$mount('#app')