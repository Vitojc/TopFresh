package com.youthlin.TopFresh.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by lin on 2016-05-02-002.
 * 种类信息
 */
@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;
    private String typeName;
    private Integer typeLevel;
    private Integer typeParentId;

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

    public Integer getTypeParentId() {
        return typeParentId;
    }

    public void setTypeParentId(Integer typeParentId) {
        this.typeParentId = typeParentId;
    }
}
