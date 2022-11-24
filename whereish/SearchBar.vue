<template>
  <div>
    <div class="container">
      <div class="row g-2" style="max-height: 10vh">
        <div class="col-md-10">
          <div class="row g-2">
            <div class="col-md-4">
              <select
                class="form-select border-0 py-3"
                id="sidoSelectBar"
                v-model="sidoCode"
                @change="selectSido(sidoCode)"
                aria-label="시/도"
              >
                <option value="" seleted disabled hidden>시/도</option>
                <option v-for="(sido, idx) in sidoList" :key="idx" :value="sido.value">
                  {{ sido.text }}
                </option>
              </select>
            </div>

            <div class="col-md-4">
              <select
                class="form-select border-0 py-3"
                id="gugunSelectBar"
                v-model="gugunCode"
                @change="selectGugun(gugunCode)"
                required
              >
                <option value="" seleted disabled hidden>구/군</option>
                <option v-for="(gugun, idx) in gugunList" :key="idx" :value="gugun.value">
                  {{ gugun.text }}
                </option>
              </select>
            </div>

            <div class="col-md-4">
              <select class="form-select border-0 py-3" id="dongSelectBar" v-model="dongCode">
                <option value="" seleted disabled hidden>동</option>
                <option v-for="(dong, idx) in dongList" :key="idx" :value="dong.value">
                  {{ dong.text }}
                </option>
              </select>
            </div>

            <!-- <div v-for="(house, idx) in houseList" :key="idx">
            {{ house.aptName }}
        </div> -->
          </div>
        </div>
        <div class="col-md-2">
          <button class="btn btn-dark border-0 w-100 py-3" @click="searchHouse()">Search</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

const houseStore = "houseStore";

export default {
  data() {
    return {
      abd: "데이터",
      sidoCode: "",
      gugunCode: "",
      dongCode: "",
      searchCode: "",
    };
  },
  computed: {
    ...mapState(houseStore, ["sidoList", "gugunList", "dongList", "houseList"]),
  },
  methods: {
    ...mapActions(houseStore, ["getSido", "getGugun", "getDong", "getHouseList"]),
    selectSido(code) {
      this.gugunCode = "";
      this.dongCode = "";

      this.getGugun(code);
    },
    selectGugun(code) {
      this.dongCode = "";

      this.getDong(code);
    },
    searchHouse() {
      if (this.dongCode == "") {
        if (this.gugunCode == "") {
          this.searchCode = this.sidoCode;
        } else {
          this.searchCode = this.gugunCode;
        }
      } else {
        this.searchCode = this.dongCode;
      }

      console.log(this.searchCode);
      this.getHouseList(this.searchCode);
    },
    ...mapMutations(houseStore, ["CLEAR_HOUSE_LIST"]),
  },
  mounted() {
    this.CLEAR_HOUSE_LIST();
    this.getSido();
  },
  created() {},
};
</script>

<style></style>
