package com.market

class ShopProduct {

    Product product
    Integer quantity

    static belongsTo = [shop: Shop]

    static constraints = {
        product nullable: false
        quantity nullable: false, min: 0
    }
}
