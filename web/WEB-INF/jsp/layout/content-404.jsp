<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2016-05-04-004
  Time: 12:02 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<div class="container">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xs-10 mycenter">
        <div class="panel panel-default">
            <div class="panel-heading"><h1 class="panel-title">404 Not Found</h1></div>
            <div class="panel-body">
                <blockquote>
                    <p>很抱歉，您请求的资源当前不可用,请检查网址</p>
                    <p><a href="${pageContext.request.contextPath}">返回网站首页</a></p>
                </blockquote>
            </div>
            <div class="panel-footer">
                &copy;&nbsp;<%=new SimpleDateFormat("YYYY").format(new Date())%>&nbsp;TopFresh&nbsp;领鲜
            </div>
        </div>
    </div>
</div>
