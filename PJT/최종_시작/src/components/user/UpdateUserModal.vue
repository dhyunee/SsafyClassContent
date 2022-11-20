<template>
    <div class="modal" tabindex="-1" id="updateUserModal" style="top: 20%">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <h2 class="fw-bold" style="margin-bottom: 40px; text-align: center">회원정보 수정</h2>
                    <div class="form-outline" style="margin-bottom: 25px">
                        <div class="row">
                            <div class="col-3">
                                <div style="text-align: left; margin-top: 10%; margin-left: 10%">Name</div>
                            </div>
                            <div class="col-9">
                                <input type="text" id="updateUserNameInput" class="form-control form-control-lg" :value="userName" readonly />
                            </div>
                        </div>
                    </div>

                    <div class="form-outline form-white" style="margin-bottom: 25px">
                        <div class="row">
                            <div class="col-3">
                                <div style="text-align: left; margin-top: 10%; margin-left: 10%">Email</div>
                            </div>
                            <div class="col-9">
                                <input type="email" id="updateUserEmailInput" class="form-control form-control-lg" :value="userEmail" readonly />
                            </div>
                        </div>
                    </div>

                    <div class="form-outline form-white" style="margin-bottom: 25px">
                        <div class="row">
                            <div class="col-3">
                                <div style="text-align: left; margin-top: 10%; margin-left: 10%">Password</div>
                            </div>
                            <div class="col-9">
                                <input type="password" id="updateUserPasswordInput" class="form-control form-control-lg" v-model="userPassword" style="margin-bottom: 8px" placeholder="Password" />
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

                    <button class="btn btn-outline-light btn-lg px-5" @click="doupdateUser">Regist</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import http from "@/common/axios.js";
import { mapState, mapActions } from "vuex";
// import router from "@/routers/router.js";

const houseStore = "houseStore";

export default {
    data() {
        return {
            userSeq: "",
            userEmail: "", //this.$store.state.userInfo.userEmail,
            userName: "", //this.$store.state.userInfo.userName,
            sidoCode: "",
            sidoName: "",
            gugunCode: "",
            gugunName: "",
            dongCode: "",
            dongName: "",
            userPassword: "",
            confirmPassword: "",
            sido: "", //{ value: this.$store.state.userInfo.sidoCode, text: this.$store.state.userInfo.sidoName },
            gugun: "", //{ value: this.$store.state.userInfo.gugunCode, text: this.$store.state.userInfo.gugunName },
            dong: "", //{ value: this.$store.state.userInfo.dongCode, text: this.$store.state.userInfo.dongName },
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
        doupdateUser() {
            if (this.userPwd === "") {
                // this.userPwd = "";
                this.$refs.userPwd.focus();
                this.$refs.userPwd.blur();
                return;
            }

            http.put("/users/" + this.userSeq, {
                userSeq: this.userSeq,
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
                .then((res) => {
                    this.$store.dispatch("doLogout");
                    alert("정보 수정 완료\n다시 로그인해주세요");
                    console.log(res);
                    // window.location.href = "/";
                    this.$emit("call-parent-update-user");
                })
                .catch((err) => {
                    alert(err);
                });
        },
    },
    computed: {
        ...mapState(houseStore, ["sidoList", "gugunList", "dongList"]),
    },
    mounted() {
        let $this = this;
        document.getElementById("updateUserModal").addEventListener("show.bs.modal", function () {
            $this.userSeq = $this.$store.state.userInfo.userSeq;
            $this.userName = $this.$store.state.userInfo.userName;
            $this.userEmail = $this.$store.state.userInfo.userEmail;
            // $this.userPassword = $this.$store.state.userInfo.userPassword; // 나중에 다른 방법으로 인증
            $this.$store.state.userInfo.sidoCode == null ? ($this.sido = "") : ($this.sido = { value: $this.$store.state.userInfo.sidoCode, text: $this.$store.state.userInfo.sidoName });
            $this.$store.state.userInfo.gugunCode == null ? ($this.gugun = "") : ($this.gugun = { value: $this.$store.state.userInfo.gugunCode, text: $this.$store.state.userInfo.gugunName });
            $this.$store.state.userInfo.dongCode == null ? ($this.dong = "") : ($this.dong = { value: $this.$store.state.userInfo.dongCode, text: $this.$store.state.userInfo.dongName });

            $this.getSido();
            $this.getGugun($this.sido.value);
            $this.getDong($this.gugun.value);
        });
    },
};
</script>

<style></style>
