package com.market

class WarehouseProduct {

    Product product
    Integer quantity

    static belongsTo = [warehouse: Warehouse]

    static constraints = {
        product nullable: false
        quantity nullable: false, min: 0
    }
}
