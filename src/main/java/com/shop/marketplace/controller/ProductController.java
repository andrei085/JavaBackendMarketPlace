package com.shop.marketplace.controller;

import com.shop.marketplace.dto.*;
import com.shop.marketplace.exception.CustomConflictException;
import com.shop.marketplace.model.Product;
import com.shop.marketplace.repository.ProductRepository;
import com.shop.marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/createProduct")
    public ResponseEntity<Object> createCompany(@RequestBody ProductDto productDto) throws CustomConflictException {
        return productService.createProduct(productDto);    }

    @GetMapping("/getProduct/{id}")
    public Product getProductById(@PathVariable Long id) throws Exception {
        return productService.getProductById(id);
    }

    @PostMapping("/getProducts")
    public ProductResponseDto getPaginatedProducts(@RequestBody PagingDto pagingDto){
        int page = pagingDto.getPage();
        int size = pagingDto.getSize();

        int firstResults = page * size;
        int maxResults = firstResults + size;

        List<Product> products = productRepository.getPaginatedProducts(firstResults,maxResults);
        long totalProducts = productRepository.getTotalProducts();

        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setProducts(products);
        responseDto.setFrom(firstResults);
        responseDto.setTo(maxResults);
        responseDto.setTotalProducts(totalProducts);

        return responseDto;

    }

}
