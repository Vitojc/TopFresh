package com.youthlin.TopFresh.po;

import javax.persistence.*;

/**
 * Created by lin on 2016-05-02-002.
 * 订单项信息
 */
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemId;
    private Integer orderItemCount;
    @ManyToOne
    private OrderInfo orderItemOrderInfo;//多个订单项属于同一个订单
    @ManyToOne
    private Product orderItemProduct;//多个商品属于同一个订单

    public Integer getOrderItemCount() {
        return orderItemCount;
    }

    public void setOrderItemCount(Integer orderItemCount) {
        this.orderItemCount = orderItemCount;
    }

    public OrderInfo getOrderItemOrderInfo() {
        return orderItemOrderInfo;
    }

    public void setOrderItemOrderInfo(OrderInfo orderItemOrderInfo) {
        this.orderItemOrderInfo = orderItemOrderInfo;
    }

    public Product getOrderItemProduct() {
        return orderItemProduct;
    }

    public void setOrderItemProduct(Product orderItemProduct) {
        this.orderItemProduct = orderItemProduct;
    }
}
