import Vue from 'vue'
import Vuex from 'vuex'
import router from '@/router'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    contentIndex: 0,
    user: [],
    loggedInUser: {

      
    },
    AllClass: [],
    AllEducation: [],
    AllCourse: [],
    AllUser: [],
    ecPersonnel: [],
    teachers: [],
    cities: [],
    roles: [],  
    ClassByED: [],
    Messages: [],
    messageToDelete: {},
    logged: false,
    MyLectureStudent: [],
    MyLectureTeacher: []

  },
  mutations: {
    setMessageToDelete(state, value) {
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
    setClassByED(state, value) {
      state.ClassByED = value;
    },
    setUser(state, value) {
      state.user = value;
    },
    setEcPersonnel(state, value) {
      state.ecPersonnel = value;
    },
    setTeachers(state, value) {
      state.teachers = value
    },
    setCities(state, value) {
      state.cities = value;
    },
    setRoles(state, value) {
      state.roles = value
    },
    setMessage(state, value) {
      state.Messages = value;
    },
    setMyLectureStudent(state, value){
      state.MyLectureStudent = value;
    },
    setMyLectureTeacher(state, value){
      state.MyLectureTeacher = value;
    }
  },
  actions: {
    async updateLoggedUser({
      commit
    }) {
      let response = await fetch("/login/name")

      if (response.status == 500) {
        commit('isLogged', false)
      } else {
        let result = await response.json()
        commit('changeLoggedUser', result)       

        commit('isLogged', true)
        if (result.role_id == 1) {
          router.push("/admin")
        }
      }
    },
    getAllClasses: async function ({
      commit
    }) {
      let url = 'http://localhost:8080/class';
      const response = await fetch(url);
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
    getMyLectureStudent: async function ({
      commit
    }, id) {
      let url = "http://localhost:8080/lecture/student/";
      const result = await fetch(url + id);
      const json = await result.json();
      commit("setMyLectureStudent", json);
    },
    getMyLectureTeacher: async function ({
      commit
    }, id) {
      let url = "http://localhost:8080/lecture/teacher/my/";
      const result = await fetch(url + id);
      const json = await result.json();
      commit("setMyLectureTeacher", json);
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
    async getEcPersonnel({
      commit
    }) {
      let response = await fetch("http://localhost:8080/personnel")
      let result = await response.json()
      commit("setEcPersonnel", result)
    },
    async getTeachers({
      commit
    }) {
      let response = await fetch("http://localhost:8080/teacher")
      let result = await response.json()
      commit("setTeachers", result)
    },
    async getCities({
      commit
    }) {
      let response = await fetch("http://localhost:8080/city")
      let result = await response.json()
      commit("setCities", result)
    },
    async getRoles({
      commit
    }) {
      let response = await fetch("http://localhost:8080/role")
      let result = await response.json()
      commit("setRoles", result)
    },
    getMessage: async function ({
      commit
    }) {
      let url = "http://localhost:8080/message";
      const result = await fetch(url);
      const json = await result.json();
      commit("setMessage", json);
    }
    // deletUser: async function({ commit }, id) {
    //   let url = "http://localhost:8080/user";
    //   const result = await fetch(url);
    //   const json = await result.json();
    //   commit("setAllUsers", json);
    // }
  },
  modules: {}
})