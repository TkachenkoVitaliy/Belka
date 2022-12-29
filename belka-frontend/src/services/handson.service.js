class HandsonService {
    mapOrderToArray(order) {
        return [
            order.id,
            order.year,
            order.month,
            order.name,
            order.ferrum,
            order.silicium,
            order.aluminium,
            order.calcium,
            order.sulfur,
        ]
    }

    mapArrayToOrder(array, month, year) {
        return {
            id: array[0],
            year: array[1] || year,
            month: array[2] || month,
            name: array[3],
            ferrum: array[4],
            silicium: array[5],
            aluminium: array[6],
            calcium: array[7],
            sulfur: array[8],
        }
    }

    mapOrdersToTable(data) {
        return data.map((element) => this.mapOrderToArray(element))
    }

    mapTableToOrders(data, month, year) {
        return data.map((element) => this.mapArrayToOrder(element, month, year))
    }

    getEmptyRow() {
        return [null, null, null, '', null, null, null, null, null]
    }
}

export default new HandsonService()
