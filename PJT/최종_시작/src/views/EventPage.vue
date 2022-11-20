<template>
  <div>
    <event-list></event-list>
    <pagination-ui></pagination-ui>
  </div>
</template>

<script>
import EventList from "@/components/event/EventList";
import PaginationUi from "@/components/common/PaginationUI";

export default {
  components: {
    EventList,

    PaginationUi,
  },
};
</script>

<style></style>
