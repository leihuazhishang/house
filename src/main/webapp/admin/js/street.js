$(function () {
    $('#dg').datagrid({
        url: '/street/selectAll',
        fitColumns: true,
        pagination: true,
        pageList: [3,5,6,8],
        pageSize:3,
        toolbar:"#ToolBar",
        columns: [[
            {field: 'bh',checkbox:true},
            {field: 'id', title: '编号', width: 100},
            {field: 'name', title: '街道名称', width: 100},
            {field: 'districtId', title: '区域编号', width: 100, align: 'center'},
            {
                field: 'lu', title: '操作', width: 100, align: 'center',
                formatter: function (value, row, index) {
                    return "<a href='javascript:delSingle(" + row.id + ")'>删除</a>";
                }
            }
        ]]
    });

})


function Add(){
    $("#AddDialog").dialog('open').dialog('setTitle',"添加数据");
    $.post("/district/selectAllDistrict",function(data){
        for (var i = 0; i < data.length; i++) {
            var option1=$("<option name='districtId' value='"+data[i].id+"'>"+data[i].name+"</option> ");
            $("#select1").append(option1);
        }
        },"json");//查询所有区域

}

function CloseDialog(obj){

    $("#"+obj).dialog('close');
}

function SaveDialog(){
    //表单异步提交添加
    $("#ModiyDialogForm").form('submit',{
        url:"/street/insert",
        success:function(result){
            var va=	$.parseJSON(result);
            if( va.result<0){
                $.messager.alert("系统提示","系统维护中，请稍后再试");
                return;
            }
            else{
                $.messager.alert("系统提示","保存成功");

                $("#AddDialog").dialog('close'); //关闭AddDialog
                $("#dg").datagrid('reload'); //刷新
            }
        }
    });
}
//修改的url
function ModifyBySelect(){
    //获取选中的行
    var SelectRows = $("#dg").datagrid('getSelections');
    if( 1 != SelectRows.length ){
        $.messager.alert("系统提示", "请选择一行要修改的数据");
        return;
    }
    var SelectRow = SelectRows[0];
    //打开编辑对话框
    $("#upDialog").dialog('open').dialog('setTitle',"修改数据");
    //获得行对象的数据加载到表单中显示
    $("#upDialogForm").form('load',SelectRow);

}
//删除单个区域
function delSingle(id){
    $.messager.confirm('确认提示框', '确认删除吗？', function(result){
        if (result){

            // 实现删除  发送异步请求实现删除
            //alert(id);
            //$.post("服务器地址",给服务器传参,回调函数,"json");
            //传参的格式: {"参数名称":值,"参数名称":值}

            $.post("/street/deleteByPrimaryKey",{"id":id},function(result){

                if(result.result>0){
                    $("#dg").datagrid('reload'); //刷新
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

function UpdateDialog(){
    //表单异步提交
    $("#upDialogForm").form('submit',{
        url:"/street/updateByPrimaryKeySelective",

        success:function(result){
            var va=	$.parseJSON(result);
            if( va.result<0){
                $.messager.alert("系统提示","系统维护中，请稍后再试");
                return;
            }
            else{
                $.messager.alert("系统提示","修改成功");

                $("#upDialog").dialog('close'); //关闭
                $("#dg").datagrid('reload'); //刷新
            }
        }
    });
}

//删除多条的代码
function DeleteByFruitName(){
    //获取选择行
    var SelectRows = $("#dg").datagrid('getSelections');

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
            $.post("/street/deleteMore",{ids:SelectIndexToString},function(result){
                if( result.result>0 ){
                    $.messager.alert("系统提示", "你已成功删除 <font color=green> " + result.result + " </font>条数据!~");
                    $("#dg").datagrid('reload');
                }
                else{
                    $.messager.alert("系统提示", "<font color=red>删除失败</font>");
                }
            },"json");
        }
    });
}
