package io.mohkeita.ProductService.service;


import io.mohkeita.ProductService.model.ProductRequest;

public interface ProductService {
    long addProduct(ProductRequest productRequest);
}
