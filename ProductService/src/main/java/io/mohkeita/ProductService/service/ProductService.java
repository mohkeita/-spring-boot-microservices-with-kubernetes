package io.mohkeita.ProductService.service;


import io.mohkeita.ProductService.model.ProductRequest;
import io.mohkeita.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);
}
