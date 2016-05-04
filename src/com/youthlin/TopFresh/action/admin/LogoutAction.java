package com.youthlin.TopFresh.action.admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;

/**
 * Created by lin on 2016-05-04-004.
 * 管理员退出登录
 * 登出后从会话中移除Admin
 */
public class LogoutAction extends ActionSupport {
    public String execute() {
        ActionContext.getContext().getSession().remove("admin");
        return SUCCESS;
    }
}
