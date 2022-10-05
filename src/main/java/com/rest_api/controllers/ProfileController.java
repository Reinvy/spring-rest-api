package com.rest_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api.models.entities.ProductEntity;
import com.rest_api.models.entities.ProfileEntity;
import com.rest_api.services.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public Iterable<ProfileEntity> findAllData() {
        return profileService.findAll();
    }

    @GetMapping("/{id}")
    public ProfileEntity findById(@PathVariable Long id) {
        return profileService.findById(id);
    }

    @PostMapping
    public ProfileEntity findData(@RequestBody ProfileEntity data) {
        return profileService.addData(data);
    }
}
