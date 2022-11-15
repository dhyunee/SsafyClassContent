import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    message: "Vuex",
    count: 5,
    board: {
      limit: 10,
      offset: 0,
      searchWord: "",
    },
    hobbyList: [],
    selectedHobby: "",
  },
  //위의 state를 바꾸는 유일한 방법
  mutations: {
    SET_MESSAGE(state, message) {
      state.message = message;
    },
    SET_COUNT(state, count) {
      state.count = count;
    },
    SET_BOARD(state, payload) {
      state.board.limit = payload.limit;
      state.board.offset = payload.offset;
      state.board.searchWord = payload.searchWord;

      //state.board = payload;
    },
    SET_STORE(state, payload) {
      state.count = payload.count;
      state.message = payload.message;
    },
    SET_HOBBY_LIST(state, payload) {
      state.hobbyList = payload;
    },
  },
  //필요한 기능/ 동작을 수행 /일반적으로 수행결과를 state에 반영하기 위한 메소드 집합 , state에 반영할 때는 mutation이용
  //BE 요청 /결과 처리
  //BE 요청/ 결과 처리 코드는 component에 따라서 Component자체에 있을 수도 있고, vuex store에 코드가 있을 수도 있다.
  //비동기 처리가 많다.
  actions: {
    setMessage(context, message) {
      //setmessage가 비동기이면(async,awiat) , 동기=>mutatioin을 통해 처리
      context.commit("SET_MESSAGE", message);
    },
    setCount(context, count) {
      context.commit("SET_COUNT", count);
    },
    setBoard(context, payload) {
      context.commit("SET_BOARD", payload);
    },
    setStore(context, payload) {
      context.commit("SET_STORE", payload);
    },
    setHobbyList(context, payload) {
      context.commit("SET_HOBBY_LIST", payload);
    },
  },
  //저장소인 state의 값을 외부에 노출시키는 방법
  //그대로 또는 state의 데이터의변형을 처리한 후 결과를 return<==getters는 return이 있는 메소드
  getters: {
    getReversedMessage: function (state) {
      return state.message.split("").reverse().join("");
    },
    isCountEven: function (state) {
      return state.count % 2 == 0 ? "짝수" : "홀수";
    },
    getBoardInfo(state) {
      return state.board;
    },
  },
});
