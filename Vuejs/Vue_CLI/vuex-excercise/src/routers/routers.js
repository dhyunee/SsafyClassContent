import Vue from "vue";
import VueRouter from "vue-router";
import HomePage from "@/components/HomePage";
import AboutPage from "@/components/AboutPage";
import BoardPage from "@/components/BoardPage";
import StoreWatch from "@/components/StoreWatch";

Vue.use(VueRouter);

export default new VueRouter({
  routes: [
    {
      path: "/home",
      name: "/Home",
      component: HomePage,
    },
    {
      path: "/about",
      name: "/About",
      component: AboutPage,
    },
    {
      path: "/board",
      name: "/Board",
      component: BoardPage,
    },
    {
      path: "/storewatch",
      name: "/StoreWatch",
      component: StoreWatch,
    },
  ],
});
