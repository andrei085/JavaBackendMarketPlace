package com.shop.marketplace.dto;

public class ProductReviewDto {

    private Long productId;
    private Long reviewId;

    public Long getReviewId(){
        return reviewId;
    }

    public Long getProductId() {
        return productId;
    }
}
