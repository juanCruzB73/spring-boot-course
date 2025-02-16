package com.backend.example.exampleApiRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderRecord ( String customerName, String productName, int quantity){

}
