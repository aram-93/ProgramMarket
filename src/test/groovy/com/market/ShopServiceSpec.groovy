package com.market

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ShopServiceSpec extends Specification implements ServiceUnitTest<ShopService> {

     void "test something"() {
        expect:
        service.doSomething()
     }
}
