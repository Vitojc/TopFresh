<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2016-05-04-004
  Time: 22:35 下午
  To change this template use File | Settings | File Templates.
  类别管理页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<script>function addMyClass() {
    $('#admin-nav-type').addClass('active');
}</script>
<div>
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active">
            <a href="#type-all" aria-controls="type-all" role="tab" data-toggle="tab">所有类别</a></li>
        <li role="presentation">
            <a href="#type-add" aria-controls="type-add" role="tab" data-toggle="tab">添加类别</a></li>
    </ul>
    <div class="tab-content container">
        <div role="tabpanel" class="tab-pane active" id="type-all">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <s:if test="productTypeList.size() > 0">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>名称</th>
                            <th>层级</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <s:url var="first"> <s:param name="pageNo" value="1"/> </s:url>
                        <s:url var="prev"> <s:param name="pageNo" value="pageNo-1"/> </s:url>
                        <s:url var="next"> <s:param name="pageNo" value="pageNo+1"/> </s:url>
                        <s:url var="last"> <s:param name="pageNo" value="lastPageNo"/> </s:url>
                        <tr>
                            <td></td>
                            <td colspan="2" align="center">
                                <nav>
                                    <ul class="pagination">
                                        <s:if test="pageNo eq 1">
                                            <li class="disabled"><span aria-hidden="true">&laquo;<span class="sr-only">(上一页)</span></span>
                                            </li>
                                        </s:if>
                                        <s:elseif test="pageNo > 1">
                                            <li><a href="${prev}" title="上一页">&laquo;<span class="sr-only">(上一页)</span></a>
                                            </li>
                                            <li><a href="${first}">1</a></li>
                                        </s:elseif>
                                        <s:else>
                                            <li class="disabled"><span aria-hidden="true">&laquo;<span class="sr-only">(上一页)</span></span>
                                            </li>
                                            <li><span aria-hidden="true">1</span></li>
                                        </s:else>

                                        <s:if test="pageNo >= 1">
                                            <s:if test="pageNo-1 > 1">
                                                <s:if test="pageNo -2 > 1">
                                                    <li class="disabled"><span>...</span></li>
                                                </s:if>
                                                <li><a href="${prev}"><s:property value="pageNo-1"/></a></li>
                                            </s:if>
                                            <s:if test="pageNo < lastPageNo">
                                                <li class="active">
                                                    <span><s:property value="pageNo"/><span
                                                            class="sr-only">(current)</span></span>
                                                </li>
                                                <s:if test="pageNo+1 < lastPageNo">
                                                    <li><a href="${next}"><s:property value="pageNo+1"/></a></li>
                                                    <s:if test="pageNo+2 < lastPageNo">
                                                        <li class="disabled"><span>...</span></li>
                                                    </s:if>
                                                </s:if>
                                            </s:if>
                                        </s:if>

                                        <s:if test="pageNo < lastPageNo">
                                            <li><a href="${last}"><s:property value="lastPageNo"/></a></li>
                                            <li><a href="${next}" title="下一页">&raquo;<span class="sr-only">(下一页)</span></a>
                                            </li>
                                        </s:if>
                                        <s:elseif test="pageNo eq lastPageNo">
                                            <li class="active"><span><s:property value="lastPageNo"/><span
                                                    class="sr-only">(current)</span></span></li>
                                            <li class="disabled"><span aria-hidden="true">&raquo;<span class="sr-only">(下一页)</span></span>
                                            </li>
                                        </s:elseif>
                                        <s:else>
                                            <li><span aria-hidden="true"><s:property value="lastPageNo"/></span></li>
                                            <li class="disabled"><span aria-hidden="true">&raquo;<span class="sr-only">(下一页)</span></span>
                                            </li>
                                        </s:else>
                                    </ul>
                                </nav>
                            </td>
                            <td></td>
                        </tr>
                        </tfoot>
                        <tbody>
                        <s:set var="count" value="0"/>
                        <s:iterator var="it" value="productTypeList">
                            <tr>
                                <td>
                                    <span data-id='<s:property value="typeId"/>'><s:set var="count" value="#count+1"/>${count} </span>
                                </td>
                                <td><s:property value="typeName"/></td>
                                <td><s:property value="typeLevel"/></td>
                                <td></td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </s:if>
                    <s:else>
                        请先添加类别
                    </s:else>
                </table>
            </div>
        </div>
        <div role="tabpanel" class="tab-pane" id="type-add">
            添加
        </div>
    </div>

</div>