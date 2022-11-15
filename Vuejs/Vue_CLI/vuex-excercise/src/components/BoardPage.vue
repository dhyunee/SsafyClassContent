<template>
  <div>
    <h4>Board Page</h4>
    검색어 1
    <input type="text" v-model="searchWord" /><button v-on:click="search1">Search1</button>
    검색어 2
    <input type="text" v-model="$store.state.board.searchWord" /><button v-on:click="search2">
      Search2
    </button>
    <hr />
    <h4>from data</h4>
    {{ searchWord }} {{ limit }} {{ offset }}
    <h4>from store</h4>
    {{ $store.state.board.searchWord }} {{ this.$store.state.board.limit }}
    {{ this.$store.state.board.offset }}
    <br />
    <button @click="nextPage">next page</button>
  </div>
</template>
<script>
export default {
  data() {
    return {
      searchWord: "",
      limit: 5,
      offset: 10,
    };
  },
  methods: {
    search1() {
      alert(`http request with ${this.searchWord} ${this.limit} ${this.offset}`);
    },
    search2() {
      alert(
        `http request with  ${this.$store.state.board.searchWord} ${this.$store.state.board.limit} ${this.$store.state.board.offset}`
      );
    },
    nextPage() {
      this.$store.dispatch("setBoard", { searchWord: "ssafy", limit: 20, offset: 999 });
    },
  },
};
</script>
<style></style>
