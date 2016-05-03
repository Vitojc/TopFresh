package com.youthlin.TopFresh.service.impl;

import com.youthlin.TopFresh.dao.UserDao;
import com.youthlin.TopFresh.po.User;
import com.youthlin.TopFresh.service.UserService;

/**
 * Created by lin on 2016-05-03-003.
 * 用户操作
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int addUser(User user) {
        return (int) userDao.save(user);
    }

    //TODO 实现登录逻辑
    @Override
    public boolean login(String username, String password) {
        return false;
    }
}
