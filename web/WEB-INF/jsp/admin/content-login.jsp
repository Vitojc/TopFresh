<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2016-05-04-004
  Time: 12:00 下午
  To change this template use File | Settings | File Templates.
  管理员登录页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<div class="container">
    <style scoped>
        html {
            height: 100%;
        }

        body {
            height: 100%;
            background-image: url("http://cn.bing.com/ImageResolution.aspx?w=1920&h=1200");
            background-repeat: no-repeat;
            background-size: cover;
        }

        #login {
            background: rgba(255, 255, 255, .6);
            padding-bottom: 2%;
        }

        #login .input-group {
            margin: 2% auto;
        }

        #copyright {
            background-color: rgba(255, 255, 255, .5);
        }
    </style>
    <div class="col-lg-4 col-md-6 col-sm-8 col-xs-10 mycenter" id="login">
        <s:form action="login" theme="simple">
            <h2>登录</h2>
            <div class="input-group">
                <label for="username" class="input-group-addon">账号</label>
                <s:textfield id="username" class="form-control" required="true" autofocus="autofocus"
                             placeholder="管理员用户名" name="admin.adminName" label="UserName"/>
            </div>
            <div class="input-group">
                <label for="password" class="input-group-addon">密码</label>
                    <%--<s:hidden name="admin.adminPassword" id="password"/>--%>
                <s:password name="admin.adminPassword" class="form-control"
                            placeholder="管理员密码" required="true" id="password"/>
            </div>
            <div class="text-danger" id="tip">&nbsp;</div>
            <s:submit cssClass="btn btn-lg btn-primary btn-block" value="登录" id="admin-login-form-submit"/>
        </s:form>
        <!--[if lt IE 9]>
        <script>
            var login_u = document.getElementById('username');
            var login_p = document.getElementById("passwordPlain");
            var login_s = document.getElementById("admin-login-form-submit");
            login_u.disabled = true;
            login_p.disabled = true;
            login_s.disabled = true;
        </script>
        <![endif]-->
    </div>
</div>
<!-- .container -->