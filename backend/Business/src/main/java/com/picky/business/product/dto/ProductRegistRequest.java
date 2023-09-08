package com.picky.business.product.dto;

import com.picky.business.product.domain.entity.Badge;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRegistRequest {
    private String productName;
    private int price;
    private String filename;
    private Badge badge;
    private int category;
    private int weight;
    private int kcal;
    private double carb;
    private double protein;
    private double fat;
    private double sodium;
    private List<Integer> convenienceCode;

}
