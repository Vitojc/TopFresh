package com.youthlin.TopFresh.service;

import com.youthlin.TopFresh.po.Admin;

/**
 * Created by lin on 2016-05-04-004.
 * 管理员服务
 */
public interface AdminService {
    boolean login(Admin admin);

    void logout();

    boolean changePassword(String name, String oldPass, String newPass);
}
