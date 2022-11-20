<template>
    <div class="container">
        <h4>BoardDetail</h4>
        <div class="mb-3">
            <label class="form-label">제목</label>
            <input type="email" class="form-control-plaintext" :value="selectedBoard.boardTitle" />
        </div>
        <div class="mb-3">
            <label class="form-label">내용</label>
            <div v-html="selectedBoard.boardContent"></div>
        </div>
        <button v-if="isAuthor" class="btn btn-sm btn-primary btn-outline" @click="$router.push({ name: 'BoardUpdateForm' })">글 수정하기</button>
    </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
    props: ["id"],
    data() {
        return {};
    },
    methods: {
        ...mapActions(["getBoard"]),
        moveBoardUpdateForm() {},
    },
    computed: {
        ...mapState(["isAuthor", "selectedBoard"]),
    },
    mounted() {
        this.getBoard(this.id);
    },
};
</script>

<style></style>
