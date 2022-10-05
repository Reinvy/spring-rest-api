package com.rest_api.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rest_api.models.entities.ProfileEntity;

public interface ProfileRepository extends CrudRepository<ProfileEntity, Long> {

}
