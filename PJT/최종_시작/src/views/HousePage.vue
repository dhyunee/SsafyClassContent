<template>
    <div>
        <search-bar></search-bar>
        <map-view></map-view>
        <house-list></house-list>
    </div>
</template>

<script>
import SearchBar from "@/components/house/SearchBar.vue"
import MapView from "@/components/house/MapView";
import HouseList from "@/components/house/HouseList";

export default {
    data() {
        return {};
    },
    components: {
        SearchBar,
        MapView,
        HouseList,
    },
};
</script>

<style></style>
