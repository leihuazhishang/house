<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   //判断用户是否登录
  Object user=   session.getAttribute("user");
  if(user==null){
      out.print("<script>alert('你还没有登入，请登录');location.href='login.jsp';</script>");
  }

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>青鸟租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">

<META name=GENERATOR >
</HEAD>

<script language="JavaScript" src="../admin/js/jquery-1.8.3.js"></script>

<script language="JavaScript">
    function delHouse(obj,id) {

        var delNode=$(obj).parent().parent().parent();

        $.post("/pass/deleteByIsdel",{"id":id},function (result) {

            if(result.result>0){
                delNode.remove();

            }
        },"json");
    }



</script>

<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>
<DIV class=search>欢迎你：${user.name}
  <LABEL class="ui-green searchs"><a href="/house/publish" title="">发布房屋信息</a></LABEL>
  <LABEL class="ui-green searchs"><a href="/house/selectAllTDS" title="">浏览房屋信息</a></LABEL>
<LABEL class="ui-green searchs"><a href="/house/outSystem">退 出</a></LABEL>
</DIV></DIV>
<DIV class="main wrap">
<DIV id=houseArea>

<TABLE calss=house-list>
  <TBODY>
  <h:forEach items="${pageInfo.list}"  var="t" >
      <TR class=odd>
    <TD class=house-thumb><SPAN><A href="/pass/selectByPrimaryKey?id=${t.id}" ><img src="http://localhost:80/${t.path}" width="100" height="75" alt=""></A></SPAN></TD>
    <TD>
      <DL>
        <DT><A href="/pass/selectByPrimaryKey?id=${t.id}" target="_blank">${t.title}</A></DT>
        <DD>${t.dName} ${t.sName},${t.floorage}平米,${t.tName}<BR>联系方式:${t.contact} </DD></DL></TD>
    <TD class=house-type><LABEL class="ui-green searchs"><a href="/house/updateHouse?id=${t.id}" title="">修 改</a></LABEL></TD>
    <TD class=house-price><LABEL class=ui-green><INPUT onclick="delHouse(this,${t.id})"    value="删    除" type=button name=search></LABEL></TD>
  </TR>
 </h:forEach>
  </TBODY>
</TABLE>


</DIV>
    <DIV class=pager>
<UL>
    <h:forEach begin="1" end="${pageInfo.pages}" step="1" var="i">
  <LI class=current><A id=widget_338868862 
  href="/house/selectAllHouseExcByUserId?page=${i}"
  parseContent="true" showError="true" targets="houseArea" 
  ajaxAfterValidation="false" validate="false" 
dojoType="struts:BindAnchor">${i}</A>
   </LI>
    </h:forEach>
</UL><SPAN class=total>${pageInfo.pageNum}/${pageInfo.pages}页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
