package org.example.ecommerce;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;

@XmlRootElement(name = "product")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    @XmlAttribute(name = "id")
    private String productId;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "imageUrl")
    private String imageUrl;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "createdBy")
    private User createdBy;

    public Product() {
    }

    public Product(String productId, String description, String imageUrl,
                   BigDecimal price, User createdBy) {
        this.productId = productId;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.createdBy = createdBy;
    }

    public String getProductId() {
        return productId;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    @Override
    public String toString() {
        return "Product{" +
                "\n productId='" + productId + '\'' +
                ",\n description='" + description + '\'' +
                ",\n imageUrl='" + imageUrl + '\'' +
                ",\n price=" + price +
                ",\n createdBy=" + createdBy + "\n" +
                '}';
    }
}
