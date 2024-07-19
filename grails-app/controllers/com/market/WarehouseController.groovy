package com.market

class WarehouseController {

    static scaffold =Warehouse

    WarehouseService warehouseService

    def index() {
        respond Warehouse.list()
    }

    def create() {
        respond new Warehouse(params)
    }

    def save(Warehouse warehouse) {
        warehouse.save(flush: true)
        redirect action: "index"
    }

    def show(Long id) {
        respond Warehouse.get(id)
    }

    def addProduct(Long warehouseId, Long productId, Integer quantity) {
        warehouseService.addProductToWarehouse(warehouseId, productId, quantity)
        redirect action: "show", id: warehouseId
    }

    def removeProduct(Long warehouseId, Long productId) {
        warehouseService.removeProductFromWarehouse(warehouseId, productId)
        redirect action: "show", id: warehouseId
    }

    def shipProduct(Long warehouseId, Long shopId, Long productId, Integer quantity) {
        warehouseService.shipProductToShop(warehouseId, shopId, productId, quantity)
        redirect action: "show", id: warehouseId
    }
}
