<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/6/18
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Street</title>
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/houseFalse.js"></script>
</head>
<body>

<table id="dg"></table>




<div id="ToolBar">
    <div style="height: 40px;">
        <%--<a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:ModifyBySelect()" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a>--%>
        <a href="javascript:PassByFruitName()" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true">批量审核</a>
    </div>
</div>

<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="ModiyDialogForm" method="post">
        <table>
            <tr>
            <td>类型名称:</td>
            <td><input type="text" class="easyui-validatebox" required
                       name="name" id="dname" /></td>
        </tr>
        </table>
    </form>
</div>

<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog('AddDialog')"
       class="easyui-linkbutton"
       iconCls="icon-cancel">取消</a>
</div>



<div id="upDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="upDialogForm" method="post">
        <table>
            <tr>
                <td>类型编号:</td>
                <td><input type="text" readonly class="easyui-validatebox" required
                           name="id" id="uid" /></td>
            </tr>
            <tr>
                <td>类型名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" id="name" /></td>
            </tr>

        </table>
    </form>
</div>

<div id="upDialogButtons">
    <a href="javascript:UpdateDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">修改</a>
    <a href="javascript:CloseDialog('upDialog')"
       class="easyui-linkbutton"
       iconCls="icon-cancel">取消</a>
</div>







</body>
</html>
