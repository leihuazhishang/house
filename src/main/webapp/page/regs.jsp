<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0049)http://localhost:8080/HouseRent/page/register.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 用户注册</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script language="javascript" src="/admin/js/jquery-1.8.3.js"></script>
<script language="javascript">
  $(function () {
      $("#but1").click(function () {
          $.post("/frontUser/selectByUserName",{"name":$("#name").val()},function (result) {

              if(!result.result>0){
                  $("#han").html("用户名称可用").css("color","green");
              }else {
                  $("#han").html("用户名已存在").css("color","red");}
          },"json");

      })

      $("#codeButton").click(function () {

          $.post("/frontUser/getCode",{"smsMob":$("#smsMob").val()},function (data) {
              alert("hello");
              alert(data.result);
              if(data.result>0){
                  alert("请查收短语验证码！")
              }else{
                  alert("短信发送失败，请重新操作！")
              }
          },"json")

      })
  })
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新用户注册</DT>
  <DD class=past>填写个人信息</DD></DL>
<DIV class=box>
<FORM action="/frontUser/insert" method="post">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD colSpan=2 style="color: #ff230d">${speak}</TD></TR>
  <TR>
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD><INPUT class=text type=text name=name id="name"><span id="han"></span><input type="button" value="检查用户名是否存在" id="but1"> </TD></TR>
  <TR>
    <TD class=field>密　　码：</TD>
    <TD><INPUT class=text type=password name=password></TD></TR>
  <TR>
    <TD class=field>确认密码：</TD>
    <TD><INPUT class=text type=password name=repassword> </TD></TR>
  <TR>
    <TD class=field>电　　话：</TD>
    <TD><INPUT class=text type=text name=telephone id="smsMob"> </TD></TR>
  <TR>
    <TD class=field>用户年龄：</TD>
    <TD><INPUT class=text type=text name=age> </TD>
  </TR>
  <TR>
    <TD class=field>验证码：</TD>
    <TD><INPUT class=text type=text name="code" >
    <INPUT class=tex type=button id="codeButton" value="获取短信验证码" style="width: 65px"> </TD>
  </TR>
  </TBODY></TABLE>
<DIV class=buttons>
<INPUT  value=立即注册 type=submit>
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
