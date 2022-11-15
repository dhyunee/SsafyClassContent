<template>
  <div>
    <h4>About Page</h4>
    <hr />
    <h4>from data</h4>
    {{ message }} {{ count }}
    <hr />
    <h4>from store</h4>
    {{ $store.state.message }} {{ $store.state.count }}
  </div>
</template>
<script>
export default {
  data() {
    return {
      message: this.$store.state.message,
      count: this.$store.state.count,
      //data를 store에서 바꿔도 생성 처음에만 가지고 와서 data측 그대로 가져옴
    };
  },
};
</script>
<style></style>
