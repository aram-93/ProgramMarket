package com.market

class ShopController {

    static scaffold = Shop

    ShopService shopService

    def index() {
        respond Shop.list()
    }

    def create() {
        respond new Shop(params)
    }

    def save(Shop shop) {
        shop.save(flush: true)
        redirect action: "index"
    }

    def show(Long id) {
        respond Shop.get(id)
    }

    def sellProduct(Long shopId, Long productId, Integer quantity) {
        shopService.sellProduct(shopId, productId, quantity)
        redirect action: "show", id: shopId
    }

    def returnProduct(Long shopId, Long warehouseId, Long productId, Integer quantity) {
        shopService.returnProductToWarehouse(shopId, warehouseId, productId, quantity)
        redirect action: "show", id: shopId
    }

    def checkExpired(Long shopId) {
        shopService.checkExpiredProductsAndReturnToWarehouse(shopId)
        redirect action: "show", id: shopId
    }
}
