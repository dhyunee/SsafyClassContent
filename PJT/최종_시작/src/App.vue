<template>
    <div id="app">
        <header-ui />
        <router-view></router-view>
        <footer-ui />
    </div>
</template>

<script>
import HeaderUi from "@/components/common/HeaderUI.vue";
import FooterUi from "@/components/common/FooterUI.vue";

export default {
    name: "App",
    components: {
        HeaderUi,
        FooterUi,
    },
};
</script>

<style></style>
