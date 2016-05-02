<%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2016-05-01-001
  Time: 15:55 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="logo-search">
    <div id="logo"><img src="<s:url value="/static/img/logo.png"/>" alt="Logo" width="50"></div>
    <div id="search">
        <form id="search-form" class="form" role="search">
            <div class="input-group">
                <input type="text" class="form-control" name="words" placeholder="搜索" autofocus>
                <a href="#" type="submit" class="btn btn-default input-group-addon">搜索</a>
            </div>
        </form>
    </div>
</div>
