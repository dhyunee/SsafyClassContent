<template>
  <div
    class="modal fade"
    id="insertModal"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">회원 가입</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <div class="mb-3">
            <label for="titleInsert" class="form-label">아이디</label>
            <input type="text" class="form-control" id="titleInsert" v-model="title" />
          </div>
          <div class="mb-3">
            <label for="titleInsert" class="form-label">비밀번호</label>
            <input type="password" class="form-control" id="titleInsert" v-model="title" />
          </div>
          <div class="mb-3">
            <label for="titleInsert" class="form-label">아이디</label>
            <input type="text" class="form-control" id="titleInsert" v-model="title" />
          </div>
          <div class="mb-3">
            <label for="titleInsert" class="form-label">이메일</label>
            <input type="text" class="form-control" id="titleInsert" v-model="title" />
          </div>

          <button
            @click="boardInsert"
            id="btnBoardInsert"
            type="button"
            class="btn btn-sm btn-primary float-end"
          >
            등록
          </button>
        </div>
      </div>
    </div>
  </div>
</template>
