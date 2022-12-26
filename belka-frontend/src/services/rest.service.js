import api from './api'

class RestService {
    getOrders(month, year) {
        return api.get(`/api/orders/{year}/{month}`)
    }

    postOrders(orders) {
        return api.post('api/orders', orders)
    }

    getReports(month, year) {
        return api.get(`/api/orders/{year}/{month}`)
    }
}

export default new RestService()
