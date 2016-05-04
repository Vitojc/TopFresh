package com.youthlin.TopFresh.action.admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.youthlin.TopFresh.po.Admin;
import com.youthlin.TopFresh.service.AdminService;

/**
 * Created by lin on 2016-05-04-004.
 * 管理员首页逻辑
 * 登录成功后将Admin写入会话
 */
public class LoginAction extends ActionSupport {
    private Admin admin;
    private AdminService adminService;

    @Override
    public String execute() {
        System.out.println("执行登录");
        ActionContext.getContext().getSession().remove("login-tip");
        if (getAdmin() != null && getAdminService().login(getAdmin())) {
            ActionContext.getContext().getSession().put("admin", getAdmin());
            System.out.println("登录成功");
            return SUCCESS;
        }
        System.out.println("登录失败");
        return LOGIN;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
}
