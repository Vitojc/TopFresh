<%@ page import="com.youthlin.TopFresh.po.Admin" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2016-05-04-004
  Time: 22:36 下午
  To change this template use File | Settings | File Templates.
  管理员个人信息页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<script>function addMyClass() {
    $('#admin-nav-me').addClass('active');
}
jQuery(document).ready(function ($) {
    $('#admin-change-password-form').submit(function () {
        var o = $.md5("TopFresh$" + $('#name').val() + "$" + $('#oldPasswordPlain').val() + "$霖");
        var n = $.md5("TopFresh$" + $('#name').val() + "$" + $('#newPasswordPlain').val() + "$霖");
        $('#oldPassword').val(o);
        $('#newPassword').val(n);
        return true;
    });
});
</script>
<s:form action="changePassword" theme="simple" id="admin-change-password-form" cssClass="well form-horizontal">
    <h4 class="col-sm-offset-1">修改登录密码</h4>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div id="tip" class="text-danger">${pageContext.session.getAttribute("change-password-tip")}&nbsp;</div>
        </div>
    </div>
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">用户名</label>
        <%
            Admin admin = ((Admin) session.getAttribute("admin"));
            String name = "";
            if (admin != null)
                name = admin.getAdminName();
        %>
        <div class="col-sm-10">
            <p class="form-control-static"><%=name%>
            </p>
            <input type="hidden" id="name" name="username" class="form-control" disabled readonly value="<%=name%>"/>
        </div>
    </div>
    <div class="form-group">
        <label for="oldPasswordPlain" class="col-sm-2 control-label">原密码</label>
        <div class="col-sm-10"><input type="password" id="oldPasswordPlain" class="form-control" required></div>
        <s:hidden name="password" id="oldPassword"/>
    </div>
    <div class="form-group">
        <label for="newPasswordPlain" class="col-sm-2 control-label">新密码</label>
        <div class="col-sm-10"><input type="password" id="newPasswordPlain" class="form-control" required></div>
        <s:hidden name="newPassword" id="newPassword"/>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">更改</button>
        </div>
    </div>
</s:form>