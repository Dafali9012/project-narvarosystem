import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from "vuex-persistedstate";


Vue.use(Vuex)

export default new Vuex.Store({
  plugins: [createPersistedState()],
  state: {
    contentIndex: 0,
    user: [],
    loggedInUser: {
      role:{
        access_overview : false,
        create_class: false,
        create_education: false,
        create_role: false,
        access_messages: false,
        access_classes_courses: false,
        access_calendar_teacher: false,
        access_calendar_student: false,
        access_course : false,
        access_user_edit: false,
        access_report: false,
      }
    },
    AllClass: [],
    AllEducation: [],
    AllCourse: [],
    AllUser: [],
    AllLecture: [],
    ecPersonnel: [],
    teachers: [],
    cities: [],
    roles: [],  
    ClassByED: [],
    Messages: [],
    newMessage: false,
    numberOfUnreadMessages:0,
    isLogged: false,
    messageToDelete: {},
    logged: false,
    MyLectureStudent: [],
    MyLectureTeacher: [],
    MyClassTeacher: [],
    MyCourseTeacher: [],
    MyCourseStudent: [],
    MyAttendanceStudent: [],
    MyAttendanceTeacher: [],
    MyStudentID: {}
  },
  mutations: {
    setNewMessage(state, value) {
      state.newMessage = value;
    },
    setNewMessageNr(state, value) {
      state.numberOfUnreadMessages = value;
    },
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
    setAllLectures(state, value) {
      state.AllLecture = value;
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
    setMyCourseStudent(state, value) {
      state.MyCourseStudent = value;
    },
    setMessage(state, value) {
      state.Messages = value;
    },
    setMyLectureStudent(state, value){
      state.MyLectureStudent = value;
    },
    setMyLectureTeacher(state, value){
      state.MyLectureTeacher = value;
    },
    setMyCourseTeacher(state, value){
      state.MyCourseTeacher = value;
    },
    setMyClassTeacher(state, value){
      state.MyClassTeacher = value;
    },
    setMyStudentID(state, value){
      state.MyStudentID = value;
    },
    setMyAttendanceStudent(state, value){
      state.MyAttendanceStudent = value;
    },
    setMyAttendanceTeacher(state, value){
      state.MyAttendanceTeacher = value;
    }
  },
  actions: {
    async updateLoggedUser({
      commit
    }) {
      let response = await fetch("/login/name")

      if (response.status==500) {
        commit('isLogged', false)
      } else {
        let result = await response.json()
        commit('isLogged', true)
        commit('changeLoggedUser', result)

        commit('isLogged', true)
        
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
    getAllLectures: async function ({
      commit
    }) {
      let url = "http://localhost:8080/lecture";
      const result = await fetch(url);
      const json = await result.json();
      commit("setAllLectures", json);
    }, 
    getMyStudentID: async function ({
      commit
    }, id) {
      let url = "http://localhost:8080/student/user/";
      const result = await fetch(url + id);
      const json = await result.json();
      commit("setMyStudentID", json);
    },  
    getMyAttendanceStudent: async function ({
      commit
    }, id) {
      let url = "http://localhost:8080/attendance/student/my/";
      const result = await fetch(url + id);
      const json = await result.json();
      commit("setMyAttendanceStudent", json);
    }, 
    getMyAttendanceTeacher: async function ({
      commit
    }, id) {
      let url = "http://localhost:8080/attendance/teacher/my/";
      const result = await fetch(url + id);
      const json = await result.json();
      commit("setMyAttendanceTeacher", json);
    }, 
    getMyCourseStudent: async function ({
      commit
    }, id) {
      let url = "http://localhost:8080/course/student/";
      const result = await fetch(url + id);
      const json = await result.json();
      commit("setMyCourseStudent", json);
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
    getMyCourseTeacher: async function ({
      commit
    }, id) {
      let url = "http://localhost:8080/course/teacher/my/";
      const result = await fetch(url + id);
      const json = await result.json();
      commit("setMyCourseTeacher", json);
    },
    getMyClassTeacher: async function ({
      commit
    }, id) {
      let url = "http://localhost:8080/class/teacher/my/";
      const result = await fetch(url + id);
      const json = await result.json();
      commit("setMyClassTeacher", json);
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

    getMessage: async function ({ commit }) {
      let url = "http://localhost:8080/message";
      const result = await fetch(url);
      const json = await result.json();

      commit("setNewMessageNr", 0 )
      let nrOfNewMessages = 0;
      json.forEach( message => {
        if(message.receiver_id == this.state.loggedInUser.id){

          if(message.seen == false){
            console.log('mess ->',message)
            commit("setNewMessage", true)
            nrOfNewMessages ++
          } else{
            commit("setNewMessage",false)
          }
        }
      })

      console.log('msg nr',nrOfNewMessages)
      commit("setNewMessageNr", nrOfNewMessages)
      commit("setMessage", json);
    }

  },
  modules: {}
})