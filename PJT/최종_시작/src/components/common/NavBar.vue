<template>
    <div>
        <div class="container-fluid nav-bar bg-transparent">
            <nav class="navbar navbar-expand-lg bg-white navbar-light py-0 px-4" style="radius-border">
                <a href="index.html" class="navbar-brand d-flex align-items-center text-center">
                    <div class="icon p-2 me-2">
                        <img class="img-fluid" src="@/assets/img/icon-deal.png" alt="Icon" style="width: 30px; height: 30px" />
                    </div>
                    <h1 class="m-0 text-primary">Makaan</h1>
                </a>
                <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav ms-auto">
                        <router-link :to="{ name: 'MainPage' }" class="nav-item nav-link">Main</router-link>
                        <router-link :to="{ name: 'HousePage' }" class="nav-item nav-link">MapView</router-link>
                        <router-link :to="{ name: 'BoardPage' }" class="nav-item nav-link">게시판</router-link>
                        <router-link :to="{ name: 'EventPage' }" class="nav-item nav-link">이벤트</router-link>

                        <a v-if="!isLogin" class="nav-item nav-link" @click="moveLoginModal">로그인</a>
                        <a v-if="!isLogin" class="nav-item nav-link" @click="moveRegistUserModal">회원가입</a>
                        <a v-if="isLogin" class="nav-item nav-link" @click="$store.dispatch('doLogout')">로그아웃</a>
                        <a v-if="isLogin" class="nav-item nav-link" @click="moveUpdateUserModal">마이페이지</a>
                    </div>
                </div>
            </nav>
        </div>
        <login-modal @call-parent-login="closeLoginModal"></login-modal>
        <regist-user-modal @call-parent-regist-user="closeRegistUserModal"></regist-user-modal>
        <update-user-modal @call-parent-update-user="closeUpdateUserModal"></update-user-modal>
    </div>
</template>

<script>
import LoginModal from "@/components/user/LoginModal";
import UpdateUserModal from "@/components/user/UpdateUserModal";
import RegistUserModal from "@/components/user/RegistUserModal";
import { mapState } from "vuex";
import { Modal } from "bootstrap";

export default {
    data() {
        return {
            loginBtnMsg: "",
            registBtnMsg: "",
            loginModal: null,
            updateUserModal: null,
            registUserModal: null,
        };
    },
    components: {
        LoginModal,
        UpdateUserModal,
        RegistUserModal,
    },
    computed: {
        ...mapState(["isLogin", "userInfo"]),
    },
    methods: {
        moveLoginModal() {
            this.loginModal.show();

            this.updateUserModal.hide();
            this.registUserModal.hide();
        },
        moveUpdateUserModal() {
            this.updateUserModal.show();

            this.loginModal.hide();
            this.registUserModal.hide();
        },

        moveRegistUserModal() {
            this.registUserModal.show();

            this.updateUserModal.hide();
            this.loginModal.hide();
        },
        closeLoginModal() {
            // this.loginModal = false;
            this.loginModal.hide();
        },
        closeRegistUserModal() {
            this.registUserModal.hide();
        },
        closeUpdateUserModal() {
            this.updateUserModal.hide();
        },
    },
    mounted() {
        this.loginModal = new Modal(document.querySelector("#loginModal"));
        this.registUserModal = new Modal(document.querySelector("#registUserModal"));
        this.updateUserModal = new Modal(document.querySelector("#updateUserModal"));
    },
};
</script>

<style></style>
