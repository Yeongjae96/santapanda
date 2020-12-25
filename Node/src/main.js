import Vue from 'vue'
import App from './App.vue'

import vuetify from './plugins/vuetify'

import router from './router'
import lodash from 'lodash' // A modern JavaScript utility library delivering modularity, performance & extras

import { ValidationObserver, ValidationProvider, extend } from 'vee-validate';
import { required, email, min, max, digits, regex } from 'vee-validate/dist/rules'
import moment from 'moment';
import httpRequest from './utils/http'
import '@babel/polyfill'
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'

Vue.config.productionTip = false

/** global variable in Vue app **/
Vue.prototype.$_ = lodash;
Vue.prototype.moment = moment;
Vue.prototype.$http = httpRequest;

Vue.component('validation-observer', ValidationObserver);
Vue.component('validation-provider', ValidationProvider);

extend('email',email);
extend('digits', digits)
extend('required',required)
extend('min',min)
extend('max',max);
extend('regex',regex);

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app');