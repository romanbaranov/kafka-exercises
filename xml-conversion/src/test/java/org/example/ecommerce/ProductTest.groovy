package org.example.ecommerce

import groovy.util.slurpersupport.GPathResult
import jakarta.xml.bind.JAXBContext
import jakarta.xml.bind.Marshaller
import spock.lang.Specification

class ProductTest extends Specification {
    private def product
    
    void setup() {
        def l = 10
        def longId = Long.valueOf(l)
        def user = new User(longId, "John", "john@springframework.guru")
        product = new Product("PO1", "Spring Guru Mug", "http://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg", new BigDecimal(18.95), user)
    }

    void cleanup() {
        product = null
    }

    def "should marshall product"() {
        given:
        def jaxbContext = JAXBContext.newInstance(Product.class)
        def marshaller = jaxbContext.createMarshaller()
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
        def sw = new StringWriter()

        when:
        marshaller.marshal(product, new File("dir/product.xml"))
        marshaller.marshal(product, sw)
        marshaller.marshal(product, System.out)

        then:
        1==1
        def xml = sw.toString()
        GPathResult gPathResult = new XmlSlurper().parseText(xml)
        gPathResult.name() == 'product'
    }
}
