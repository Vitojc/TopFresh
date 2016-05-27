package com.youthlin.TopFresh.po;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by lin on 2016-05-02-002.
 * 种类信息
 */
@Entity
@Table(name = "productType")
public class ProductType {
    // 注解要么全在字段上要么全在getXXX上，否则报错：
    // Could not determine type for: java.util.List, at table:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;
    private String typeName;
    private Integer typeLevel;
    private Integer typeOrderInLevel;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Product> typeProductSet = new TreeSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeParentId")
    private ProductType typeParent;

    @OneToMany(targetEntity = ProductType.class, cascade = CascadeType.ALL, mappedBy = "typeParent")
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("typeOrderInLevel")
    private List<ProductType> typeChild;

    public ProductType() {
        typeChild = new ArrayList<>();
    }

    public void addChild(ProductType subType) {
        getTypeChild().add(subType);
        subType.setTypeParent(this);
    }

    @Override
    public String toString() {
        return "[ProductType: id=" + typeId + ", name=" + typeName + ",level=" + typeLevel + ",order=" + typeOrderInLevel + ",productSet=" + typeProductSet + "]";
    }

    public String toJSONString() {
        return "{\"id\":" + typeId + ",\"name\":\"" + typeName + "\",\"level\":" + typeLevel + ",\"order\":" + typeOrderInLevel + "}";
    }

    public Set<Product> getTypeProductSet() {
        //System.out.println("获取" + typeName + "类别下商品集合");
        return typeProductSet;
    }

    public void setTypeProductSet(Set<Product> typeProductSet) {
        this.typeProductSet = typeProductSet;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeLevel() {
        return typeLevel;
    }

    public void setTypeLevel(Integer typeLevel) {
        this.typeLevel = typeLevel;
    }

    public Integer getTypeOrderInLevel() {
        return typeOrderInLevel;
    }

    public void setTypeOrderInLevel(Integer typeOrderInLevel) {
        this.typeOrderInLevel = typeOrderInLevel;
    }

    public ProductType getTypeParent() {
        return typeParent;
    }

    public void setTypeParent(ProductType typeParent) {
        this.typeParent = typeParent;
    }

    public List<ProductType> getTypeChild() {
        return typeChild;
    }

    public void setTypeChild(List<ProductType> typeChild) {
        this.typeChild = typeChild;
    }
}
