import Vue from 'vue'
import Vuex from 'vuex'
import router from '@/router'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    contentIndex: 0,
    loggedInUser: {},
    logged: false
  },
  mutations: {
    isLogged(state , value){
      state.logged = value;
    },

    changeLoggedUser(state, value) {
      state.loggedInUser = value
    },
    changeContentIndex(state, value) {
      state.contentIndex = value
    }
  },
  actions: {
    async updateLoggedUser({ commit }) {
      let response = await fetch("/login/name")
      
      if (response.status == 500) {
        commit('isLogged', false)
      }
      if(response.status == 200) {
        let result = await response.json()
        commit('changeLoggedUser', result)
        commit('isLogged', true)
        router.push("/");
      }
    },
  },
  modules: {
  }
})
    
