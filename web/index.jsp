<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2016-05-01-001
  Time: 15:18 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<s:form action="user">
    <s:textfield label="Name" name="user.userName"/>
    <s:textfield label="Password" name="user.userPassword"/>
    <s:submit/>
</s:form>
</body>
</html>
