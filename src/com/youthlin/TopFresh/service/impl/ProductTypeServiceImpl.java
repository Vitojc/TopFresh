package com.youthlin.TopFresh.service.impl;

import com.youthlin.TopFresh.dao.ProductTypeDAO;
import com.youthlin.TopFresh.po.ProductType;
import com.youthlin.TopFresh.service.ProductTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lin on 2016-05-13-013.
 * 商品种类服务实现类
 */
public class ProductTypeServiceImpl implements ProductTypeService {
    private ProductTypeDAO productTypeDAO;
    private static boolean hasModified = true;
    private static List<ProductType> orderedList;
    private static Long count;
    private static final Logger LOG = LoggerFactory.getLogger(ProductTypeServiceImpl.class);

    public ProductTypeDAO getProductTypeDAO() {
        return productTypeDAO;
    }

    public void setProductTypeDAO(ProductTypeDAO productTypeDAO) {
        this.productTypeDAO = productTypeDAO;
    }

    @Override
    public List<ProductType> getAll() {
        return productTypeDAO.findAll(ProductType.class);
    }

    @Override
    public long getCount() {
        if (hasModified || count == null)
            count = productTypeDAO.findCount(ProductType.class);
        hasModified = false;
        return count;
    }

    @Override
    public List<ProductType> beforeDelete(int[] ids) {
        List<ProductType> list = new ArrayList<>();
        for (int id : ids) {
            list.addAll(productTypeDAO.willDelete(ProductType.class, id));
        }
        return list;
    }

    @Override
    public void delete(int[] ids) {
        LOG.debug("删除列表项:" + Arrays.toString(ids));
        for (int item : ids) {
            productTypeDAO.delete(ProductType.class, item);
        }
    }

    @Override
    public List<ProductType> getOrderedAllByPage(int pageNo, int pageSize) {
        if (orderedList == null || hasModified) getOrderedAll();

        if (pageNo == 0) pageNo = 1;
        if (pageSize == 0) pageSize = 5;

        int from = (pageNo - 1) * pageSize;
        if (from > orderedList.size()) from = 0;
        int to = from + pageSize;
        if (to > orderedList.size()) to = orderedList.size();
//        System.out.println("from=" + from + " to=" + to);
        if (orderedList.size() < pageSize || from < 0 || to < 0) {
            return orderedList;
        }
        return orderedList.subList(from, to);
    }

    private List<ProductType> getOrderedAll() {
        if (hasModified || orderedList == null) {
            orderedList = new ArrayList<>();
            List<ProductType> rootLevel = productTypeDAO.find("from " + ProductType.class.getSimpleName()
                    + " as type where type.typeParent = NULL order by type.typeOrderInLevel");
            addToList(orderedList, rootLevel);
            hasModified = false;
        }
        return orderedList;
    }

    private List<ProductType> getOrderedTypeByParent(ProductType parent) {
        return productTypeDAO.find("from " + ProductType.class.getSimpleName() +
                " as type where type.typeParent = " + parent.getTypeId() + " order by type.typeOrderInLevel");
    }

    private void addToList(List<ProductType> result, List<ProductType> level) {
        if (level != null && level.size() > 0) {
            for (ProductType type : level) {
                result.add(type);
                System.out.println("add:" + type);
                addToList(result, getOrderedTypeByParent(type));
            }
        }
    }

}
