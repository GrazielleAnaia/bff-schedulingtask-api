package com.grazielleanaia.bff_schedulingtask_api.infrastructure.client.config;


import com.grazielleanaia.bff_schedulingtask_api.infrastructure.exception.BusinessException;
import com.grazielleanaia.bff_schedulingtask_api.infrastructure.exception.ConflictException;
import com.grazielleanaia.bff_schedulingtask_api.infrastructure.exception.ResourceNotFoundException;
import com.grazielleanaia.bff_schedulingtask_api.infrastructure.exception.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        switch (response.status()) {
            case 409:
                return new ConflictException("Existent attribute error");
            case 403:
                return new ResourceNotFoundException("Attribute not found");
            case 401:
                return new UnauthorizedException("Not authorized customer");
            default:
                return new BusinessException("Server error");
        }
    }
}
