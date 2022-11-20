<template>
  <div>
    <search-bar></search-bar>
    <main-ui></main-ui>
    <latest-board-list></latest-board-list>
    <latest-event-list></latest-event-list>
  </div>
</template>

<script>
import SearchBar from "@/components/house/SearchBar.vue";
import MainUi from "@/components/common/MainUI.vue";
import LatestBoardList from "@/components/board/LatestBoardList.vue";
import LatestEventList from "@/components/event/LatestEventList.vue";

export default {
  components: {
    SearchBar,
    LatestEventList,
    LatestBoardList,
    MainUi,
  },
};
</script>

<style></style>
