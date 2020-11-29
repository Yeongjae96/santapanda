import Vue from 'vue' 
import Router from 'vue-router'
// import { list } from '@/js/menu'
import BoardList from '@/components/BoardList' 
import BoardView from '@/components/BoardView'
import BoardWriter from '@/components/BoardWriter'

Vue.use(Router) 

export default new Router({
  mode: 'history',
  // routes: menu,
  routes: [
    {
      path: '/',
      name: 'BoardList',
      component: BoardList
    },
    {
      path: '/view/:seq',
      name: 'BoardView',
      component: BoardView
    },
    {
      path: '/writer',
      name: 'BoardWriter',
      component: BoardWriter
    }
  ]
})
  