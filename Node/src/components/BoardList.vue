<template>
  <v-container>
    <v-data-table
      :headers="dataTable.headers"
      :items="dataTable.data"
      :items-per-page="5"
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
import axios from 'axios';
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
      console.log('fetch list');
      axios
        .get('http://localhost:8000/api/board')
        .then(response => {
          if (response.data && response.data.length) {
            this.dataTable.data = response.data;
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    writeClick() {
      this.$router.push('/writer');
    },
    rowClick(item) {
      this.$router.push('/view/' + item.seq);
    },
  },
};
</script>
