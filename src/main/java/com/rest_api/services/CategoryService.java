package com.rest_api.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api.models.entities.CategoryEntity;
import com.rest_api.models.repositories.CategoryRepository;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }
}
