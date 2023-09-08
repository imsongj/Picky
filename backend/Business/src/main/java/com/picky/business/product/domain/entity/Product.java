package com.picky.business.product.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="product")
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int price;
    private String filename;
    private Badge badge;
    private int category;
    private int favoriteCount;
    private int weight;
    private int kcal;
    private double carb;
    private double protein;
    private double fat;
    private double sodium;
    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    //편의점 코드
    @Column(name="convenience_store_code")
    @ElementCollection
    @CollectionTable(name="convenience_store")
    private List<Integer> convenienceCode = new ArrayList<>();

}
