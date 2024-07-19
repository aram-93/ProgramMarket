package com.market

class ProductController {

    static scaffold = Product

    ProductService productService

    def index() {
        respond Product.list()
    }

    def create() {
        respond new Product(params)
    }

    def save(Product product) {
        productService.saveProduct(product)
        redirect(action: "index")
    }

    def edit(Long id) {
        respond Product.get(id)
    }

    def update(Long id) {
        def product = Product.get(id)
        if (product) {
            productService.editProduct(id, params.code, params.name, params.price, params.productionDate, params.expirationDate)
            redirect action: "index"
        } else {
            notFound()
        }
    }

    def delete(Long id) {
        productService.removeProduct(id)
        redirect action: "index"
    }
}
