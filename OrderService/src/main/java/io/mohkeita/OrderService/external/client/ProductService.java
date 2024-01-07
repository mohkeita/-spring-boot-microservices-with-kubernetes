package io.mohkeita.OrderService.external.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.mohkeita.OrderService.exception.CustomException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "PRODUCT-SERVICE/products")
public interface ProductService {

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(
            @PathVariable("id") long productId,
            @RequestParam long quantity
    );

    default void fallback(Exception e) {
        throw new CustomException(
                "Product Service is not available",
                "UNAVAILABLE", 500
        );
    }
}
