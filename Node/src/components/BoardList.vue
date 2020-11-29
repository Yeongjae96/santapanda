<template>
  <v-container>
    <v-data-table
      :headers="dataTable.headers"
      :items="dataTable.data"
      :items-per-page="5"
      loading
       loading-text="Loading... Please wait"
      class="elevation-1"
      @click:row="rowClick"
    >
    </v-data-table>
    <v-row>
      <v-btn outlined="outlined" color="blue" @click="writeClick">
        작성
      </v-btn>
    </v-row>
  </v-container>
</template>
<script>
export default {
  name: 'BoardList',
  data() {
    return {
      dataTable: {
        headers: [
          {
            text: '게시판 번호',
            value: 'boardNo',
            align: 'start',
            sortable: false,
          },
          {
            text: '제목',
            align: 'center',
            value: 'title',
          },
          {
            text: '등록일',
            align: 'end',
            value: 'createDt',
          },
        ],
        data: [],
      },
    };
  },
  created() {
    this.fetch();
  },
  beforeMount() {},
  mounted() {},
  methods: {
    fetch() {
      this.$http.url='/board';
      this.$http.method='get';
      this.$http.request(response => {
        if (response.data && response.data.length) {
          this.dataTable.data = response.data;
        }
      }, error => window.alert(error));
    },
    writeClick() {
      this.$router.push('/writer');
    },
    rowClick(item) {
      this.$router.push('/view/' + item.boardNo);
    },
  },
};
</script>
