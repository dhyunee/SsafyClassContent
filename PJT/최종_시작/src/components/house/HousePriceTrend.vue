<template>
    <div>
        <div  @call-parent-price-change="pushHousePrice">매매가격 추이</div>
        <canvas id="myChart" height="200"></canvas>
    </div>

</template>

<script>
import { mapState } from "vuex";
import { Chart, BarElement, BarController, LinearScale, CategoryScale } from "chart.js";
Chart.register(BarElement,BarController,LinearScale,CategoryScale);
const houseStore="houseStore"
export default {
    computed:{
        ...mapState(houseStore,["houseDealList","houseDeallength"]),
    },

    data(){
        return{
            priceChangeChart:null,
            amountPerMonth:[0,0,0,0,0,0,0,0,0,0,0,0],
            avgHousePrice:[0,0,0,0,0,0,0,0,0,0,0,0],
            addHousePrice:[0,0,0,0,0,0,0,0,0,0,0,0],
        }
    },
    mounted(){
        
        this.pushHousePrice();
        console.log(this.houseDeallength);
        
    },
    methods:{
        pushHousePrice(){
            for(let i=0;i<this.houseDeallength;i++){
                this.amountPerMonth[this.houseDealList[i].dealMonth-1]++;
                this.addHousePrice[this.houseDealList[i].dealMonth-1]+=this.houseDealList[i].dealAmount;
            }
            for(let i=0;i<12;i++){
                if(this.amountPerMonth[i]==0)continue;
                this.avgHousePrice[i]=this.addHousePrice[i]/this.amountPerMonth[i];
            }
            this.fileData();
        },
        fileData(){
            const ctx=document.getElementById("myChart").getContext("2d");
            this.priceChangeChart=new Chart(ctx,{
                type:'bar',
                data:{
                    labels:[1,2,3,4,5,6,7,8,9,10,11,12],
                    datasets:[
                    {
                        data:this.avgHousePrice[0],
                        borderColor:"rgba(255,206,86,0.2)",
                        backgroundColor: "rgba(255,206,86,0.2)",
                    },
                    {
                        data: this.avgHousePrice[1],
                        borderColor: "rgba(255,206,86,0.2)",
                        backgroundColor: "rgba(255,206,86,0.2)",
                    },
                    {
                        data:this.avgHousePrice[2],
                        borderColor:"rgba(255,206,86,0.2)",
                        backgroundColor: "rgba(255,206,86,0.2)",
                    },
                    {
                        data:this.avgHousePrice[3],
                        borderColor:"rgba(255,206,86,0.2)",
                        backgroundColor: "rgba(255,206,86,0.2)",
                    },
                    {
                        data:this.avgHousePrice[4],
                        borderColor:"rgba(255,206,86,0.2)",
                        backgroundColor: "rgba(255,206,86,0.2)",
                    },
                    {
                        data:this.avgHousePrice[5],
                        borderColor:"rgba(255,206,86,0.2)",
                        backgroundColor: "rgba(255,206,86,0.2)",
                    },
                    {
                        data:this.avgHousePrice[6],
                        borderColor:"rgba(255,206,86,0.2)",
                        backgroundColor: "rgba(255,206,86,0.2)",
                    },
                    {
                        data:this.avgHousePrice[7],
                        borderColor:"rgba(255,206,86,0.2)",
                        backgroundColor: "rgba(255,206,86,0.2)",
                    },
                    {
                        data:this.avgHousePrice[8],
                        borderColor:"rgba(255,206,86,0.2)",
                        backgroundColor: "rgba(255,206,86,0.2)",
                    },
                    {
                        data:this.avgHousePrice[9],
                        borderColor:"rgba(255,206,86,0.2)",
                        backgroundColor: "rgba(255,206,86,0.2)",
                    },
                    {
                        data:this.avgHousePrice[10],
                        borderColor:"rgba(255,206,86,0.2)",
                        backgroundColor: "rgba(255,206,86,0.2)",
                    },
                    {
                        data:this.avgHousePrice[11],
                        borderColor:"rgba(255,206,86,0.2)",
                        backgroundColor: "rgba(255,206,86,0.2)",
                    },
                ],     
            },
            options:{
                scales:{
                    y:{
                        beginAtZero:true,
                        }
                    }
                }
            })
        }
    }

};
</script>

<style></style>
