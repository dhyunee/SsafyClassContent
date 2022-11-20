import Vue from "vue";
import App from "./App.vue";
import store from "./store";
import router from "./routers";

require("@/assets/css/style.css");
require("@/assets/css/bootstrap.min.css");

// for bootstrap 5
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap";

Vue.use(router);
Vue.config.productionTip = false;

new Vue({
    router,
    store,

    render: (h) => h(App),
}).$mount("#app");
