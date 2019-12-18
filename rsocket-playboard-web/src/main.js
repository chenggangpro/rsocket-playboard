import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify';
import rsocket from './plugins/rsocket';
Vue.config.productionTip = false;

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app');

rsocket().then((socket)=>{
  socket.requestResponse({
        data: {
          "aaa": 123
        },
        metadata: {
            route: "echo"
        }
      })
      .subscribe({
        onComplete: data => {
          console.log("got response with requestResponse");
          console.log(data)
        },
        onError: error => {
          console.log("got error with requestResponse");
          console.error(error);
        },
        onSubscribe: cancel => {
          console.log(cancel)
          /* call cancel() to stop onComplete/onError */
        }
      });
}).catch(err=>{
  console.error(err)
});