package com.market


class Product {
    Long id;
    String code
    String name
    BigDecimal price
    Date productionDate
    Date expirationDate

    static mapping = {
        id generator: 'identity'
    }

    static constraints = {
        code unique: true, nullable: false, blank: false
        name nullable: false, blank: false
        price nullable: false, min: 0.0
        productionDate nullable: false
        expirationDate nullable: true
    }
}
