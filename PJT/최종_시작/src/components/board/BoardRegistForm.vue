<template>
    <div class="container" id="boardRegistForm">
        <h4>BoardRegisterForm</h4>
        <div class="mb-3">
            <label for="boardTitleInput" class="form-label">제목</label>
            <input type="email" class="form-control" id="boardTitleInput" v-model="title" placeholder="제목을 입력해주세요." />
        </div>
        <div class="mb-3">
            <label for="boardTitleInput" class="form-label">내용</label>
            <div id="boardContentArea"></div>
        </div>
        <div v-if="$store.state.userInfo != null && $store.state.userInfo.userClsf != 1">
            <div class="form-check mb-3">
                <input v-model="isShowAddress" class="form-check-input" type="checkbox" value="" id="chkIsShowAddress" />
                <label class="form-check-label" for="chkIsShowAddress">지역글</label>
            </div>
            <div class="mb-3" v-show="isShowAddress" id="boardAddressWrapper">
                <div class="col-9">
                    <label for="sidoSelectBar">시/도</label>
                    <select id="sidoSelectBar" v-model="sido" @change="selectSido(sido)">
                        <option value="" seleted disabled hidden>선택해주세요.</option>
                        <option v-for="(sido, idx) in sidoList" :key="idx" :value="sido">
                            {{ sido.text }}
                        </option>
                    </select>
                    <label for="gugunSelectBar">구/군</label>
                    <select id="gugunSelectBar" v-model="gugun" @change="selectGugun(gugun)">
                        <option value="" seleted disabled hidden>선택해주세요.</option>
                        <option v-for="(gugun, idx) in gugunList" :key="idx" :value="gugun">
                            {{ gugun.text }}
                        </option>
                    </select>
                    <label for="dongSelectBar">동</label>
                    <select id="dongSelectBar" v-model="dong">
                        <option value="" seleted disabled hidden>선택해주세요.</option>
                        <option v-for="(dong, idx) in dongList" :key="idx" :value="dong">
                            {{ dong.text }}
                        </option>
                    </select>
                </div>
            </div>
        </div>
        <button @click="boardInsert" class="btn btn-sm btn-primary btn-outline">작성하기</button>
    </div>
</template>

<script>
import Vue from "vue";
import CKEditor from "@ckeditor/ckeditor5-vue2";
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import { mapState, mapActions } from "vuex";
import http from "@/common/axios.js";

Vue.use(CKEditor);

const houseStore = "houseStore";

export default {
    data() {
        return {
            title: "",
            CKEditor: "",
            isShowAddress: false,

            sido: "",
            gugun: "",
            dong: "",
        };
    },
    methods: {
        ...mapActions(houseStore, ["getSido", "getGugun", "getDong"]),
        selectSido(sido) {
            this.gugun = "";
            this.dong = "";

            this.getGugun(sido.value);
        },
        selectGugun(gugun) {
            this.dong = "";

            this.getDong(gugun.value);
        },
        boardInsert() {
            http.post("/boards", {
                boardTitle: this.title,
                boardContent: this.CKEditor.getData(),
                userSeq: this.$store.state.userInfo.userSeq,
                showAddress: this.isShowAddress,
                sidoCode: this.isShowAddress ? this.sido.value : null,
                sidoName: this.isShowAddress ? this.sido.text : null,
                gugunCode: this.isShowAddress ? this.gugun.value : null,
                gugunName: this.isShowAddress ? this.gugun.text : null,
                dongCode: this.isShowAddress ? this.dong.value : null,
                dongName: this.isShowAddress ? this.dong.text : null,
            })
                .then((res) => {
                    console.log(res);
                    console.log("작성완료");
                    this.$router.push({ name: "BoardPage" });
                })
                .catch((err) => console.log(err));
        },
    },
    computed: {
        ...mapState(houseStore, ["sidoList", "gugunList", "dongList"]),
    },
    async mounted() {
        try {
            this.CKEditor = await ClassicEditor.create(document.querySelector("#boardContentArea"));
        } catch (error) {
            console.error(error);
        }

        this.getSido();
    },
};
</script>

<style scoped>
#boardRegistForm >>> .ck-editor__editable {
    min-height: 300px !important;
}
</style>
