package com.youthlin.TopFresh.po;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lin on 2016-05-02-002.
 * 商品(水果)信息
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private String productDescribe;
    private Double productPrice;
    @ManyToOne
    private ProductType productType;//多个商品属于同一个种类

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @ManyToMany
    private Set<ImageUpload> productImage = new HashSet<>();

    public Set<ImageUpload> getProductImage() {
        return productImage;
    }

    public void setProductImage(Set<ImageUpload> productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

}
