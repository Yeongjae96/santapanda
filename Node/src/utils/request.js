import axios from 'axios';
import store from '@/store';
import router from '@/router';

import common from '../js/common';

import {
  getAccessToken,
  getNewToken,
  setAccessToken,
  setRefreshToken,
  getAccessExpiredCode,
  getRefreshExpiredCode,
  getWrongPasswordCode,
  getConcurrentExpiredCode,
  getRefreshToken,
  getToken
} from './auth';


const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API,
  timeout: 5000,
  withCredentials: true,
  // 다른 Origin으로부터 쿠키 전달
})

service.interceptors.request.use(
  config => {
    if (store.getters.token) {
      config.headers['x-token'] = getToken();
      config.headers['X-Authorization'] = `${getAccessToken()}`;
    }
    return config;
  },
  error => {
    Promise.reject(error);
  }
);

service.interceptors.response.use(
  function (response) {
    return response;
  },
  function (error) {
    const status = error.response ? error.response.status : null;
    const returnCode = error.response ? error.response.data.returnCode : null;
    
    if (status === 401) {
      if (returnCode === getAccessExpiredCode())
    }
  }


)