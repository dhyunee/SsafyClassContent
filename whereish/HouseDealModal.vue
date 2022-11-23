<template>
  <div class="modal" tabindex="-1" id="houseDealModal" style="top: 20%">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
            style="margin-right: 5px; margin-top: 5px"
          ></button>
        </div>
        <div class="modal-body">
          <div class="row houseInfoBox">
            <div class="col-6 houseNameBox">
              <div>{{ house.aptName }}</div>
            </div>
            <div class="col-1"></div>
            <div class="col-4 houseDetailBox">
              <div>주소 : {{ house.dong }} {{ house.jibun }}</div>
              <div>평균 매매가 : {{ (house.avgDealAmount * 10000).toLocaleString() }} 원</div>
              <div>평균 면적 : {{ house.avgArea }} ㎡</div>
              <div>건축 연도 : {{ house.buildYear }} 년</div>
            </div>
          </div>

          <div class="form-outline" style="margin-bottom: 25px">
            <div class="row">
              <div class="col-3">
                <div style="text-align: left; margin-top: 10%; margin-left: 10%"></div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col">
              <house-price-trend></house-price-trend>
            </div>
            <div class="col">
              <div class="houseDealListDiv">
                <house-deal-list></house-deal-list>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import HouseDealList from "@/components/house/HouseDealList.vue";
import HousePriceTrend from "@/components/house/HousePriceTrend.vue";
import { mapMutations, mapState } from "vuex";
// import { Chart, BarElement, BarController, LinearScale, CategoryScale } from "chart.js";
// Chart.register(BarElement, BarController, LinearScale, CategoryScale);
const houseStore = "houseStore";
export default {
  components: {
    HouseDealList,
    HousePriceTrend,
  },
  computed: {
    ...mapState(houseStore, ["houseDealList", "houseDeallength", "house"]),
  },
  data() {
    return {
      priceChangeChart: null,
      amountPerMonth: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      avgHousePrice: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      addHousePrice: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      houseName: "",
    };
  },
  methods: {
    ...mapMutations(houseStore, ["CLEAR_HOUSE_DEAL_LIST"]),
  },
  mounted() {
    let $this = this;
    document.getElementById("houseDealModal").addEventListener("show.bs.modal", function () {});

    document.getElementById("houseDealModal").addEventListener("hide.bs.modal", function () {
      $this.CLEAR_HOUSE_DEAL_LIST();
    });
  },
};
</script>
<style>
#houseDealModal {
  max-height: 70vh;
}

#houseDealModal .modal-content {
  min-height: 609px;
}

.modal-body > .houseInfoBox {
  align-items: center !important;
  margin-left: 4rem !important;
  margin-top: 1rem !important;
}

.houseNameBox div {
  font-size: 2rem !important;
  text-align: center;
  font-weight: bold;
}

.houseDetailBox div {
  position: relative;
  /* left: 10vw; */
  /* align-items: center !important; */
}
</style>
