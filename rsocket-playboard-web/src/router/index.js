import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    component: () => import('../views/Login.vue'),
    hidden: true
  },
  {
    path: '/login',
    component: () => import('../views/Login.vue'),
    hidden: true
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  scrollBehavior: () => ({ y: 0 }),
  routes
});

export default router
