import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

// import router from "../routers/index.js";
import http from "@/common/axios.js";

import houseStore from "@/store/modules/houseStore.js";

Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        houseStore,
    },
    state: {
        // 컴포넌트 간에 공유할 data
        isLogin: false,
        isLoginError: false,
        userInfo: null,

        isAuthor: false,
        selectedBoard: {
            boardTitle: "",
        },
    },
    mutations: {
        // state의 변화를 일으키는 곳

        // 로그인 & 로그아웃
        SET_IS_LOGIN(state, isLogin) {
            state.isLogin = isLogin;
            state.isLoginError = false;
        },

        // 로그인이 실패했을 때
        SET_IS_LOGIN_ERROR(state) {
            state.isLogin = false;
            state.isLoginError = true;
        },

        SET_USER_INFO(state, userInfo) {
            state.isLogin = true;
            state.isLoginError = false;
            state.userInfo = userInfo;
        },
        CLEAR_SELECTED_BOARD(state) {
            state.selectedBoard = null;
        },
        SET_SELECTED_BOARD(state, board) {
            state.selectedBoard = board;
        },
        SET_ISAUTHOR(state, userSeq) {
            state.isAuthor = state.userInfo.userSeq == userSeq;
        },
    },
    actions: {
        doLogin({ commit }, user) {
            http.post("/login", user)
                .then(({ data }) => {
                    commit("SET_USER_INFO", data.data);
                    commit("SET_IS_LOGIN", true);
                    sessionStorage.setItem("userName", data.data.userName);
                })
                .catch((err) => {
                    console.log(err);
                    alert("인증되지 않은 이메일입니다.");
                    // router.push({ name: "MainPage" });
                });
        },

        // 로그아웃 시도
        doLogout({ commit }) {
            commit("SET_USER_INFO", null);
            commit("SET_IS_LOGIN", false);
            sessionStorage.removeItem("userName");

            alert("정상적으로 로그아웃 되었습니다.");
            // router.push({ name: "MainPage" });
        },
        getBoard({ commit }, boardId) {
            http.get("/boards/" + boardId)
                .then(({ data }) => {
                    commit("SET_SELECTED_BOARD", data.data);
                    commit("SET_ISAUTHOR", data.data.userSeq);
                })
                .catch((err) => console.log(err));
        },
    },
    plugins: [
        createPersistedState({
            // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
            storage: sessionStorage,
        }),
    ],
});
