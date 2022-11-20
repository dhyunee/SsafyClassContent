<template>
    <div class="modal" tabindex="-1" id="loginModal" style="top: 20%">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button id="loginModalCloseBtn" type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <h2 class="fw-bold mb-2">Login</h2>
                    <p class="mb-5">Please enter your login and password!</p>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="loginUserEmail">Email</label>
                        <input type="email" id="loginUserEmail" class="form-control form-control-lg" v-model="userEmail" />
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="loginUserPassword">Password</label>
                        <input type="password" id="loginUserPassword" class="form-control form-control-lg" v-model="userPassword" />
                    </div>

                    <button class="btn btn-outline-light btn-lg px-5" @click="login({ userEmail, userPassword })">Login</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { mapActions } from "vuex";

export default {
    data() {
        return {
            userEmail: "",
            userPassword: "",
        };
    },
    methods: {
        ...mapActions(["doLogin"]),
        login(user) {
            this.doLogin(user).then(() => {
                // document.getElementById("loginModalCloseBtn").click();
                this.$emit("call-parent-login");
            });
            // .catch(alert("로그인 중 에러가 발생했습니다."));
        },
    },
    mounted() {
        let $this = this;
        document.getElementById("loginModal").addEventListener("show.bs.modal", function () {
            $this.userEmail = "";
            $this.userPassword = "";
        });
    },
};
</script>

<style></style>
