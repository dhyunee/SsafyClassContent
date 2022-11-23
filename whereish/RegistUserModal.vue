<template>
  <div
    class="modal fade"
    id="registUserModal"
    tabindex="-1"
    role="dialog"
    aria-labelledby="exampleModalCenterTitle"
    aria-hidden="true"
  >
    <div
      class="modal-dialog modal-dialog-centered"
      role="document"
      style="max-width: 450px max-height:600px"
    >
      <div class="modal-content">
        <div class="modal-header">
          <button
            id="registModalCloseBtn"
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
            style="margin-right: 3px; margin-top: 3px"
          ></button>
        </div>
        <div class="modal-body p-4 p-md-5">
          <div class="icon d-flex align-items-center justify-content-center">
            <img class="ion-ios-person" src="@/assets/img/login-register.png" alt="Icon" />
          </div>
          <h3 class="text-center mb-4" id="signIn">Sign Up</h3>

          <div class="form-outline" style="margin-bottom: 25px">
            <input
              type="text"
              id="registUserNameInput"
              class="form-control form-control-lg"
              v-model="userName"
              placeholder="Name"
            />
          </div>

          <div class="form-outline form-white" style="margin-bottom: 25px">
            <input
              type="email"
              id="registUserEmailInput"
              class="form-control form-control-lg"
              v-model="userEmail"
              placeholder="Email"
            />
          </div>

          <div class="form-outline form-white" style="margin-bottom: 25px">
            <input
              type="password"
              id="registUserPasswordInput"
              class="form-control form-control-lg"
              v-model="userPassword"
              style="margin-bottom: 8px"
              placeholder="Password"
            />
          </div>
          <div class="form-outline form-white" style="margin-bottom: 15px">
            <input
              type="password"
              class="form-control form-control-lg"
              v-model="confirmPassword"
              placeholder="비밀번호 확인"
              style="margin-bottom: 2px"
            />
            <p class="error-msg" v-show="userPassword != confirmPassword">
              비밀번호가 일치하지 않습니다.
            </p>
            <p v-show="userPassword == confirmPassword"><br /></p>
          </div>

          <div class="form-outline form-white" style="margin-bottom: 20px">
            <div style="text-align: left; margin-bottom: 15px; margin-left: 1%">
              <strong>My 지역</strong>
            </div>
            <div class="row">
              <div class="col">
                <select
                  class="border-0"
                  id="sidoSelectBar"
                  v-model="sido"
                  @change="selectSido(sido)"
                >
                  <option value="" seleted disabled hidden>시/도</option>
                  <option v-for="(sido, idx) in sidoList" :key="idx" :value="sido">
                    {{ sido.text }}
                  </option>
                </select>
              </div>
              <div class="col">
                <select
                  class="border-0"
                  id="gugunSelectBar"
                  v-model="gugun"
                  @change="selectGugun(gugun)"
                >
                  <option value="" seleted disabled hidden>구군</option>
                  <option v-for="(gugun, idx) in gugunList" :key="idx" :value="gugun">
                    {{ gugun.text }}
                  </option>
                </select>
              </div>
              <div class="col">
                <select class="border-0" id="dongSelectBar" v-model="dong">
                  <option value="" seleted disabled hidden>동</option>
                  <option v-for="(dong, idx) in dongList" :key="idx" :value="dong">
                    {{ dong.text }}
                  </option>
                </select>
              </div>
            </div>
          </div>
          <div class="form-group">
            <button
              class="btn py-3 px-5 me-3 animated fadeIn"
              style="margin-top: 1.5rem; width: 100%"
              id="registUser"
              @click="doRegist"
            >
              Regist
            </button>
          </div>
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
      http
        .post("/users", {
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

<style>
.modal-dialog {
  position: relative;
  width: auto;
  margin: 0.5rem;
  pointer-events: none;
}

.modal.show .modal-dialog {
  -webkit-transform: none;
  -ms-transform: none;
  transform: none;
}
.modal-content {
  position: relative;
  display: flex;

  width: 100%;
  pointer-events: auto;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid rgba(0, 0, 0, 0.2);
  border-radius: 0.3rem;
  outline: 0;
  max-height: 60%;
}
.modal-content .modal-header {
  position: relative;
  padding: 0;
  border: none;
}

.modal-content .modal-body {
  border: none;
}
.modal-content .modal-body .icon {
  width: 80px;
  height: 80px;
  border: 1px solid #fb8691;
  border-radius: 50%;
  font-size: 30px;
  margin: 0 auto;
  margin-bottom: 10px;
}
.modal-content .modal-body .icon span {
  color: #fb8691;
}

.form-control {
  display: block;
  width: 100%;
  height: calc(1.5em + 0.75rem + 2px);
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
  margin-bottom: 1rem;
}
.form-control::placeholder {
  color: #6c757d;
  opacity: 1;
}
.modal-content .modal-body .icon {
  width: 80px;
  height: 80px;
  border: 1px solid #fb8691;
  border-radius: 50%;
  font-size: 30px;
  margin: 0 auto;
  margin-bottom: 10px;
}
.ion-ios-person {
  vertical-align: middle;
  width: 55px;
  height: 55px;
}
#registUser {
  background-color: #00b98e;
  color: #fff;
}
</style>
