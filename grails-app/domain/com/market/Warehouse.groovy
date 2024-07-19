package com.market

class Warehouse {

    Long id
    String code
    String name

    static hasMany = [products: WarehouseProduct]

    static constraints = {
        code unique: true, nullable: false, blank: false
        name nullable: false, blank: false
    }
}
