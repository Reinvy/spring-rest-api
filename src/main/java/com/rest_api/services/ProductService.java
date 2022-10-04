package com.rest_api.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api.models.entities.ProductEntity;
import com.rest_api.models.repositories.ProductRepository;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity save(ProductEntity product) {
        return productRepository.save(product);
    }

    public ProductEntity findById(Long id) {
        return productRepository.findById(id).get();
    }

    public Iterable<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public void removeOne(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductEntity> search(String name) {
        return productRepository.findByNameContains(name);
    }
}
