package io.mohkeita.ProductService.service;

import io.mohkeita.ProductService.entity.Product;
import io.mohkeita.ProductService.exception.ProductServiceCustomException;
import io.mohkeita.ProductService.model.ProductRequest;
import io.mohkeita.ProductService.model.ProductResponse;
import io.mohkeita.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product..");
        Product product = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product Created");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("Get the product for productId: {} ", productId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException("Product with given id not found", "PRODUCT_NOT_FOUND"));

        ProductResponse productResponse = new ProductResponse();

        BeanUtils.copyProperties(product,
                productResponse);
        return productResponse;
    }
}
