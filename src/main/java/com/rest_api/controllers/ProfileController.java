package com.rest_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api.helpers.ResponseException;
import com.rest_api.helpers.ResponseHelper;
import com.rest_api.models.entities.ProfileEntity;
import com.rest_api.services.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<Object> findAllData() {
        try {
            Iterable<ProfileEntity> data = profileService.findAll();
            return ResponseHelper.build(HttpStatus.OK, true, "Data retrieved successfully", data);
        } catch (ResponseException e) {
            return ResponseHelper.build(e.getHttpStatus(), false, e.getErrorMessage(), null);
        } catch (Exception e) {
            return ResponseHelper.build(HttpStatus.INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            ProfileEntity data = profileService.findById(id);
            return ResponseHelper.build(HttpStatus.OK, true, "Data retrieved successfully", data);
        } catch (ResponseException e) {
            return ResponseHelper.build(e.getHttpStatus(), false, e.getErrorMessage(), null);
        } catch (Exception e) {
            return ResponseHelper.build(HttpStatus.INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> findData(@RequestBody ProfileEntity data) {
        try {
            ProfileEntity profile = profileService.addData(data);
            return ResponseHelper.build(HttpStatus.OK, true, "Data created successfully", profile);
        } catch (ResponseException e) {
            return ResponseHelper.build(e.getHttpStatus(), false, e.getErrorMessage(), null);
        } catch (Exception e) {
            return ResponseHelper.build(HttpStatus.INTERNAL_SERVER_ERROR, false, e.getMessage(), null);
        }
    }
}
