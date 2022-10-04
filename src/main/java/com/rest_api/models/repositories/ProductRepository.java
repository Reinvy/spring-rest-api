package com.rest_api.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rest_api.models.entities.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findByNameContains(String name);
}
