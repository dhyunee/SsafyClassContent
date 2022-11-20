<template>
    <div>
    <div>거래내역</div>

<div class="container">
    <table class="table table-hover bg-white">
        <thead>
            <tr>
                <th scope="col">거래가격(만원)</th>
                <th scope="col">거래년도</th>
                <th scope="col">거래월</th>
                <th scope="col">거래일</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(deal, idx) in houseDealList" :key="idx">
                <td>{{ deal.dealAmount }}</td>
                <td>{{ deal.dealYear }}</td>
                <td>{{ deal.dealMonth }}</td>
                <td>{{deal.dealDay}}</td>
            </tr>
        </tbody>
    </table>
</div>
</div>
</template>
<script>
import { mapState }from "vuex";
const houseStore = "houseStore";
export default {
    computed:{
        ...mapState(houseStore,["houseDealList"]),
    }
};
</script>

<style></style>
