<template>
  <div>
    <div class="miniSearchBarWrapper">
      <mini-search-bar class="my-3 mx-1"></mini-search-bar>
    </div>
    <div class="houseListWrapper" v-show="$store.state.houseStore.houseList.length > 0">
      <div
        v-for="(house, idx) in $store.state.houseStore.houseList"
        :key="idx"
        class="card"
        style="width: auto"
        @click="$emit('moveToMarker', house.lat, house.lng)"
      >
        <div class="card-body">
          <h5 class="card-title">{{ house.aptName }}</h5>
          <p class="card-text">평균 면적 : {{ house.avgArea }} ㎡</p>
          <p class="card-text">
            평균 매매가 : {{ (house.avgDealAmount * 10000).toLocaleString() }} 원
          </p>
          <p class="card-text">건축 연도 : {{ house.buildYear }} 년</p>
        </div>
        <div class="houseListBtnWrapper">
          <button
            class="btn btn-sm btn-outline-primary my-1 px-1"
            @click="$emit('moveToMarkerClose', house.lat, house.lng)"
          >
            이동하기
          </button>
          <button
            class="btn btn-sm btn-outline-warning my-1 px-1"
            @click="$emit('openHouseDealListModal', house.no)"
          >
            상세정보
          </button>
        </div>
      </div>
      <!-- <div class="card" style="width: auto">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">
                        Some quick example text to build on the card title and make up the bulk of the card's content.
                    </p>
                    <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
            </div> -->
    </div>
  </div>
</template>

<script>
import MiniSearchBar from "@/components/house/MiniSearchBar.vue";

export default {
  components: {
    MiniSearchBar,
  },
  methods: {
    aslkdfaflh(house) {
      console.dir(window.kakao);
      
      this.parent.panTo(house.lat, house.lng);
    },
  },
};
</script>

<style>
.miniSearchBarWrapper {
  border: 1px solid black;
  height: 5.5vh;
}

.miniSearchBarWrapper select {
  margin-right: 5px;
}

.miniSearchBarWrapper button {
  margin: 0 10px;
}

.houseListWrapper {
  overflow-y: auto;
  border: 1px solid black;
  height: auto;
  max-height: 64.5vh;
  background-color: white;
  /* flex-direction: row; */
}

.houseListWrapper .card {
  display: flex;
  flex-direction: row;
}

.houseListWrapper .card-body {
  margin-left: 1rem;
}

.houseListBtnWrapper {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-right: 2rem !important;
}
</style>
