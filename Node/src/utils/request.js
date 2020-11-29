import axios from 'axios'
import queryString from 'qs'
// import store from '@/store'

const http = {
  url: '',
  method: '',
  param: '',
  query: '',
  dataType: 'json',
  request: null,
}

http.request = function(resolveFuc, rejectFuc) {

  if (!http.url) return;
  let param = {};
  let query = '';

  const method = http.method.toLowerCase();
  if (method === 'get') {
    query = queryString.stringify(http.param);
    param = {
      params: http.param,
      paramsSerializer: () => {
        return query;
      },
    };
  } else if (method === 'delete') {
    param = {
      data: http.param
    } 
  } else {
    param = http.param
  }
  const tempUrl = http.url.charAt(0) === '/' ? http.url : '/' + http.url
  const url = `${process.env.VUE_APP_BASE_API}${tempUrl}`;
  axios[method](url, param) 
    .then(_result => {
      if (typeof resolveFuc === 'function') {
        resolveFuc(_result);
      }
    })
    .catch(rejectFuc);
}

export default http;