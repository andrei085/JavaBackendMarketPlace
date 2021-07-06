package com.shop.marketplace.service;

import com.shop.marketplace.dto.ProductDto;
import com.shop.marketplace.dto.ProductReviewDto;
import com.shop.marketplace.exception.Conflict;
import com.shop.marketplace.exception.CustomConflictException;
import com.shop.marketplace.exception.CustomEntityNotFoundException;
import com.shop.marketplace.model.Product;
import com.shop.marketplace.model.Review;
import com.shop.marketplace.repository.ProductRepository;
import com.shop.marketplace.repository.ReviewRepository;
import com.shop.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public Product getProductById(Long id) throws Exception{
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();

            return product;
        } throw new CustomEntityNotFoundException(Product.class);
    }

    public ResponseEntity<Object> createProduct(ProductDto productDto) throws CustomConflictException{

        if(productDto.getName().isEmpty())
            throw new CustomConflictException(Conflict.INVALID_NAME);
        String name=productDto.getName();
        if(productDto.getCategory().isEmpty())
            throw new CustomConflictException(Conflict.INVALID_CATEGORY);
        String category = productDto.getCategory();
        if(productDto.getPrice()<1)
            throw new CustomConflictException(Conflict.INVALID_PRICE);
        double price = productDto.getPrice();
        if(productDto.getDescription().isEmpty())
            throw new CustomConflictException(Conflict.INVALID_DESCRIPTION);
        String description = productDto.getDescription();
        Product product = new Product(name,category,price,description);
        productRepository.save(product);

        return new ResponseEntity<>("saved", HttpStatus.CREATED);
    }

    public ResponseEntity<Object> addReviewToProduct(ProductReviewDto productReviewDto){
        long productId = productReviewDto.getProductId();
        long reviewId = productReviewDto.getReviewId();

        Optional<Product> optionalProduct = productRepository.findById(productId);
        Optional<Review> optionalreview = reviewRepository.findById(reviewId);

        if(optionalProduct.isPresent() && optionalreview.isPresent()){
            Product product = optionalProduct.get();
            Review review = optionalreview.get();

            product.addReview(review);

            productRepository.save(product);

            return new ResponseEntity<>("saved", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }
}
