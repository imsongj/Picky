package com.picky.business.product.controller;

import com.picky.business.product.dto.ProductRegistRequest;
import com.picky.business.product.dto.ProductDetailResponse;
import com.picky.business.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;
    @GetMapping(value = "/{productId}")
    public ResponseEntity<ProductDetailResponse> productDetailsByProductId(
            @PathVariable Long productId){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductByProductId(productId));
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody ProductRegistRequest request){
        productService.addProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("상품등록 완료");
    }


}
