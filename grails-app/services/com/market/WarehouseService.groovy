package com.market

import grails.gorm.transactions.Transactional

@Transactional
class WarehouseService {

    def addProductToWarehouse(Long warehouseId, Long productId, Integer quantity) {
        def warehouse = Warehouse.get(warehouseId)
        def product = Product.get(productId)
        if (warehouse && product) {
            def warehouseProduct = WarehouseProduct.findByWarehouseAndProduct(warehouse, product) ?: new WarehouseProduct(warehouse: warehouse, product: product)
            warehouseProduct.quantity = quantity
            warehouseProduct.save(flush: true)
        }
    }

    def removeProductFromWarehouse(Long warehouseId, Long productId) {
        def warehouse = Warehouse.get(warehouseId)
        def product = Product.get(productId)
        if (warehouse && product) {
            def warehouseProduct = WarehouseProduct.findByWarehouseAndProduct(warehouse, product)
            if (warehouseProduct) {
                warehouseProduct.delete(flush: true)
            }
        }
    }

    def shipProductToShop(Long warehouseId, Long shopId, Long productId, Integer quantity) {
        def warehouse = Warehouse.get(warehouseId)
        def shop = Shop.get(shopId)
        def product = Product.get(productId)
        if (warehouse && shop && product) {
            def warehouseProduct = WarehouseProduct.findByWarehouseAndProduct(warehouse, product)
            if (warehouseProduct && warehouseProduct.quantity >= quantity) {
                warehouseProduct.quantity -= quantity
                if (warehouseProduct.quantity == 0) {
                    warehouseProduct.delete(flush: true)
                } else {
                    warehouseProduct.save(flush: true)
                }

                def shopProduct = ShopProduct.findByShopAndProduct(shop, product) ?: new ShopProduct(shop: shop, product: product)
                shopProduct.quantity += quantity
                shopProduct.save(flush: true)
            }
        }
    }
}
