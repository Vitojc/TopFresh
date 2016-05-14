package com.youthlin.TopFresh.service;

import com.youthlin.TopFresh.po.ProductType;

import java.util.List;

/**
 * Created by lin on 2016-05-13-013.
 * 商品种类的接口
 */
public interface ProductTypeService {
    List<ProductType> getAll();

    long getCount();

    List<ProductType> getOrderedAllByPage(int pageNo, int pageSize);
}
