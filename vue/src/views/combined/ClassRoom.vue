<template>
  <div class="root d-flex flex-column container-fluid">
    <div class="content row mt-3">
      <div class="admin-sidebar col-sm-3">
        <CombinedSidebar />
      </div>
      <div class="col-9 d-flex">
        <div class="root d-flex flex-column container-fluid">
          <div class="content row mt-3 justify-content-center" style="user-select: none;">
            <div class="main col-9 mt-5">
              <div class="row" style="margin-top:10%;">
                <h3 class="col-12 text-left">Klassrum</h3>
                <div
                  class="content-line rounded background-primary"                  
                />
              </div>
                <div class=" col-4">
              <h4>elev</h4>
        <list class="pa-3">
            <div v-for="student in Students" :key="student.id">
            <draggable v-model="Students" :options="{group: { name:'students', pull:'clone', put:'false'}}" @start="drag=true" 
                @end="drag=false" :move="chooseStudent">
                
                <v-card class="ma-2 pa-2">
                <v-card-title>
                    <div class="headline">{{ Student.first_name }}</div>
                </v-card-title>
                </v-card>
               
            </draggable>
            </div>            
        </list>
                </div>

                <div class="col-8">
        <h4>Platser</h4>
        <div class="container">
            <div class="row">
                <div class="d-flex flex-nowrap" v-for="(value, key) in Place" :key = "key">
                    <div class="card ma-2 pa-2">
                        <draggable :id="key" v-model="Place" :options="{group:'platser'}" @start="drag=true" 
                            @end="drag=false" @add="newStudent">
                            <div class="card-header">
                            <div class="card-title headline"> 
                                {{ (key) }}
                            </div>
                           </div> 
                        </draggable>
                        <div class="card ma-2 pa-2" v-for="student in value" :key="student.id">
                            <div class="card-header">
                            <div class="card-title headline"> 
                                {{ student[0].name}}
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>

              
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import CombinedSidebar from "@/components/CombinedSidebar.vue"
  import draggable from 'vuedraggable'

export default {
  components: {
    CombinedSidebar,
    draggable
  },
  data: () => {
            return {
                Students: [],
                Place: {
                    Plats_1: [],
                    Plats_2: [],
                    Plats_3: [],
                    Plats_4: [],
                    Plats_5: [],
                    Plats_6: [],
                    Plats_7: [],
                    Plats_8: [],
                    Plats_9: [],
                    Plats_10: [],
                    Plats_11: [],
                    Plats_12: [],
                    Plats_13: [],
                    Plats_14: [],
                    Plats_15: [],
                    Plats_16: [],
                    Plats_17: [],
                    Plats_18: [],
                    Plats_19: [],
                    Plats_20: [],
                    Plats_21: [],
                    Plats_22: [],
                    Plats_23: [],
                    Plats_24: [],
                    Plats_25: [],
                    Plats_26: [],     
                    Plats_27: []                   
                }
            }
        },
};
</script>

