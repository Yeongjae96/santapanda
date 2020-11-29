<template>
  <v-form>
    <v-container>
      <v-row> 제목 </v-row>
      <v-row> {{ board.title }} </v-row>
      <v-row> 내용 </v-row>
      <v-row> {{ board.content }} </v-row>
      <v-row>
        <v-btn block outlined color="blue" @click="listClick"> 목록 </v-btn>
        <v-btn block outlined color="oragne" :to="updateRouter"> 수정 </v-btn>
        <v-btn block outlined color="red" @click="deleteClick"> 삭제 </v-btn>
      </v-row>
    </v-container>
  </v-form>
</template>
<script>
export default {
  name: 'BoardView',
  data() {
    return { 
      board: {
        boardNo: '',
        title: '',
        password: '',
        content: '',
        createUserId: '',
        createDt: '',
        updateUserId: '',
        updateDt: '',
      },
      updateRouter: {
        name: '',
        params: null,
      },
    };
  },
  beforeMount() {
  },
  created() {
    this.init();
  },
  methods: {
    init() {
      this.getDetail()
          .then(() => {
            this.updateRouter.name = `BoardWriter`;
            this.updateRouter.params = {
              seq: this.board.boardNo
            };
          });
    },
    getDetail() {
      return new Promise((resolve, reject) => {
        this.$http.url = `/board/${this.$route.params.seq}`
        this.$http.method = 'get'
        this.$http.request(_response => {
          this.board = _response.data;
          resolve(true);
        }, _error => {
          window.alert(_error);
          reject(_error);
        });
      });
    },
    listClick() {
      this.$router.push('/');
    },
    deleteClick() {
      const input = window.confirm(`${this.board.boardNo}번 ${this.board.title} 게시물을 삭제하시겠습니까?`);
      if (input) {
        this.$http.url = `/board/${this.$route.params.seq}`;
        this.$http.method = 'delete';
        this.$http.request(() => {
          window.alert('삭제를 성공하였습니다.');
          this.$route.push('/');
        }, error => window.alert(error));
      }
    }
  },
}
</script>