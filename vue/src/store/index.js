import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    loggedInUser: {},
  },
  mutations: {
    changeLoggedUser(state, value) {
      state.loggedInUser = value
    }
  },
  actions: {
    async updateLoggedUser({
      commit
    }) {
      let response = await fetch("/login/name")
      let result = await response.json()
      commit('changeLoggedUser', result)
    },
  },
  modules: {
  }
})
