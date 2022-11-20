<template>
    <div class="modal" tabindex="-1" id="registUserModal" style="top: 20%">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <h2 class="fw-bold" style="margin-bottom: 40px; text-align: center">Sign up</h2>
                    <div class="form-outline" style="margin-bottom: 25px">
                        <div class="row">
                            <div class="col-3">
                                <div style="text-align: left; margin-top: 10%; margin-left: 10%">Name</div>
                            </div>
                            <div class="col-9">
                                <input type="text" id="registUserNameInput" class="form-control form-control-lg" v-model="userName" placeholder="Name" />
                            </div>
                        </div>
                    </div>

                    <div class="form-outline form-white" style="margin-bottom: 25px">
                        <div class="row">
                            <div class="col-3">
                                <div style="text-align: left; margin-top: 10%; margin-left: 10%">Email</div>
                            </div>
                            <div class="col-9">
                                <input type="email" id="registUserEmailInput" class="form-control form-control-lg" v-model="userEmail" placeholder="Email" />
                            </div>
                        </div>
                    </div>

                    <div class="form-outline form-white" style="margin-bottom: 25px">
                        <div class="row">
                            <div class="col-3">
                                <div style="text-align: left; margin-top: 10%; margin-left: 10%">Password</div>
                            </div>
                            <div class="col-9">
                                <input type="password" id="registUserPasswordInput" class="form-control form-control-lg" v-model="userPassword" style="margin-bottom: 8px" placeholder="Password" />
                                <input type="password" class="form-control form-control-lg" v-model="confirmPassword" placeholder="비밀번호 확인" />
                                <p class="error-msg" v-if="userPassword != confirmPassword">비밀번호가 일치하지 않습니다.</p>
                            </div>
                        </div>
                    </div>

                    <div class="form-outline form-white" style="margin-bottom: 40px">
                        <div class="row">
                            <div class="col-3">
                                <div style="text-align: left; margin-top: 10%; margin-left: 10%">My 지역</div>
                            </div>
                            <div class="col-9">
                                <label for="sidoSelectBar">시/도</label>
                                <select id="sidoSelectBar" v-model="sido" @change="selectSido(sido)">
                                    <option value="" seleted disabled hidden>선택해주세요.</option>
                                    <option v-for="(sido, idx) in sidoList" :key="idx" :value="sido">
                                        {{ sido.text }}
                                    </option>
                                </select>
                                <label for="gugunSelectBar">구/군</label>
                                <select id="gugunSelectBar" v-model="gugun" @change="selectGugun(gugun)">
                                    <option value="" seleted disabled hidden>선택해주세요.</option>
                                    <option v-for="(gugun, idx) in gugunList" :key="idx" :value="gugun">
                                        {{ gugun.text }}
                                    </option>
                                </select>
                                <label for="dongSelectBar">동</label>
                                <select id="dongSelectBar" v-model="dong">
                                    <option value="" seleted disabled hidden>선택해주세요.</option>
                                    <option v-for="(dong, idx) in dongList" :key="idx" :value="dong">
                                        {{ dong.text }}
                                    </option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <button class="btn btn-outline-light btn-lg px-5" @click="doRegist">Regist</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import http from "@/common/axios.js";
// import router from "@/routers/index.js";

const houseStore = "houseStore";

export default {
    data() {
        return {
            userName: "",
            userEmail: "",
            userPassword: "",
            confirmPassword: "",

            sido: "",
            gugun: "",
            dong: "",
        };
    },
    methods: {
        ...mapActions(houseStore, ["getSido", "getGugun", "getDong"]),
        selectSido(sido) {
            this.gugun = "";
            this.dong = "";

            this.getGugun(sido.value);
        },
        selectGugun(gugun) {
            this.dong = "";

            this.getDong(gugun.value);
        },
        doRegist() {
            http.post("/users", {
                userEmail: this.userEmail,
                userPassword: this.userPassword,
                userName: this.userName,
                sidoCode: this.sido.value,
                sidoName: this.sido.text,
                gugunCode: this.gugun.value,
                gugunName: this.gugun.text,
                dongCode: this.dong.value,
                dongName: this.dong.text,
            })
                .then(() => {
                    alert("회원가입에 성공했습니다");
                    this.$emit("call-parent-regist-user");
                    // router.push({ name: "MainPage" });
                })
                .catch((err) => {
                    alert("회원가입에 실패했습니다");
                    console.log(err);
                });
        },
    },
    computed: {
        ...mapState(houseStore, ["sidoList", "gugunList", "dongList"]),
    },
    mounted() {
        this.getSido();

        let $this = this;
        document.getElementById("registUserModal").addEventListener("show.bs.modal", function () {
            $this.userEmail = "";
            $this.userPassword = "";
        });
    },
};
</script>

<style></style>
