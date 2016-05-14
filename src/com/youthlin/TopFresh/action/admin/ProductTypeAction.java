package com.youthlin.TopFresh.action.admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.youthlin.TopFresh.po.ProductType;
import com.youthlin.TopFresh.service.ProductTypeService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lin on 2016-05-13-013.
 * 商品种类的增删改查
 */
public class ProductTypeAction extends ActionSupport {
    private ProductTypeService service;
    private List<ProductType> productTypeList;
    private int pageNo = 1;
    private int pageSize = 5;
    private int lastPageNO;

    public String list() {
        setProductTypeList(service.getOrderedAllByPage(getPageNo(), getPageSize()));
        return SUCCESS;
    }

    public int getLastPageNo() {
        long count = service.getCount();
        long pageCount = (count + pageSize - 1) / pageSize;
        lastPageNO = pageCount == 0 ? 1 : (int) pageCount;
        return lastPageNO;
    }

    //region getter and setter
    public int getPageNo() {
        //Struts2 的Action中取得请求参数值的几种方法
        //http://www.cnblogs.com/bmbm/archive/2011/11/28/2342273.html
        HttpServletRequest request =
                (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (request.getParameter("pageNo") == null)
            pageNo = 1;
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        System.out.println("set PageNo");
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        System.out.println("set PageSize");
        this.pageSize = pageSize;
    }

    public List<ProductType> getProductTypeList() {
        return productTypeList;
    }

    public void setProductTypeList(List<ProductType> productTypeList) {
        this.productTypeList = productTypeList;
    }

    public ProductTypeService getService() {

        return service;
    }

    public void setService(ProductTypeService service) {
        this.service = service;
    }
    //endregion
}
