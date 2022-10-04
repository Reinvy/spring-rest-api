package com.rest_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api.models.entities.ProductEntity;
import com.rest_api.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductEntity create(@RequestBody ProductEntity product) {
        return productService.save(product);
    }

    @GetMapping
    public Iterable<ProductEntity> findAll() {
        return productService.findAll();
    }
}
