<template>
     <div class="modal" tabindex="-1" id="houseDealModal" style="top: 5%">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <h2 class="fw-bold" style="margin-bottom: 40px; text-align: center">{{houseName}}</h2>
                    <div class="form-outline" style="margin-bottom: 25px">
                        <div class="row">
                            <div class="col-3">
                                <div style="text-align: left; margin-top: 10%; margin-left: 10%"></div>
                            </div>
                           
                        </div>
                    </div>
                    <div>
                        <div>매매가격 추이</div>
                        <canvas id="myChart" height="400" width="400"></canvas>
                    </div>
                    <house-deal-list></house-deal-list>
        
                </div>
            </div>
        </div>
       
    </div>
</template>

<script>
import HouseDealList from "@/components/house/HouseDealList.vue"
//import HousePriceTrend from "@/components/house/HousePriceTrend.vue";
import { mapState } from "vuex";
import { Chart, BarElement, BarController, LinearScale, CategoryScale } from "chart.js";
Chart.register(BarElement,BarController,LinearScale,CategoryScale);
const houseStore="houseStore"
export default {
    props:["houseName"],
    components: {
        HouseDealList,
        //HousePriceTrend,
    },
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
        
        let $this = this;
        document.getElementById("houseDealModal").addEventListener("show.bs.modal", function () {
            if(window.priceChangeChart!=undefined){
                window.priceChangeChart.destroy();
            }
            
            $this.amountPerMonth=[0,0,0,0,0,0,0,0,0,0,0,0];
            $this.avgHousePrice=[0,0,0,0,0,0,0,0,0,0,0,0];
            $this.addHousePrice=[0,0,0,0,0,0,0,0,0,0,0,0];
            console.log($this.houseDealList);
            //avg
            for(let i=0;i<$this.houseDeallength;i++){
                $this.amountPerMonth[$this.houseDealList[i].dealMonth-1]++;
                $this.addHousePrice[$this.houseDealList[i].dealMonth-1]=
                $this.addHousePrice[$this.houseDealList[i].dealMonth-1]+$this.houseDealList[i].dealAmount;
            }
            for(let i=0;i<12;i++){
                if($this.amountPerMonth[i]==0){
                    $this.avgHousePrice[i]=0;
                    continue;
                }
                $this.avgHousePrice[i]=$this.addHousePrice[i]/$this.amountPerMonth[i];
            }
            //console.log($this.avgHousePrice)
            //filedata
          
            const ctx=document.getElementById("myChart").getContext("2d");
            window.priceChangeChart=new Chart(ctx,{
                type:'bar',
                data:{
                    labels:['1','2','3','4','5','6','7','8','9','10','11','12'],
                    datasets:[
                    {
                        data:$this.avgHousePrice,
                        borderColor:["#36498d","#36498d","#36498d",
                        "#36498d","#36498d","#36498d",
                        "#36498d","#36498d","#36498d",
                        "#36498d","#36498d","#36498d"],
                        backgroundColor: ["rgba(255,206,86,0.2)","rgba(255,206,86,0.2)","rgba(255,206,86,0.2)",
                        "rgba(255,206,86,0.2)","rgba(255,206,86,0.2)","rgba(255,206,86,0.2)",
                        "rgba(255,206,86,0.2)","rgba(255,206,86,0.2)","rgba(255,206,86,0.2)",
                        "rgba(255,206,86,0.2)","rgba(255,206,86,0.2)","rgba(255,206,86,0.2)"],
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
        

        });
    },

};

</script>
<style></style>
