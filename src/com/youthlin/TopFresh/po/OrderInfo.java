package com.youthlin.TopFresh.po;

import javax.persistence.*;

import com.youthlin.TopFresh.model.OrderStatus;

/**
 * Created by lin on 2016-05-02-002.
 * 订单信息
 */
@Entity
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private String orderNo;
    private Double orderTotalPrice;
    private String orderRemark;
    private OrderStatus orderStatus;

    @ManyToOne
    private User orderUser;//多个订单属于同一个用户

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public Double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(Double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
