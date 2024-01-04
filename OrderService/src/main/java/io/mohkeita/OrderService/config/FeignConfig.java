package io.mohkeita.OrderService.config;

import feign.codec.ErrorDecoder;
import io.mohkeita.OrderService.external.decoder.CustomErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}
