<template>
  <div
    class="modal fade"
    id="loginModal"
    tabindex="-1"
    role="dialog"
    aria-labelledby="exampleModalCenterTitle"
    aria-hidden="true"
  >
    <div class="modal-dialog modal-dialog-centered" role="document" style="max-width: 450px">
      <div class="modal-content">
        <div class="modal-header">
          <button
            id="loginModalCloseBtn"
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
          <h3 class="text-center mb-4" id="signIn">Sign In</h3>
          <form action="#" class="login-form">
            <div class="form-group">
              <input
                type="text"
                class="form-control rounded-left"
                placeholder="Email"
                v-model="userEmail"
              />
            </div>
            <div class="form-group d-flex">
              <input
                type="password"
                class="form-control rounded-left"
                placeholder="Password"
                v-model="userPassword"
              />
            </div>
            <div class="form-group">
              <button
                class="btn py-3 px-5 me-3 animated fadeIn"
                style="margin-top: 1.5rem; width: 100%"
                id="login"
                @click="login({ userEmail, userPassword })"
              >
                Login
              </button>
            </div>
          </form>
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
  flex-direction: column;
  width: 100%;
  pointer-events: auto;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid rgba(0, 0, 0, 0.2);
  border-radius: 0.3rem;
  outline: 0;
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
#login {
  background-color: #00b98e;
  color: #fff;
}
</style>
