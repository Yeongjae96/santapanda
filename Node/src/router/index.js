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
      path: '',
      name: 'app-main',
      component: () => import('@/components/appMain')
    },
    {
      path: '/user/sign-up',
      name: 'signUp',
      component: () => import('@/components/login/signUp')
    },
    {
      path: '/board',
      name: 'BoardList',
      component: BoardList
    },
    {
      path: '/board/:seq',
      name: 'BoardView',
      component: BoardView
    },
    {
      path: '/board/write',
      name: 'BoardWriter',
      component: BoardWriter
    }
  ]
})
  