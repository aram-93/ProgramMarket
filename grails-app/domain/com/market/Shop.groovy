package com.market

class Shop {

    Long id
    String password
    String name
    String address

    static hasMany = [products: ShopProduct]

    static constraints = {
        password nullable: false, blank: false
        name nullable: false, blank: false
        address nullable: false, blank: false
    }
}
