package com.rest_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api.helpers.ResponseException;
import com.rest_api.helpers.ResponseHelper;
import com.rest_api.models.entities.CategoryEntity;
import com.rest_api.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            Iterable<CategoryEntity> data = categoryService.findAll();
            return ResponseHelper.build(HttpStatus.OK, true, "Data retrieved successfully", data);
        } catch (ResponseException e) {
            return ResponseHelper.build(e.getHttpStatus(), false, e.getErrorMessage(), null);
        } catch (Exception e) {
            return ResponseHelper.build(HttpStatus.INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }
}
