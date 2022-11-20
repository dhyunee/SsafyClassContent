<template>
  <div>
    <h4>SelectUI</h4>
    <select v-model="$store.state.selectedHobby">
      <option
        v-for="(item, index) in $store.state.hobbyList"
        :key="index"
        v-bind:value="item.value"
      >
        {{ item.name }}
      </option>
    </select>
  </div>
</template>
<script>
export default {
  created() {
    let hobbyList = [
      { name: "Drink", value: "DRK" },
      { name: "Swim", value: "SWM" },
      { name: "Drawing", value: "DRW" },
    ];

    this.$store.dispatch("setHobbyList", hobbyList);
  },
  data() {},
};
</script>
<style></style>
