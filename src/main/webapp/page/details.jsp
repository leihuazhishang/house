<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<BODY>

<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>
<DIV class=search>
  <DIV class=search>欢迎你：${user.name}
    <LABEL class="ui-green searchs"><a href="/house/publish" title="">发布房屋信息</a></LABEL>
    <%-- <LABEL class="ui-green searchs"><a href="/house/selectAllHouseExcByUserId" title="">管理房屋信息</a></LABEL>--%>
    <LABEL class="ui-green searchs"><a href="/house/outSystem">退 出</a></LABEL>
  </DIV></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  </DL></DIV>
<DIV id=position class=wrap>当前位置：青鸟租房网 - 浏览房源</DIV>
<DIV id=view class="main wrap">
<DIV class=intro>
<DIV class=lefter>
<H1>${houseExc.title}</H1>
  <DIV class=subinfo>2013-06-28 14:06:33.0</DIV>
<table  width="800" >

    <tr >

      <td width="300"><P>户　　型：<SPAN>${houseExc.tName}</SPAN></P></td>
      <td rowspan="4">
        <img src="http://localhost:80/${houseExc.path}" width="200" alt="${houseExc.title}">
      </td>
      <td rowspan="4">
        <DIV class=side>
          <P><A class=bold href="https://www.baidu.com">北京青鸟房地产经纪公司</A></P>
          <P>资质证书：有</P>
          <P>内部编号:1000</P>
          <P>联 系 人：${houseExc.uName}</P>
          <P>联系电话：${houseExc.contact}<SPAN></SPAN></P>
          <P>手机号码：无<SPAN>暂无</SPAN></P></DIV>
      </td>
    </tr>
    <tr><td><P>面　　积：<SPAN>${houseExc.floorage}m<SUP>2</SUP></SPAN></P></td></tr>
    <tr><td><P>位　　置：<SPAN>${houseExc.dName}(区)${houseExc.sName}</SPAN></P></td></tr>
    <tr><td><DIV class=houseinfo><P>联系方式：<SPAN>${houseExc.contact}</SPAN></P></DIV></td></tr>
</table>

<DIV class=clear></DIV>
<DIV class=introduction>
<H2><SPAN><STRONG>房源详细信息</STRONG></SPAN></H2>
<DIV class=content>
<P>就是好</P></DIV></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV>
</BODY>
</HTML>
