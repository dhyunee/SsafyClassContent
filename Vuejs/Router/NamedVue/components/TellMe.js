export default {
  template: `
    <div class="mt-3">
      <div id="editor"></div>
      <button type="button" class="btn btn-primary mt-2" @click="sendTellMe"> Send</button>
    </div>
  `,
  data: function () {
    return {
      CKEditor: null,
    };
  },
  methods: {
    sendTellMe: function () {
      let message = this.CKEditor.getData();
      alert(message);
    },
  },
  async mounted() {
    this.CKEditor = await ClassicEditor.create(document.querySelector("#editor"));
  },
};
