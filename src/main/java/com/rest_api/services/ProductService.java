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
    private ProductRepository productRepo;

    public ProductEntity save(ProductEntity product) {
        return productRepo.save(product);
    }

    public ProductEntity findById(Long id) {
        return productRepo.findById(id).get();
    }

    public Iterable<ProductEntity> findAll() {
        return productRepo.findAll();
    }

    public void removeOne(Long id) {
        productRepo.deleteById(id);
    }

    public List<ProductEntity> search(String name) {
        return productRepo.findByNameContains(name);
    }
}
