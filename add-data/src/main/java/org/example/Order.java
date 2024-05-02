package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.MessageFormat;

public class Order {

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("customer_name")
    private String customerName;

    public Order() {
    }

    public Order(String orderId, String customerId, String customerName) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Order'{'orderId=''{0}'', customerId=''{1}'', customerName=''{2}'''}'", orderId, customerId, customerName);
    }
}