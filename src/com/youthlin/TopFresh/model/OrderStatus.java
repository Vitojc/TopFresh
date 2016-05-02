package com.youthlin.TopFresh.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lin on 2016-05-02-002.
 * 订单状态
 */
public enum OrderStatus {
    CREATED {
        @Override
        public String getName() {
            return "已创建";
        }
    },
    CANCELED {
        @Override
        public String getName() {
            return "已取消";
        }
    },
    PAID {
        @Override
        public String getName() {
            return "已支付";
        }
    },
    FINISHED {
        @Override
        public String getName() {
            return "已完成";
        }
    };

    public abstract String getName();

    public static List<String> getValues() {
        List<String> list = new ArrayList<String>();
        for (OrderStatus orderState : OrderStatus.values()) {
            list.add(orderState.getName());
        }
        return list;
    }
}
