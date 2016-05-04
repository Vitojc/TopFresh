package com.youthlin.TopFresh.interceptor.admin;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.youthlin.TopFresh.action.admin.LoginAction;
import com.youthlin.TopFresh.po.Admin;

import java.util.Map;

/**
 * Created by lin on 2016-05-04-004.
 * 管理员拦截器：验证登录
 */
public class LoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext context = actionInvocation.getInvocationContext();

        //当前Action是登录Action是不需拦截，否则会一直登录不上的，死循环哦
        if (actionInvocation.getAction().getClass().getSimpleName().equals(LoginAction.class.getSimpleName()))
            return actionInvocation.invoke();

        Map session = context.getSession();
        Admin admin = (Admin) session.get("admin");
        if (admin != null) {
            return actionInvocation.invoke();
        }
        System.out.println("管理员未登录，转到登录页面...");
        context.put("login", "您还没有登录");
        return Action.LOGIN;
    }
}
