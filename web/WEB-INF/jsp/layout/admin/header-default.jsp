<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2016-05-04-004
  Time: 11:31 上午
  To change this template use File | Settings | File Templates.
  管理员页面的header导航。包含：
  管理首页：网站概况
  类别管理：水果的类别管理
  水果管理：水果的增删改查
  图片管理：媒体库的增删改查
  个人信息：管理员的用户名密码、新增管理员
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<tiles:useAttribute name="current-menu" id="menu"/>
<%
    String item = "Home";
    String index = pageContext.getRequest().getServletContext().getContextPath();
    if (menu != null)
        item = (String) menu;
    String curHome = "";
    switch (item) {
        case "Home":
            curHome = " class='active'";
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
                <a href="<%=index%>" class="navbar-brand">网站首页</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li<%=curHome%>><a href="<%=index%>/admin/index.action">管理首页</a></li>
                    <li><a href="<%=index%>/admin/logout.action">退出</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>
</header>
