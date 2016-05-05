<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2016-05-04-004
  Time: 11:27 上午
  To change this template use File | Settings | File Templates.
  管理员页面的模板，包含head、header、content、footer；另有title属性(页面标题)current-menu(当前header的active项)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <tiles:insertAttribute name="head"/>
    <title><tiles:getAsString name="title" ignore="true"/></title>
</head>
<body>
<div class="wrap" id="wrap">
    <tiles:insertAttribute name="header"/>
    <div class="container">
        <tiles:insertAttribute name="content"/>
    </div>
    <div class="clear" id="end"></div>
</div>
<footer id="copyright">
    <tiles:insertAttribute name="footer"/>
</footer>
</body>
</html>
