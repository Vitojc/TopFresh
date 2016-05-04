package com.youthlin.TopFresh.service.impl;

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
//            System.out.println(a + ";" + admin);
            if (a.getAdminName().equals(admin.getAdminName())
                    && a.getAdminPassword().equals(admin.getAdminPassword()))
                return true;
        }
        return false;
    }
}
