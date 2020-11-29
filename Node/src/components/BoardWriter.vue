<template>
  <v-form>
    <v-container>
      <v-row> 제목 </v-row>
      <v-row>
        <v-text-field
          :counter="50"
          label="제목"
          name="title"
          required
          v-model="board.title"
          maxlength="50"
        ></v-text-field>
      </v-row>
      <v-row> 내용 </v-row>
      <v-row>
        <v-textarea
          filled
          name="context"
          hint="내용을 입력해주세요."
          v-model="board.content"
          :counter="1000"
          maxlength="1000"
        ></v-textarea>
      </v-row>
      <v-row>
        <v-btn block outlined color="blue" @click="writeClick"> {{ type }} </v-btn>
        <v-btn block outlined color="orange" @click="listClick"> 목록 </v-btn>
      </v-row>
    </v-container>
  </v-form>
</template>
<script>
export default {
  name: 'BoardWriter',
  data() {
    return {
      board: {
        boardNo: '',
        title: '',
        content: '',
        password: '',
        createDt: '',
        createUserId: 'yeongjae',
      },
      type: '등록'
    };
  },
  created() {
    Object.assign(this.$data, this.$options.data());
    this.init();
  },
  beforeMount() {

  },
  mounted() {

  },
  methods: {
    init() {
      this.getDetail();
    },
    getDetail() {
      if (this.$route.params.seq) {
        this.$http.url = `/board/${this.$route.params.seq}`;
        this.$http.method = 'get';
        this.$http.request(response => {
          this.board = response.data;
          this.type = '수정';
        }, error => window.alert(error));
      }
    },
    writeClick() {
      if (this.$route.params.seq) {
        this.$http.url = '/board'
        this.$http.method = 'put'
      } else {
        this.$http.url = '/board';
        this.$http.method = 'post';
      }
      this.$http.param = this.board;
      this.$http.request(response => {
        const methodMsg = this.$http.method === 'post' ? '등록' : '수정'
        let msg = response.data > 0 ? `게시물 ${methodMsg}에 성공하였습니다.` : `게시물 ${methodMsg}에 실패하였습니다.`;
        window.alert(msg);
        if (response.data > 0) {
          this.$router.push('/');
        }
      }, error => window.alert(error));
    },
    listClick() {
      this.$router.push('/');
    },
    validate() {
      
    }
  },
};
</script>
