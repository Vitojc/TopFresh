package com.youthlin.TopFresh.action.admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.youthlin.TopFresh.po.Admin;
import com.youthlin.TopFresh.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * Created by lin on 2016-05-04-004.
 * 管理员首页逻辑
 * 登录成功后将Admin写入会话
 */
public class AdminAction extends ActionSupport {
    private AdminService adminService;
    private String username;
    private String password;
    private String newPassword;
    static final Logger LOG = LoggerFactory.getLogger(AdminAction.class);

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String login() throws UnsupportedEncodingException {
        System.out.println("执行登录");
        ActionContext.getContext().getSession().put("login-tip", "");
        if (getUsername() == null || getPassword() == null) {
            return LOGIN;
        }
        Admin admin = new Admin(getUsername(), getPassword());
        if (getAdminService().login(admin)) {
            System.out.println("登录成功");
            return SUCCESS;
        }
        System.out.println("登录失败");
        return LOGIN;
    }

    public String logout() {
        System.out.println("执行登出");
        ActionContext.getContext().getSession().put("login-tip", "");
        getAdminService().logout();
        username = null;
        password = null;
        return SUCCESS;
    }

    public String myInfo() {
        LOG.trace("Hello World!");
        LOG.debug("How are you today?");
        LOG.info("I am fine.");
        LOG.warn("I love programming.");
        LOG.error("I am programming.");
        ActionContext.getContext().getSession().put("change-password-tip", "");
        return SUCCESS;
    }

    public String changePassword() {
        System.out.println("执行修改密码");
        ActionContext.getContext().getSession().put("change-password-tip", "");
        getAdminService().changePassword(getUsername(), getPassword(), getNewPassword());
        return SUCCESS;
    }


    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

}
