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
    <script type="text/javascript" src="js/users.js"></script>
</head>
<body>
//显示数据的表格
<table id="data"></table>




<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:ModifyBySelect()" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:DeleteByFruitName()" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        电话号：<input type="text" width="60" id="telephone">
        年龄范围：<input type="text" width="60" id="startAge">--<input type="text" width="60" id="endAge">
        <a id="btn" href="javascript:searchUser();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
    </div>
</div>

<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="ModiyDialogForm" method="post">
        <table>
            <tr>
                <td>用户名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" id="uname"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="password" id="password"/></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="age" id="age"/></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="telephone" id="phone"/></td>
            </tr>
            <tr>
                <td>身份:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="isadmin" id="isAdmin"/></td>
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
                <td>用户编号:</td>
                <td><input type="text" readonly class="easyui-validatebox" required
                           name="id" id="id"/></td>
            </tr>
            <tr>
                <td>用户名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" id="newsname"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="password" id="newpassword"/></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="age" id="newage"/></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="telephone" id="newphone"/></td>
            </tr>
            <tr>
                <td>身份:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="isadmin" id="newisAdmin"/></td>
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
