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
            <s:form theme="simple" id="type-delete-form" action="confirm">
                <script>
                    function selectAll() {//全选/全不选
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
                        $('input[name="checkList"]').prop('checked', flag);
                        //firefox中 checkbox属性checked="checked"已有，但复选框却不显示打钩的原因
                        //http://blog.sina.com.cn/s/blog_6657f20e0101g793.html
                        //attr换成prop
                        listCheck();
                    }
                    function listCheck() {//检查是否有选中的
                        var checklist = $('input[name="checkList"]');
                        $('.delete-button').attr("disabled", !checklist.is(":checked"));
                    }
                    jQuery(document).ready(function ($) {
                        $('#delete-confirm').on('show.bs.modal', function (e) {
                            var form = $('#type-delete-form');
                            $.ajax({
                                url: form.attr('action'),
                                dataType: 'json',
                                data: form.serialize(),
                                success: function (r) {
                                    console.log(r);
                                }
                            });
                        })
                    });
                </script>
                <style scoped>.checkbox-label {
                    display: flex;
                }</style>
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <s:if test="productTypeList.size() > 0">
                            <thead>
                            <tr>
                                <td style="width: 60px;">操作：</td>
                                <td>
                                    <button class="btn btn-xs btn-danger delete-button" type="button"
                                            disabled data-toggle="modal" data-target="#delete-confirm">删除
                                    </button>
                                </td>
                                <td colspan="2">当该类别下有商品时，不能删除类别。删除父类别时，会删除所有子类别。</td>
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
                                <th>数量</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <td>
                                    <label class="checkbox-label">
                                        <input type="checkbox" class="select-all" onchange="selectAll()">
                                        <span class="sr-only">全选</span>
                                    </label>
                                </td>
                                <th>序号</th>
                                <th>名称</th>
                                <th>层级</th>
                                <th>数量</th>
                            </tr>
                            <tr>
                                <td>操作：</td>
                                <td>
                                    <button class="btn btn-xs btn-danger delete-button" type="button"
                                            disabled data-toggle="modal" data-target="#delete-confirm">删除
                                    </button>
                                </td>
                                <td colspan="2">当该类别下有商品时，不能删除类别。删除父类别时，会删除所有子类别。</td>
                            </tr>
                            </tfoot>
                            <tbody>
                            <s:set var="count" value="0"/>
                            <s:iterator var="it" value="productTypeList">
                                <s:set value="typeProductSet.size()" var="numOfType"/>
                                <tr>
                                    <td>
                                        <s:if test="typeProductSet.size()==0"><label class="checkbox-label">
                                            <input type="checkbox" name="checkList" id="check-list"
                                                   onchange="listCheck()" value="<s:property value="typeId"/>"/>
                                            <span class="sr-only">勾选/取消勾选</span></label>
                                        </s:if>
                                        <s:else><label class="checkbox-label" title="不能删除该类别">
                                            <input type="checkbox" disabled readonly/>
                                            <span class="sr-only">不能删除该类别</span></label>
                                        </s:else>

                                    </td>
                                    <td>
                                        <span data-id='<s:property value="typeId"/>'>
                                            <s:set var="count" value="#count+1"/>${count}</span>
                                    </td>
                                    <td><s:property value="typeName"/></td>
                                    <td><s:property value="typeLevel"/></td>
                                    <td>${numOfType}</td>
                                </tr>
                            </s:iterator>
                            </tbody>
                        </s:if>
                        <s:else>
                            请先添加类别
                        </s:else>
                    </table>
                    <nav class="pagination form-inline" style="display: block;width: 192px;margin: 0 auto;">
                        <s:property escapeHtml="false" value="pagination"/>
                    </nav>
                </div>
            </s:form>
            <!-- Modal -->
            <div class="modal fade" id="delete-confirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">确认删除</h4>
                        </div>
                        <div class="modal-body">
                            <span id="loading">加载中...</span>

                            <div class="table-responsive">
                                <table class="table table-striped table-hover" id="delete-table">

                                </table>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-default">确定删除</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div role="tabpanel" class="tab-pane" id="type-add">
            添加
        </div>
    </div>
</div>