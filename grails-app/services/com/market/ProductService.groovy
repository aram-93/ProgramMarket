package com.market

import grails.gorm.transactions.Transactional

@Transactional
class ProductService {

    def saveProduct(Product product) {
        product.save(flush: false)
    }

    def editProduct(Long id, String code, String name, BigDecimal price, Date productionDate, Date expirationDate) {
        def product = Product.get(id)
        if (product) {
            product.code = code
            product.name = name
            product.price = price
            product.productionDate = productionDate
            product.expirationDate = expirationDate
            product.save(flush: true)
        }
        product
    }

    def removeProduct(Long id) {
        def product = Product.get(id)
        if (product) {
            product.delete(flush: true)
        }
    }
}
