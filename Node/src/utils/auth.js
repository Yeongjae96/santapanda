import Cookies from 'js-cookie';
import axios from 'axios';

const tokenKey = 'jwtToken';
const refreshTokenKey = 'refreshToken';
const accessTokenKey = 'accessToken';

const accessExpiredCode = 'ACCESS_EXPIRED';
const refreshExpiredCode = 'REFRESH_EXPIRED';
const wrongPasswordCode = 'WRONG_PASSWORD';
const concurrentExpiredCode = 'CONCURRENT_EXPIRED';

const auth = {
  getToken,
  setToken,
  removeToken,
  getAccessToken,
  setAccessToken,
  removeAccessToken,
  getNewToken,
  getRefreshToken,
  setRefreshToken,
  removeRefreshToken,
  getTodayClose,
  getAccessExpiredCode,
  getRefreshExpiredCode,
  getWrongPasswordCode,
  getConcurrentExpiredCode,
  haveRoute
};

function getToken() {
  return Cookies.get(tokenKey);
}

function setToken(token) {
  return Cookies.set(tokenKey, token);
}

function removeToken() {
  return Cookies.remove(tokenKey);
}

function getAccessToken() {
  return Cookies.get(accessTokenKey);
}

function setAccessToken(accessToken) {
  return Cookies.set(accessTokenKey, 'Bearer ' + accessToken);
}

function removeAccessToken() {
  return Cookies.remove(accessTokenKey);
}

function getRefreshToken() {
  return Cookies.get(refreshTokenKey);
}

function setRefreshToken() {
  return Cookies.set(refreshTokenKey, 'Bearer ' + refreshTokenKey);
}

function removeRefreshToken() {
  return Cookies.remove(refreshTokenKey);
}

function getTodayClose() {
  return Cookies.set('todayClose');
}

function getNewToken() {
  let refToken = getRefreshToken();

  const service = axios.create({
    baseURL: process.env.VUE_APP_BASE_API,
    timeout: 5000,
  });

  const validRefreshCall = service.get(
    '/api/auth/refresh', {
      header: {
        // 요청 헤더
        'X-Authorization': refToken,
      }
    })
    .then(response => {
      let data = response.data;
      setAccessToken(data.accessToken);
      setRefreshToken(data.refreshToken);
      return Promise.resolve(true);
    })
    .catch(error => {
      return Promise.reject(error);
    })
  
  return validRefreshCall;
}

function getAccessExpiredCode() {
  return accessExpiredCode;
}

function getRefreshExpiredCode() {
  return refreshExpiredCode;
}

function getWrongPasswordCode() {
  return wrongPasswordCode;
}

function getConcurrentExpiredCode() {
  return concurrentExpiredCode;
}

function haveRoute(routers, pathId) {
  let returnVal = false;
  let rLength = routers.length;
  if (routers && rLength > 0) {
    for (let i = 0; i < rLength; i++) {
      if (routers[i].children) {
        returnVal = haveRoute(routers[i].children, pathId);
        if (returnVal) {
          return true;
        } else {
          if (routers[i].name === pathId) {
            return true;
          } else {
            returnVal = false;
          }
        }
      } else {
        if (routers[i].name === pathId) {
          return true;
        } else {
          returnVal = false;
        }
      }
    }
  }
  return returnVal;
}



export default auth;