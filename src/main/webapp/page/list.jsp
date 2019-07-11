<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>

<script language="JavaScript" src="../admin/js/jquery-1.8.3.js"> </script>

<script language="JavaScript" >
  $(function () {
      //加载
      $.post("/house/selectAllTDS",function (map) {
          var types=map.types;
          var districts=map.districts;

        for(var i=0;i<types.length;i++){
            var typeOption=$("<option value="+types[i].id+">"+types[i].name+"</option> ")
            $("#tid").append(typeOption);
        }
          for(var i=0;i<districts.length;i++){
              var districtOption=$("<option value="+districts[i].id+">"+districts[i].name+"</option> ")
              $("#did").append(districtOption);
          }
      },"json")

      $("#did").change(function () {
          var dvalue=$("#did").val();
          $.post("/house/selectAllByDistrictId",{"id":dvalue},function (data) {
              $("#sid>option").remove();//清空street选项
              for(var i=0;i<data.length;i++){
                  //创建一个dom节点
                  var option=$("<option value="+data[i].id+" >"+data[i].name+"</option>")
                  $("#sid").append(option);
              }
          },"json")


      })




    if(${houseCondition.sid!=null}){
        $("#sid").val(${houseCondition.sid})
    }
      if(${houseCondition.did!=null}){
          $("#did").val(${houseCondition.did})
      }

  })
  function goSelect(page) {
      $("#showPage").val(page);
      $("#form").submit();


  }

</script>


<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=navbar class=wrap>
  <form id=form method=post action=/house/selectByCondition>
    <!--页码-->
    <input type="hidden" id="showPage" value="1" name="page">

    标题：<INPUT class=text type=text name=title value="${houseCondition.title}">
    开始价格:<input type="text" name="startPrice" value="${houseCondition.startPrice}" size="10">结束价格:<input size="10" value="${houseCondition.endPrice}" type="text" name="endPrice">

    区域:<SELECT  id=did name=did >
    <OPTION selected value="">请选择</OPTION>

  </SELECT>


    街道: <SELECT id=sid name=sid>
    <OPTION selected  value="">请选择</OPTION>

  </SELECT>
    <br/>

    类型:<SELECT  name=tid id="tid" >
    <OPTION selected  value="">请选择</OPTION>

  </SELECT>

    面积:<SELECT id="flooa" name=flooa>
    <OPTION selected  value="">不限</OPTION>
    <OPTION value="0-40">40以下</OPTION>
    <OPTION value="41-80">41-80</OPTION>
    <OPTION value="81-500">81-500</OPTION>
  </SELECT>
    <script language="JavaScript">
        $("#flooa").val(${houseCondition.flooa});
    </script>

    <LABEL class=ui-blue><INPUT  value=搜索房屋 type=submit name=search></LABEL>

  </FORM></DIV>
<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>

<h:forEach items="${pageInfo.list}" var="t"  step="1" >
  <TR>
    <TD class=house-thumb><span><A href="/pass/selectByPrimaryKey?id=${t.id}" target="_blank"><img src="http://localhost:80/${t.path}" width="100" height="75" alt="${t.title}"></a></span></TD>
    <TD>
      <DL>
        <DT><A href="/pass/selectByPrimaryKey?id=${t.id}" target="_blank">${t.title}</A></DT>
        <DD>${t.dName}   ${t.sName},${t.floorage}平米<BR>联系方式：${t.contact} </DD></DL></TD>
    <TD class=house-type>${t.tName}</TD>
    <TD class=house-price><SPAN>${t.price}</SPAN>元/月</TD>
  </TR>
</h:forEach>




  <TR>无租房信息</TR></TBODY></TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="JavaScript:goSelect(1)">首页</A></LI>
  <LI><A href="JavaScript:goSelect(${pageInfo.prePage==0?1:pageInfo.prePage})">上一页</A></LI>
  <LI><A href="JavaScript:goSelect(${pageInfo.nextPage==0?1:pageInfo.pages})">下一页</A></LI>
  <LI><A href="JavaScript:goSelect(${pageInfo.pages})">末页</A></LI></UL><SPAN
class=total>${pageInfo.pageNum}/${pageInfo.pages}页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
