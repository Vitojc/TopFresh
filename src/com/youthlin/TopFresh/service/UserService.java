package com.youthlin.TopFresh.service;

import com.youthlin.TopFresh.po.User;

/**
 * Created by lin on 2016-05-03-003.
 * 用户服务
 */
public interface UserService {
    int addUser(User user);

    boolean login(String username, String password);
}
