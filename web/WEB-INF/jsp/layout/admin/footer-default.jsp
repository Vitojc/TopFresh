<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2016-05-04-004
  Time: 11:33 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<p>TopFresh 领鲜 最新鲜的水果在线预定！</p>
<p>&copy; <%=new SimpleDateFormat("YYYY").format(new Date())%>&nbsp;<a href="<s:url value="/"/>">领鲜</a> | <a
        href="<s:url value="/"/>">免备案12345678号</a> | 技术支持：<a href="http://youthlin.com/">Youth．霖</a></p>
