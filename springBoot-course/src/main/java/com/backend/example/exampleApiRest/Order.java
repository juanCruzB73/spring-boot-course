package com.backend.example.exampleApiRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    @JsonProperty("c-name")  //default value empty, has to be specified
    private String customerName;
    @JsonProperty("p-name")
    private String productName;
    @JsonProperty("p-quantity")
    private int quantity;


    //order creates final variables and unmutable(cant change the name with JsonProperty
    public Order(String customerName, String productName, int quantity) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{ "+
                "Customer Name: " + customerName + ", " +
                "Product Name: " + productName + ", " +
                "Quantity: " + quantity+" }";
    }

}
