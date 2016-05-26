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
            <s:form theme="simple" id="type-delete-form">
                <div class="table-responsive">
                    <script>
                        function selectAll() {
                            var flag = true;
                            var selectAll = $('#select-all-flag');
                            if (selectAll.val() == 0) {
                                flag = true;
                                selectAll.val(1);
                            }
                            else {
                                flag = false;
                                selectAll.val(0);
                            }
                            //console.log(flag + " ");
                            $('.select-all').prop('checked', flag);
                            $('input[name="check-list"]').prop('checked', flag);
                            //firefox中 checkbox属性checked="checked"已有，但复选框却不显示打钩的原因
                            //http://blog.sina.com.cn/s/blog_6657f20e0101g793.html
                            //attr换成prop
                        }
                    </script>
                    <table class="table table-striped table-hover">
                        <style>.checkbox-label {
                            display: flex;
                        }</style>
                        <s:if test="productTypeList.size() > 0">
                            <thead>
                            <tr>
                                <td>操作：</td>
                                <td>删除</td>
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td>
                                    <label class="checkbox-label">
                                        <input type="checkbox" class="select-all" onchange="selectAll()">
                                        <span class="sr-only">全选</span>
                                    </label>
                                    <input type="hidden" id="select-all-flag" value="0">
                                </td>
                                <th>序号</th>
                                <th>名称</th>
                                <th>层级</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <s:url var="first"> <s:param name="pageNo" value="1"/> </s:url>
                            <s:url var="prev"> <s:param name="pageNo" value="pageNo-1"/> </s:url>
                            <s:url var="next"> <s:param name="pageNo" value="pageNo+1"/> </s:url>
                            <s:url var="last"> <s:param name="pageNo" value="lastPageNo"/> </s:url>
                            <tr>
                                <td>操作：</td>
                                <td>删除</td>
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td colspan="2" align="center">
                                    <nav>
                                        <ul class="pagination">
                                            <s:property escapeHtml="false" value="pagination"/>
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
                                        <label class="checkbox-label">
                                            <input type="checkbox" name="check-list" id="check-list"
                                                   data-id='<s:property value="typeId"/>'>
                                            <span class="sr-only">勾选/取消勾选</span>
                                        </label>
                                    </td>
                                    <td>
                                        <span data-id='<s:property value="typeId"/>'><s:set var="count"
                                                                                            value="#count+1"/>${count} </span>
                                    </td>
                                    <td><s:property value="typeName"/></td>
                                    <td><s:property value="typeLevel"/></td>
                                </tr>
                            </s:iterator>
                            </tbody>
                        </s:if>
                        <s:else>
                            请先添加类别
                        </s:else>
                    </table>
                </div>
            </s:form>
        </div>
        <div role="tabpanel" class="tab-pane" id="type-add">
            添加
        </div>
    </div>

</div>