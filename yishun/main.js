import Vue from 'vue'
import App from './App'

// 接收api.js下的myRequst方法
import { myRequest } from './components/my-request/api.js'
// 挂载到全局，让所有的页面都能调用myRequest方法
Vue.prototype.$myRequest = myRequest


Vue.config.productionTip = false

App.mpType = 'app'

const app = new Vue({
    ...App
})
app.$mount()
