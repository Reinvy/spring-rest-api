package com.rest_api.services;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api.models.entities.ProfileEntity;
import com.rest_api.models.repositories.ProfileRepository;

@Service
@Transactional
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Iterable<ProfileEntity> findAll() {
        return profileRepository.findAll();
    }

    public ProfileEntity findById(Long id) {
        return profileRepository.findById(id).get();
    }

    public ProfileEntity addData(ProfileEntity data) {
        return profileRepository.save(data);
    }
}
