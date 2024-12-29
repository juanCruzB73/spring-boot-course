package com.ecomBackEnd.ecomBackEnd.service;

import com.ecomBackEnd.ecomBackEnd.model.Product;
import com.ecomBackEnd.ecomBackEnd.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return  productRepository.findById(id).orElse(null);
    }

    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {
        // Check if product exists
        if (product.getId() != 0) {
            // Product exists, so fetch it and update it
            Product existingProduct = productRepository.findById(product.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Product not found"));

            // Only update the fields that can be updated
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setReleaseDate(product.getReleaseDate());
            existingProduct.setProductAvailable(product.isProductAvailable());
            existingProduct.setStockQuantity(product.getStockQuantity());

            // If the image file is provided, update it
            if (image != null && !image.isEmpty()) {
                existingProduct.setImageName(image.getOriginalFilename());
                existingProduct.setImageType(image.getContentType());
                existingProduct.setImageData(image.getBytes());
            }

            // Save the updated product
            return productRepository.save(existingProduct);
        } else {
            // Product does not exist, create a new one
            if (image != null && !image.isEmpty()) {
                product.setImageName(image.getOriginalFilename());
                product.setImageType(image.getContentType());
                product.setImageData(image.getBytes());
            }

            return productRepository.save(product);
        }
    }


    public void deleteProducto(int id) {
        productRepository.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword);
    }
}
