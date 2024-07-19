package com.market

class UrlMappings {

    static mappings = {

        // Root URL redirects to the Product index page
        "/"(controller: 'product', action: 'index')

        // Product Controller mappings
        "/products"(controller: 'product', action: 'index')
        "/products/create"(controller: 'product', action: 'create')
        "/products/save"(controller: 'product', action: 'save')
        "/products/edit/$id"(controller: 'product', action: 'edit')
        "/products/update/$id"(controller: 'product', action: 'update')
        "/products/delete/$id"(controller: 'product', action: 'delete')

        // Warehouse Controller mappings
        "/warehouses"(controller: 'warehouse', action: 'index')
        "/warehouses/create"(controller: 'warehouse', action: 'create')
        "/warehouses/save"(controller: 'warehouse', action: 'save')
        "/warehouses/show/$id"(controller: 'warehouse', action: 'show')
        "/warehouses/addProduct/$warehouseId/$productId/$quantity"(controller: 'warehouse', action: 'addProduct')
        "/warehouses/removeProduct/$warehouseId/$productId"(controller: 'warehouse', action: 'removeProduct')
        "/warehouses/shipProduct/$warehouseId/$shopId/$productId/$quantity"(controller: 'warehouse', action: 'shipProduct')

        // Shop Controller mappings
        "/shops"(controller: 'shop', action: 'index')
        "/shops/create"(controller: 'shop', action: 'create')
        "/shops/save"(controller: 'shop', action: 'save')
        "/shops/show/$id"(controller: 'shop', action: 'show')
        "/shops/sellProduct/$shopId/$productId/$quantity"(controller: 'shop', action: 'sellProduct')
        "/shops/returnProduct/$shopId/$warehouseId/$productId/$quantity"(controller: 'shop', action: 'returnProduct')
        "/shops/checkExpired/$shopId"(controller: 'shop', action: 'checkExpired')

        // Error mapping
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
