package com.youthlin.TopFresh.interceptor.admin;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.youthlin.TopFresh.po.Admin;

import java.util.Map;

/**
 * Created by lin on 2016-05-04-004.
 * 管理员拦截器：验证登录
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    private String name;

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
//        System.out.println("登录拦截:" + getName());
        ActionContext context = actionInvocation.getInvocationContext();
        Map session = context.getSession();
        try {
            Admin admin = (Admin) session.get("admin");
            if (admin != null) {
                return actionInvocation.invoke();
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        System.out.println("管理员未登录，转到登录页面...");
        context.put("login", "您还没有登录");
        return Action.LOGIN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
