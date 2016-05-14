package com.youthlin.TopFresh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.youthlin.TopFresh.po.User;
import com.youthlin.TopFresh.service.UserService;

import java.io.InputStream;

/**
 * Created by lin on 2016-05-03-003.
 * 关于用户的操作
 */
public class UserAction extends ActionSupport {
    private User user;
    private UserService userService;
    private InputStream inputStream;

    public String add() {
        int result = getUserService().addUser(getUser());
        if (result > 0) {
            addActionMessage("添加用户成功");
            return SUCCESS;
        }
        addActionError("添加用户失败");
        return ERROR;
    }

    public String login() {
        boolean loginSuccess = getUserService().login(getUser().getUserName(), getUser().getUserPassword());
        if (loginSuccess) {
            addActionMessage("用户登录成功");
            return SUCCESS;
        }
        addActionError("用户登录失败");
        return LOGIN;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
