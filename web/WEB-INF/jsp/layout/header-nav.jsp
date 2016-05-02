<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2016-05-01-001
  Time: 15:55 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<tiles:useAttribute name="current-menu" id="menu"/>
<%
    String item = "Home";
    String index = pageContext.getRequest().getServletContext().getContextPath();
    if (menu != null)
        item = (String) menu;
    String curHome = "",
            curLogin = "",
            curRegister = "";
    switch (item) {
        case "Home":
            curHome = " class='active'";
            break;
        case "Login":
            curLogin = " class='active'";
            break;
        case "Register":
            curRegister = " class='active'";
            break;
    }
%>

<header class="header-bar">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li<%=curHome%>><a href="<%=index%>">首页</a></li>
                    <li<%=curLogin%>><a href="#">登录</a></li>
                    <li<%=curRegister%>><a href="#">注册</a></li>
                    <li><a href="#">购物车</a></li>
                    <li><a href="#">我的订单</a></li>
                    <li><a href="#">水果兑换码</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>
</header>