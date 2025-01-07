package com.ecomBackEnd.ecomBackEnd.controller;

import com.ecomBackEnd.ecomBackEnd.model.Product;
import com.ecomBackEnd.ecomBackEnd.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product>getProductById(@PathVariable int id){
        Product product = productService.getProductById(id);
        if (product != null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("product/{productId}/image")
    public ResponseEntity<byte[]>getImageById(@PathVariable int productId){
        Product product = productService.getProductById(productId);
        if (product != null){
            return new ResponseEntity<>(product.getImageData(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(
            @RequestPart("product") String productJson,
            @RequestPart("imageFile") MultipartFile imageFile) {

        Product product = null;
        try {
            // Deserialize the JSON string to a Product object
            ObjectMapper objectMapper = new ObjectMapper();
            product = objectMapper.readValue(productJson, Product.class);

            // Now pass the deserialized product to your service
            Product savedProduct = productService.addOrUpdateProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(
            @PathVariable int id,
            @RequestPart("product") String productJson,
            @RequestPart(value = "imageFile", required = false) MultipartFile imageFile
    ) {
        try {
            // Deserialize the JSON string into a Product object
            ObjectMapper objectMapper = new ObjectMapper();
            Product product = objectMapper.readValue(productJson, Product.class);

            // Set the ID explicitly (if not already part of the request)
            product.setId(id);

            // Call service to update the product
            productService.addOrUpdateProduct(product, imageFile);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String>deleteProduct(@PathVariable int id){
        Product product = productService.getProductById(id);
        if(product != null){
            productService.deleteProducto(id);
            return  new ResponseEntity<>("Deleated",HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>>searchProducts(@RequestParam String keyword){
        List<Product>products=productService.searchProducts(keyword);
        System.out.println("searching with "+keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

}
