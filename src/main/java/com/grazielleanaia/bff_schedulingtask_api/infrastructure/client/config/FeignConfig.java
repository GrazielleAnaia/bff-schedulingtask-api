package com.grazielleanaia.bff_schedulingtask_api.infrastructure.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class FeignConfig {
    @Bean
    public FeignError feignError() {
        return new FeignError();
    }
}
