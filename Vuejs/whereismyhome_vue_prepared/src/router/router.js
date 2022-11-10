import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

// import MapPage from "@/components/MapPage.vue";
import NavBar from "@/components/NavBar.vue";
import MainPage from "@/components/MainPage.vue";
import FooterPage from "@/components/FooterPage.vue";

export default new VueRouter({
  routes: [
    {
      path: "/",
      components: {
        NavBar: NavBar,
        default: MainPage,
        Footer: FooterPage,
      },
    },
    {
      path: "/main",
      components: {
        NavBar: NavBar,
        default: MainPage,
        Footer: FooterPage,
      },
    },
    // {
    //   path: "/map",
    //   components: {
    //     NavBar: NavBar,
    //     default: MapPage,
    //     Footer: FooterPage,
    //   },
    // },
  ],
});
