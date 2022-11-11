<template>
  <div>
    <nav-page></nav-page>
    <main-page></main-page>
    <footer-page></footer-page>
  </div>
</template>

<script>
import FooterPage from "@/components/FooterPage.vue";
//import MainPage from "@/components/MainPage.vue";
import NavBar from "@/components/NavBar.vue";
import MapPage from "@/components/MapPage.vue";
export default {
  components: {
    "footer-page": FooterPage,
    "main-page": MapPage,
    "nav-page": NavBar,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
