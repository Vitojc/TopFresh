package com.youthlin.TopFresh.dao;

import com.youthlin.TopFresh.po.ProductType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lin on 2016-05-13-013.
 * 商品种类DAO组件
 */
public interface ProductTypeDAO extends BaseDao<ProductType> {
    List<ProductType> willDelete(Class<ProductType> entityClazz, Serializable id);
}
