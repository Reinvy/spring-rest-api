package com.rest_api.services;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rest_api.helpers.ResponseException;
import com.rest_api.models.entities.ProductEntity;
import com.rest_api.models.repositories.ProductRepository;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity save(ProductEntity product) throws Exception {
        return productRepository.save(product);
    }

    public ProductEntity findById(Long id) throws Exception {
        return productRepository.findById(id).get();
    }

    public Iterable<ProductEntity> findAll() throws Exception {
        return productRepository.findAll();
    }

    public void removeOne(Long id) throws Exception {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (!product.isPresent()) {
            throw new ResponseException(HttpStatus.NOT_FOUND, "Data not found");
        }
        productRepository.delete(product.get());
    }

    public List<ProductEntity> search(String name) throws Exception {
        return productRepository.findByNameContains(name);
    }
}
