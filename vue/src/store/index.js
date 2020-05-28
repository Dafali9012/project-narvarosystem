import Vue from 'vue'
import Vuex from 'vuex'
import router from '@/router'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    contentIndex: 0,
    user: [],
    loggedInUser: {},
    AllClass: [],
    AllEducation: [],
    AllCourse: [],
    AllUser: [],
    MyClassAsTeacher: [],
    MyCourseAsTeacher: [],
    MyCourse: [],
    MyLecture: [],
    ClassByED:[],
    Messages:[],
    messageToDelete:{},
    ClassByED: [],

    logged: false

  },
  mutations: {
    setMessageToDelete(state , value){
      state.messageToDelete = value;
    },
   
    isLogged(state, value) {
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
      console.log(state.AllClass)
    },
    setAllEducations(state, value) {
      state.AllEducation = value;
    },
    setAllCourses(state, value) {
      state.AllCourse = value;
    },
    setAllUsers(state, value) {
      state.AllUser = value;
    },
    setMyClassAsTeacher(state, value) {
      state.MyClassAsTeacher = value;
    },
    setMyCourseAsTeacher(state, value) {
      state.MyCourseAsTeacher = value;
    },
    setMyCourse(state, value) {
      state.MyCourse = value;
    },
    setMyLecture(state, value) {
      state.MyLecture = value;
    },
    setClassByED(state, value) {
      state.ClassByED = value;
    },
    setUser(state, value) {
      state.user = value;
    },
    setMessage(state , value){
      state.Messages = value;
    }
  },
  actions: {
    async updateLoggedUser({
      commit
    }) {
      let response = await fetch("/login/name")

      if (response.status == 500) {
        commit('isLogged', false)
      }
      if (response.status == 200) {
        let result = await response.json()
        commit('changeLoggedUser', result)
        commit('isLogged', true)
        router.push("/admin");
      }
    },
    getAllClasses: async function ({
      commit
    }) {
      let url = 'http://localhost:8080/class';
      const response = await fetch(url);
      console.log(response.clone().text)
      const result = await response.json();
      commit("setAllClasses", result);
    },
    getAllEducations: async function ({
      commit
    }) {
      let url = "http://localhost:8080/education";
      const result = await fetch(url);
      const json = await result.json();
      commit("setAllEducations", json);
    },
    getAllCourses: async function ({
      commit
    }) {
      let url = "http://localhost:8080/course";
      const result = await fetch(url);
      const json = await result.json();
      commit("setAllCourses", json);
    },
    getAllUsers: async function ({
      commit
    }) {
      let url = "http://localhost:8080/user";
      const result = await fetch(url);
      const json = await result.json();
      commit("setAllUsers", json);
    },
    getMyClassAsTeacher: async function ({
      commit
    }, id) {
      let url = "http://localhost:8080/classroom/my/";
      const result = await fetch(url + id);
      const json = await result.json();
      commit("setMyClassAsTeacher", json);
    },
    getMyCourseAsTeacher: async function ({
      commit
    }, id) {
      let url = "http://localhost:8080/course/teacher/";
      const result = await fetch(url + id);
      const json = await result.json();
      commit("setMyCourseAsTeacher", json);
    },
    getMyCourse: async function ({
      commit
    }, id) {
      let url = "http://localhost:8080/course/user/";
      const result = await fetch(url + id);
      const json = await result.json();
      commit("setMyCourse", json);
    },
    getMyLecture: async function ({
      commit
    }, id) {
      let url = "http://localhost:8080/lecture/user/";
      const result = await fetch(url + id);
      const json = await result.json();
      commit("setMyLecture", json);
    },
    getClassByED: async function ({
      commit
    }, id) {
      let url = "http://localhost:8080/classroom/edu/";
      const result = await fetch(url + id);
      const json = await result.json();
      commit("setClassByED", json);
    },
    getUser: async function ({
      commit
    }, id) {
      let url = "http://localhost:8080/user/";
      const result = await fetch(url + id);
      const json = await result.json();
      commit("setUser", json);
    },
    getMessage: async function({ commit }){
      let url = "http://localhost:8080/message";
      const result = await fetch(url);
      const json = await result.json();
      commit("setMessage", json);
    },
    

    // deletUser: async function({ commit }, id) {
    //   let url = "http://localhost:8080/user";
    //   const result = await fetch(url);
    //   const json = await result.json();
    //   commit("setAllUsers", json);
    // }
  },
  modules: {}
})