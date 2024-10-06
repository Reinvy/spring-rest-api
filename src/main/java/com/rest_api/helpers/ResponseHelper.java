package com.rest_api.helpers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {

    public static ResponseEntity<Object> build(HttpStatus httpStatus, Boolean success, String message, Object data) {
        ApiResponse apiResponse = ApiResponse.builder()
                .timestamp(LocalDateTime.now(ZoneId.of("GMT+7")))
                .success(success)
                .message(message)
                .data(data)
                .build();

        return new ResponseEntity<>(apiResponse, httpStatus);
    }

}
