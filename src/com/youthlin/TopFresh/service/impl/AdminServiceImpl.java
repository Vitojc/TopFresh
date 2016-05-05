package com.youthlin.TopFresh.service.impl;

import com.opensymphony.xwork2.ActionContext;
import com.youthlin.TopFresh.dao.AdminDao;
import com.youthlin.TopFresh.po.Admin;
import com.youthlin.TopFresh.service.AdminService;

import java.util.List;

/**
 * Created by lin on 2016-05-04-004.
 * 管理员服务的实现
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao;

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public boolean login(Admin admin) {
//        System.out.println(admin);
        if (admin == null) return false;
        List<Admin> list = adminDao.findAll(Admin.class);
        for (Admin a : list) {
            System.out.println(a + ";" + admin);
            if (a.getAdminName().equals(admin.getAdminName())
                    && a.getAdminPassword().equals(admin.getAdminPassword())) {
                ActionContext.getContext().getSession().put("admin", a);
                return true;
            }
        }
        ActionContext.getContext().getSession().put("login-tip", "用户名或密码错误");
        return false;
    }

    @Override
    public void logout() {
        ActionContext.getContext().getSession().remove("admin");
    }

    @Override
    public boolean changePassword(String name, String oldPass, String newPass) {//TODO
        if (name == null || oldPass == null || newPass == null || oldPass.length() != 32 || newPass.length() != 32) {
            ActionContext.getContext().getSession().put("change-password-tip", "参数错误");
            return false;
        }
        Admin sessionAdmin;
        try {
            sessionAdmin = (Admin) ActionContext.getContext().getSession().get("admin");
            System.out.println(sessionAdmin);
        } catch (ClassCastException e) {
            e.printStackTrace();
            ActionContext.getContext().getSession().put("change-password-tip", "未登录");
            return false;
        }
        if (sessionAdmin != null && sessionAdmin.getAdminName().equals(name)) {
            if (sessionAdmin.getAdminPassword().equals(oldPass)) {
                if (oldPass.equals(newPass)) {
                    ActionContext.getContext().getSession().put("change-password-tip", "密码一致，不需更改");
                    return false;
                }
                sessionAdmin.setAdminPassword(newPass);
                getAdminDao().update(sessionAdmin);
                ActionContext.getContext().getSession().put("change-password-tip", "更改密码成功");
                return true;
            }
            ActionContext.getContext().getSession().put("change-password-tip", "原密码错误");
            return false;
        }
        ActionContext.getContext().getSession().put("change-password-tip", "用户名不一致");
        return false;
    }
}
