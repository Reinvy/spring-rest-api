package com.rest_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api.helpers.ResponseHelper;
import com.rest_api.models.entities.ProductEntity;
import com.rest_api.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody ProductEntity product) {
        try {
            ProductEntity data = productService.save(product);
            return ResponseHelper.build(HttpStatus.OK, true, "Data created successfully", data);
        } catch (Exception e) {
            return ResponseHelper.build(HttpStatus.INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody ProductEntity product) {
        try {
            ProductEntity data = productService.save(product);
            return ResponseHelper.build(HttpStatus.OK, true, "Data updated successfully", data);
        } catch (Exception e) {
            return ResponseHelper.build(HttpStatus.INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            Iterable<ProductEntity> data = productService.findAll();
            return ResponseHelper.build(HttpStatus.OK, true, "Data retrieved successfully", data);
        } catch (Exception e) {
            return ResponseHelper.build(HttpStatus.INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findbyId(@PathVariable Long id) {
        try {
            ProductEntity data = productService.findById(id);
            return ResponseHelper.build(HttpStatus.OK, true, "Data retrieved successfully", data);
        } catch (Exception e) {
            return ResponseHelper.build(HttpStatus.INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        try {
            productService.removeOne(id);
            return ResponseHelper.build(HttpStatus.OK, true, "Data deleted successfully", null);
        } catch (Exception e) {
            return ResponseHelper.build(HttpStatus.INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }
}
