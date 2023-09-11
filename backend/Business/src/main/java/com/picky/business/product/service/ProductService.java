package com.picky.business.product.service;

import com.picky.business.product.domain.entity.Product;
import com.picky.business.product.domain.repository.ProductRepository;
import com.picky.business.product.dto.CommentResponse;
import com.picky.business.product.dto.ProductDetailResponse;
import com.picky.business.product.dto.ProductRegistRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductDetailResponse findProductByProductId(Long productId) {
        Product product = productRepository.findProductById(productId);

        if (product == null) return null;

        List<CommentResponse> commentResponseList = Optional.ofNullable(product.getComments())
                .orElse(Collections.emptyList())
                .stream()
                .map(comment -> CommentResponse.builder()
                        .nickname(comment.getUserNickname())
                        .content(comment.getContent())
                        .createdAt(comment.getCreatedAt().toString())
                        .build())
                .collect(Collectors.toList());

        return ProductDetailResponse.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .filename(product.getFilename())
                .badge(product.getBadge())
                .category(product.getCategory())
                .favoriteCount(product.getFavoriteCount())
                .weight(product.getWeight())
                .kcal(product.getKcal())
                .carb(product.getCarb())
                .protein(product.getProtein())
                .fat(product.getFat())
                .sodium(product.getSodium())
                .comments(commentResponseList)
                .build();
    }
    public void addProduct(ProductRegistRequest request){
        productRepository.save(
                Product.builder()
                        .productName(request.getProductName())
                        .price(request.getPrice())
                        .filename(request.getFilename())
                        .badge(request.getBadge())
                        .category(request.getCategory())
                        .favoriteCount(0)
                        .weight(request.getWeight())
                        .kcal(request.getKcal())
                        .carb(request.getCarb())
                        .protein(request.getProtein())
                        .fat(request.getFat())
                        .sodium(request.getSodium())
                        .convenienceCode(request.getConvenienceCode())
                        .build()
        );
    }
}
