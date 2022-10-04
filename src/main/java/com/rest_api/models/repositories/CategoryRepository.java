package com.rest_api.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rest_api.models.entities.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

}
