package com.youthlin.TopFresh.action.admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.youthlin.TopFresh.po.ProductType;
import com.youthlin.TopFresh.service.ProductTypeService;
import com.youthlin.TopFresh.utils.JSPUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
    private String checkList;

    //TODO 确认删除
    //Struts2返回JSON对象的方法总结
    //http://kingxss.iteye.com/blog/1622455
    public String confirmDelete() throws IOException {
        List<ProductType> list = service.beforeDelete(checkList2ints());
        System.out.println("确认删除列表：" + list);
        StringBuilder sb = new StringBuilder("[");
        for (ProductType item : list) {
            sb.append(item.toJSONString());
        }
        sb.append("]");
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
//        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(sb.toString());
        out.flush();
        out.close();
        return SUCCESS;
    }

    private int[] checkList2ints() {
        String[] list = getCheckList().split(",");
        int[] ids = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            ids[i] = Integer.parseInt(list[i].trim());
        }
        return ids;
    }

    public String delete() {
        try {
            int[] ids = checkList2ints();
            service.delete(ids);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.warn(e.getMessage());
        }
        return SUCCESS;
    }

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

    public String getPagination() {
        String normal = "<li><a href=\"?pageNo={0}\">{1}</a></li>";
        String currentOrDisabled = "<li{0}><span>{1}</span></li>";
        return JSPUtils.pagination(getPageNo(), getLastPageNo(),
                normal, currentOrDisabled, "&laquo;", "&raquo;");
    }

    //region getter and setter
    public int getPageNo() {
        //Struts2 的Action中取得请求参数值的几种方法
        //http://www.cnblogs.com/bmbm/archive/2011/11/28/2342273.html
        HttpServletRequest request =
                (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (request.getParameter("pageNo") == null)
            pageNo = 1;
        if (pageNo < 1) pageNo = 1;
        if (pageNo > lastPageNO) pageNo = lastPageNO;
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        HttpServletRequest request =
                (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (request.getParameter("pageSize") == null)
            pageSize = 5;
        if (pageSize < 1) pageSize = 1;
        if (pageSize > service.getCount()) pageSize = (int) service.getCount();
        return pageSize;
    }

    public void setPageSize(int pageSize) {
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

    public String getCheckList() {
        return checkList;
    }

    public void setCheckList(String checkList) {
        this.checkList = checkList;
    }

    //endregion
}
