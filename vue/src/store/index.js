import Vue from 'vue'
import Vuex from 'vuex'
import router from '@/router'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    contentIndex: 0,
    loggedInUser: {},
    AllClass:[],
    AllEducation:[],
    AllCourse:[],
    AllUser:[],
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
    },
    setAllClasses(state, value) {
      state.AllClass = value;
    },
    setAllEducations(state, value) {
      state.AllEducation = value;
    },
    setAllCourses(state, value) {
      state.AllCourse= value;
    },
    setAllUsers(state, value) {
      state.AllUser = value;
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
    getAllClasses: async function({ commit }) {
      let url = "http://localhost:8080/classroom";
      const result = await fetch(url);
      const json = await result.json();
      commit("setAllClasses", json);
    },
    getAllEducations: async function({ commit }) {
      let url = "http://localhost:8080/education";
      const result = await fetch(url);
      const json = await result.json();
      commit("setAllEducations", json);
    },
    getAllCourses: async function({ commit }) {
      let url = "http://localhost:8080/course";
      const result = await fetch(url);
      const json = await result.json();
      commit("setAllCourses", json);
    },
    getAllusers: async function({ commit }) {
      let url = "http://localhost:8080/user";
      const result = await fetch(url);
      const json = await result.json();
      commit("setAllUsers", json);
    }
  },
  modules: {
  }
})
    
