<template>
    <div class="container">
        <h4>BoardList</h4>
        <router-link to="regist">글쓰기</router-link>
        <table class="table table-hover bg-white">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(board, idx) in boardList" :key="idx">
                    <th scope="row">{{ board.boardId }}</th>
                    <td>
                        <a class="custom-text" href="" @click.prevent="$router.push('/BoardPage/' + board.boardId)">{{ board.boardTitle }}</a>
                    </td>
                    <td>{{ board.boardId }}</td>
                    <td>{{ board.fDate }}</td>
                </tr>
            </tbody>
        </table>
        <pagination-ui></pagination-ui>
    </div>
</template>

<script>
import PaginationUi from "@/components/common/PaginationUI.vue";
import http from "@/common/axios.js";

export default {
    components: { PaginationUi },
    data() {
        return {
            boardList: [],
        };
    },
    methods: {},
    computed: {
        formatDate() {
            this.boardList.forEach((el) => {
                el.fDate = ("" + el.boardRegisterDate.date.year).slice(-2) + "/" + ("00" + el.boardRegisterDate.date.month).slice(-2) + "/" + ("00" + el.boardRegisterDate.date.day).slice(-2);
            });

            return this.boardList;
        },
    },
    mounted() {
        http.get("/boards").then(({ data }) => {
            this.boardList = data.data;
            this.boardList = this.formatDate;
        });
    },
};
</script>

<style></style>
