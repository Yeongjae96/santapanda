import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import router from './router'
import lodash from 'lodash' // A modern JavaScript utility library delivering modularity, performance & extras
import moment from 'moment';
import httpRequest from './utils/request'
import '@babel/polyfill'
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'

Vue.config.productionTip = false

/** global variable in Vue app **/
Vue.prototype.$_ = lodash;
Vue.prototype.moment = moment;
Vue.prototype.$http = httpRequest;

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app');