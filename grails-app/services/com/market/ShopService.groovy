package com.market

import grails.gorm.transactions.Transactional

@Transactional
class ShopService {

    def sellProduct(Long shopId, Long productId, Integer quantity) {
        def shop = Shop.get(shopId)
        def product = Product.get(productId)
        if (shop && product) {
            def shopProduct = ShopProduct.findByShopAndProduct(shop, product)
            if (shopProduct && shopProduct.quantity >= quantity) {
                shopProduct.quantity -= quantity
                if (shopProduct.quantity == 0) {
                    shopProduct.delete(flush: true)
                } else {
                    shopProduct.save(flush: true)
                }
            }
        }
    }

    def returnProductToWarehouse(Long shopId, Long warehouseId, Long productId, Integer quantity) {
        def shop = Shop.get(shopId)
        def warehouse = Warehouse.get(warehouseId)
        def product = Product.get(productId)
        if (shop && warehouse && product) {
            def shopProduct = ShopProduct.findByShopAndProduct(shop, product)
            if (shopProduct && shopProduct.quantity >= quantity) {
                shopProduct.quantity -= quantity
                if (shopProduct.quantity == 0) {
                    shopProduct.delete(flush: true)
                } else {
                    shopProduct.save(flush: true)
                }

                def warehouseProduct = WarehouseProduct.findByWarehouseAndProduct(warehouse, product) ?: new WarehouseProduct(warehouse: warehouse, product: product)
                warehouseProduct.quantity += quantity
                warehouseProduct.save(flush: true)
            }
        }
    }

    def checkExpiredProductsAndReturnToWarehouse(Long shopId) {
        def shop = Shop.get(shopId)
        if (shop) {
            def today = new Date()
            shop.products.each { shopProduct ->
                if (shopProduct.product.expirationDate && shopProduct.product.expirationDate.before(today)) {
                    returnProductToWarehouse(shop.id, shopProduct.product.id, shopProduct.quantity)
                }
            }
        }
    }
}
