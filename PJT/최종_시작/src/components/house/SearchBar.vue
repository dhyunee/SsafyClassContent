<template>
    <div>
        <h4>SearchBar {{ abd }}</h4>
        <label for="sidoSelectBar">시/도</label>
        <select id="sidoSelectBar" v-model="sidoCode" @change="selectSido(sidoCode)">
            <option value="" seleted disabled hidden>선택해주세요.</option>
            <option v-for="(sido, idx) in sidoList" :key="idx" :value="sido.value">
                {{ sido.text }}
            </option>
        </select>
        <label for="gugunSelectBar">구/군</label>
        <select id="gugunSelectBar" v-model="gugunCode" @change="selectGugun(gugunCode)">
            <option value="" seleted disabled hidden>선택해주세요.</option>
            <option v-for="(gugun, idx) in gugunList" :key="idx" :value="gugun.value">
                {{ gugun.text }}
            </option>
        </select>
        <label for="dongSelectBar">동</label>
        <select id="dongSelectBar" v-model="dongCode">
            <option value="" seleted disabled hidden>선택해주세요.</option>
            <option v-for="(dong, idx) in dongList" :key="idx" :value="dong.value">
                {{ dong.text }}
            </option>
        </select>
        <button @click="selectDong(dongCode)">검색</button>

        <div v-for="(house, idx) in houseList" :key="idx">
            {{ house.aptName }}
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
        selectDong(code) {
            this.getHouseList(code);
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
