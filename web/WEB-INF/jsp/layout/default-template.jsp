<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2016-05-01-001
  Time: 15:52 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.min.js"></script>
    <sb:head/>
    <link href="${pageContext.request.contextPath}/static/css/style.css" type="text/css" rel="stylesheet" id="styles"/>
    <title><tiles:getAsString name="title" ignore="true"/></title>
    <tiles:insertAttribute name="head"/>
</head>
<body>
<div class="wrap" id="wrap">
    <tiles:useAttribute name="current-menu" id="menu" ignore="true"/>
    <tiles:insertAttribute name="header">
        <tiles:putAttribute name="current-menu" value="${menu}"/>
    </tiles:insertAttribute>
    <div class="container">
        <tiles:insertAttribute name="search"/>
        <tiles:insertAttribute name="content"/>
    </div>
    <div class="clear" id="end"></div>
</div><!--.wrap-->
<footer id="copyright">
    <tiles:insertAttribute name="footer"/>
</footer>
<tiles:insertAttribute name="sidebar"/>
</body>
</html>