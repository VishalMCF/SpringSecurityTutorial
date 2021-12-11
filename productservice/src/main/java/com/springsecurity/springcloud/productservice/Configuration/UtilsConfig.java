package com.springsecurity.springcloud.productservice.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UtilsConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
