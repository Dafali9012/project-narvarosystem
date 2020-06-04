<template>
    <div class="mt-5">
      <div class="row">
          <div class="col">
                <div class="mt-6 d-flex justify-content-center">
                    <select class="form-control width-42" id="user" name="User" v-model="receiverUser">
                        <option  value="" disabled selected>User</option>
                        <option v-for="user in allUsers" :key="user.userID">{{user.name}}</option>
                    </select>
                </div>
                <button v-on:click="cons" class="mt-5" >Click</button>
                <div class="mt-4 d-flex justify-content-center">
                <input
                    class="form-control width-84"
                    type="text"
                    rows="1"
                    placeholder="Subject"
                    id="edu-desc"
                    v-model="message.subject"
                />
                </div>
                <div class="mt-4 d-flex justify-content-center">
                <textarea
                    class="form-control width-84"
                    type="text"
                    rows="6"
                    placeholder="Message"
                    id="edu-desc"
                    v-model="message.message"
                />
                </div>
                <div class="container d-flex justify-content-end">
                    <button v-on:click="send">send</button>            
                </div>
                <div class="container">
                    <div class="row">
                        <ul>
                            <li v-for="message in userReceivedMessages" :key="message.id">{{message.message}}</li>
                            <li v-for="message in userReceivedMessages" :key="message.id">{{message.subject}}</li>
                        </ul>
                    </div>
                </div>
          </div>
          <div class="col"></div>
      </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            allUsers:[],
            loggedUser:{},
            receiverUser:{},
            message:{
                senderID:"",
                receiverID:"",
                subject:"",
                message:"",
                date:"",
            },
            userReceivedMessages:[]
        }
    },
    computed:{
        getUsers(){
           return this.$store.state.AllUser
        },
        getLoggedUser(){
            return this.$store.state.loggedInUser
        },
        getReceivedMessages(){
            return this.$store.state.Messages
        }
    },
    // this.getReceivedMessages
    methods:{
        setUsers(){
            this.getUsers.forEach( user => {
                if(user){
                    this.allUsers.push(user)
                }
            })
        },
        setLoggedUser(){
            this.loggedUser =  this.getLoggedUser;
        },
        setReceiver(){
            this.allUsers.forEach(user =>{
                if(user.name == this.receiverUser){
                    this.receiverUser = user
                }
            })
        },
        setReceivedMassage(){
            this.getReceivedMessages.forEach( message =>{
                if(message){
                    this.userReceivedMessages.push(message)
                }
            })
        },
      async  send(){
            this.setReceiver()
            this.message.senderID = this.loggedUser.userID
            this.message.receiverID = this.receiverUser.userID
            let today = new Date();
            this.message.date = today;
            let response = await fetch("http://localhost:8080/message", {
            method: "post",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(this.message)
            });
            let result = await response.json();
            console.log(result)
            console.log(this.message)
        },
        cons(){
            this.setReceiver()
            console.log(this.receiverUser)
            console.log(this.userReceivedMessages)
        }

    },
   async created(){
       await this.setReceivedMassage();
       await this.$store.dispatch("getAllusers")
       await this.setUsers()
       await this.setLoggedUser()
    }
}
</script>

<style>

</style>