export default {
  template: `
  <div>
    <div class="mb-3">
      <label for="userId" class="form-label">아이디</label>
      <input type="text" class="form-control" id="userId" placeholder="아이디를 입력하세요" v-model="userId">
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">패스워드</label>
      <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력하세요" v-model="password">
    </div>
    <button class="btn btn-primary" @click="login">Login</button>
  </div>
  `,
  data() {
    return {
      userId: "",
      password: "",
    };
  },
  methods: {
    login() {
      alert(this.userId + " " + this.password);
    },
  },
};
