<template>
  <div>
    <h4>HomeSub</h4>
    {{ $store.state.message }} {{ $store.state.count }}
    <button @click="changeCount">change count to 10</button>
    <button @click="changeMessage">change message to 'SSAFY'</button>
  </div>
</template>
<script>
export default {
  methods: {
    changeCount() {
      alert(1);
      this.$store.dispatch("setCount", 10);
    },
    changeMessage() {
      alert(2);
      this.$store.dispatch("setMessage", "SSAFY");
    },
  },
};
</script>
<style></style>
