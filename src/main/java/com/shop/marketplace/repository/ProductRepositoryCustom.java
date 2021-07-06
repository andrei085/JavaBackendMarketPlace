package com.shop.marketplace.repository;

import com.shop.marketplace.model.Product;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> getCustomProduct(String string);

    List<Product> getPaginatedProducts(int firstResults, int maxResults);

    long getTotalProducts();

}

