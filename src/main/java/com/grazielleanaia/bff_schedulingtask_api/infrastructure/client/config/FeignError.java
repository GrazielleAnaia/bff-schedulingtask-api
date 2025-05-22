package com.grazielleanaia.bff_schedulingtask_api.infrastructure.client.config;


import com.grazielleanaia.bff_schedulingtask_api.infrastructure.exception.BusinessException;
import com.grazielleanaia.bff_schedulingtask_api.infrastructure.exception.ConflictException;
import com.grazielleanaia.bff_schedulingtask_api.infrastructure.exception.IllegalArgumentException;
import com.grazielleanaia.bff_schedulingtask_api.infrastructure.exception.ResourceNotFoundException;
import com.grazielleanaia.bff_schedulingtask_api.infrastructure.exception.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        String message = errorMessage(response);
        switch(response.status()) {
            case 409:
                return new ConflictException("Error: " + message);
            case 403:
                return new ResourceNotFoundException("Error: " + message);
            case 401:
                return new UnauthorizedException("Error: " + message);
            case 400:
                return new IllegalArgumentException("Error: " + message);
            default:
                return new BusinessException("Error: " + message);
        }
    }

    public String errorMessage(Response response) {
        try {
            if(Objects.isNull(response.body())) {
                return "";
            }
           return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
