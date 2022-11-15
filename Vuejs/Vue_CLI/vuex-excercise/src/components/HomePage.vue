<template>
  <div>
    <h4>Home Page</h4>
    <hr />
    <h4>from data</h4>
    {{ message }} {{ count }}
    <hr />
    <h4>from store</h4>
    {{ $store.state.message }} {{ $store.state.count }}
    <hr />
    <h4>from store getters</h4>
    {{ $store.getters.getReversedMessage }} {{ $store.getters.isCountEven }}
    <hr />
    <h4>from store map getters</h4>
    {{ getReversedMessage }} {{ checkCountisEven }}
    <hr />
    <HomeSub></HomeSub>
  </div>
</template>
<script>
import HomeSub from "@/components/HomeSub.vue";
import { mapGetters } from "vuex";
export default {
  components: { HomeSub },
  data() {
    return {
      message: this.$store.state.message,
      count: this.$store.state.count,
      //data를 store에서 바꿔도 생성 처음에만 가지고 와서 data측 그대로 가져옴
    };
  },
  computed: {
    ...mapGetters(["getReversedMessage"]),
    ...mapGetters({ checkCountisEven: "isCountEven" }), //alias
  },
};
</script>
<style></style>
