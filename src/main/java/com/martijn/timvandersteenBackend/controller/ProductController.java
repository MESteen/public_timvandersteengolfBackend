package com.martijn.timvandersteenBackend.controller;


import com.martijn.timvandersteenBackend.exception.ResourceNotFoundException;
import com.martijn.timvandersteenBackend.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.martijn.timvandersteenBackend.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductDao productDao;

    @GetMapping("/all")
    public String getAllProducts() throws JsonProcessingException {
        List<Product> list = productDao.findAll();
        String gson = new Gson().toJson(list);
        return gson;
    }

    //GEEN JSON?
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(value = "id") int productId) {
        Product returnVal =productDao.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        return returnVal;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public Product createProduct(@Validated @RequestBody String productJson) {
        Product addProduct = new Gson().fromJson( productJson, Product.class );
        return productDao.save(addProduct);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public Product updateProduct(@PathVariable(value = "id") int productId,
                                 @Validated @RequestBody Product productDetails) {

        Product product = productDao.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

        product.setName(productDetails.getName());
        product.setBeschrijving(productDetails.getBeschrijving());
        product.setKleur(productDetails.getKleur());
        product.setIcon(productDetails.getIcon());
        product.setEenheid(productDetails.getEenheid());
        product.setPrice(productDetails.getPrice());

        Product updatedProduct = productDao.save(product);
        return updatedProduct;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") int productId) {
        Product product = productDao.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

        productDao.delete(product);

        return ResponseEntity.ok().build();
    }
}

