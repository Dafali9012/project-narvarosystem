import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    contentIndex: 0
  },
  mutations: {
    changeContentIndex(state, value) {
      state.contentIndex = value
    }
  },
  actions: {},
  modules: {}
})