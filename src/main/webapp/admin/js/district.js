$(function () {
    $('#data').datagrid({
        url:'/district/selectAll',
        fitColumns: true,
        pagination: true,
        pageList: [3,5,6,8],
        pageSize:3,
        toolbar:"#ToolBar",
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'区域名称',width:100},
            {field:'han',title:'操作',width:100,align:'center',
                formatter: function(value,row,index){
                    //同步跳转 "<a href='delDistrict?id="+row.id+"'>删除</a>"
                    return "<a href='javascript:delSingle("+row.id+")'>删除</a> | <a href='javascript:OpenStreetDialog("+row.id+")'>查看街道信息</a>";
                }
            },
        ]]
    });


})

//删除单个区域
function delSingle(id){
    $.messager.confirm('确认提示框', '确认删除吗？', function(result){
        if (result){
            // 实现删除  发送异步请求实现删除
            //alert(id);
            //$.post("服务器地址",给服务器传参,回调函数,"json");
            //传参的格式: {"参数名称":值,"参数名称":值}

            $.post("/district/deleteByPrimaryKey",{"id":id},function(data){

                if(data.result>0){
                    $("#data").datagrid('reload'); //刷新
                    $.messager.alert('提示框','恭喜删除成功!');
                }
                else
                {
                    $.messager.alert('提示框','系统正在维护!');
                }
            },"json");
        }
    });
}
//设置添加url
function Add(){
    $("#AddDialog").dialog('open').dialog('setTitle',"添加数据");
}

function CloseDialog(obj){
    ResetValues();
    $("#"+obj).dialog('close');
}

function SaveDialog(){
    //表单异步提交添加
    $("#ModiyDialogForm").form('submit',{
        url:"/district/insert",

        success:function(result){
            var va=	$.parseJSON(result);
            if( va.result<0){
                $.messager.alert("系统提示","系统维护中，请稍后再试");
                return;
            }
            else{
                $.messager.alert("系统提示","保存成功");

                $("#AddDialog").dialog('close'); //关闭AddDialog
                $("#data").datagrid('reload'); //刷新
            }
        }
    });

}

//修改的url
function ModifyBySelect(){
    //获取选中的行
    var SelectRows = $("#data").datagrid('getSelections');
    if( 1 != SelectRows.length ){
        $.messager.alert("系统提示", "请选择一行要编辑的数据");
        return;
    }
    var SelectRow = SelectRows[0];
    //打开编辑对话框
    $("#upDialog").dialog('open').dialog('setTitle',"修改数据");
    //获得行对象的数据加载到表单中显示
    $("#upDialogForm").form('load',SelectRow);

}
//删除的代码
function DeleteByFruitName(){
    //获取选择行
    var SelectRows = $("#data").datagrid('getSelections');

    if( 0 == SelectRows.length ){
        $.messager.alert("系统提示", "请选择要删除的数据");
        return;
    }
    var SelectIndexArr = [];
    for( var i = 0 ; i < SelectRows.length; i++ ){
        SelectIndexArr.push(SelectRows[i].id);
    }
    var SelectIndexToString = SelectIndexArr.join(",");
    $.messager.confirm("系统提示", "你确定要删除<font color=red> " + SelectRows.length + " </font>条数据吗?", function(xo){
        if( xo ){
            $("#data").datagrid('reload');
            //支持多项删除
            //alert(SelectIndexToString);
            $.post("/district/deleteMore",{ids:SelectIndexToString},function(result){
                if( result.result>0 ){
                    $.messager.alert("系统提示", "你已成功删除 <font color=green> " + result.result + " </font>条数据!~");
                    $("#data").datagrid('reload');
                }
                else{
                    $.messager.alert("系统提示", "<font color=red>删除失败</font>");
                }
            },"json");
        }
    });
}
function UpdateDialog(){
    //表单异步提交
    $("#upDialogForm").form('submit',{
        url:"/district/updateByPrimaryKeySelective",

        success:function(result){
            var va=	$.parseJSON(result);
            if( va.result<0){
                $.messager.alert("系统提示","系统维护中，请稍后再试");
                return;
            }
            else{
                $.messager.alert("系统提示","修改成功");

                $("#upDialog").dialog('close'); //关闭
                $("#data").datagrid('reload'); //刷新
            }
        }
    });
}
function OpenStreetDialog(obj) {
         $("#streetDialog").dialog("open").dialog('setTitle',"街道信息");
         $('#streetData').datagrid({
        url: '/street/selectByDistrictId',
        fitColumns: true,
        pagination: true,
        pageList: [3,5,6,8],
        pageSize:3,
        queryParams: {//传参
            districtId: obj
        },
        columns:[[

            {field: 'id', title: '编号', width: 100, align: 'center'},
            {field: 'name', title: '街道名称', width: 100,align: 'center'},
            {field: 'districtId', title: '区域编号', width: 100, align: 'center'},

        ]]
    });
}