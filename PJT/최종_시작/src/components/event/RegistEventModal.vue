<template>
    <section class="vh-100 gradient-custom" id="LoginModal" >
  <div class="container py-5 h-100"  >
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5" >
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-4 text-center" style="max-height: 440px;">
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" @click="cancle" style="float:right"></button>
            <div class="mb-md-5 pb-5" style="margin-top: 40px;" >
              
                <h2 class="fw-bold mb-2 text-white">EVENT</h2>
                
                <div class="row" style="margin-top: 45px; margin-bottom: 20px;">
                  <div class="col-3">
                    <div style="text-align: left; margin-top: 10%; margin-left: 10%;">Event</div>
                  </div>
                  <div class="col-9">
                    <input type="text" id="eventName" class="form-control form-control-lg" v-model="eventName" placeholder="이벤트" />
                  </div>
                </div>

            <div class="form-outline form-white" style="margin-bottom:30px ;">
                <div class="row">
                    <div class="col-6">
                        <input type="date" id="eventFrom" class="form-control form-control-lg" v-model="eventFrom" />
                        <p class="text-whilte" style="margin-bottom: 10px;">시작일</p>
                    </div>
                    <div class="col-6">
                        <input type="date" id="eventTo" class="form-control form-control-lg" v-model="eventTo" />
                        <p class="text-whilte" style="margin-bottom: 10px; ">종료일</p>
                    </div>
              </div>
            </div>
               
            <button class="btn btn-outline-light btn-lg px-5" @click="registEvent" style="color:white">Event</button>

            <div class="d-flex justify-content-center text-center mt-4 pt-1">
                <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
            </div>
            </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import axios from "axios";
export default {
    data(){
        return{
            eventName:"",
            eventFrom:"",
            eventTo:""
        }
    },
    methods:{
        registEvent(){
            axios.post("/events",{
                evnetName:this.eventName,
                eventFrom:this.eventFrom,
                eventTo:this.eventTo
            }).then((res)=>{
                alert("이벤트 등록");
                console.log(res);
            })
        },
        cancle(){
      this.$emit("call-parent-cancle-regist-event");
    },
    }
};
</script>

<style></style>
