<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="date" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script language="JavaScript" src="../admin/js/jquery-1.8.3.js"></script>
<script language="JavaScript">
  $(function () {
      //获取区域的编号

      showStreet($("#district").val());

     $("#district").change(function () {

         var va= $(this).val();
         showStreet(va);
     })
  })

  function showStreet(obj) {
      $.post("/house/selectAllByDistrictId",{"id":obj},function (data) {
          $("#street>option").remove();//清空street选项
          for(var i=0;i<data.length;i++){
              //创建一个dom节点
              var option=$("<option value="+data[i].id+" >"+data[i].name+"</option>");
              $("#street").append(option);
          }
          $("#street").val(${houseExc.streetId});
      },"json")
  }

</script>


<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>房屋信息修改</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM id=add_action method=post name=add
action="/house/updateHouseDo" enctype="multipart/form-data">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=title class=text type=text name=title value="${houseExc.title}"> </TD></TR>
  <TR>
  <TR>
    <!--用户Id-->
    <TD><INPUT  class=text type=hidden name=oldPath value="${u}"> </TD></TR>
  <TR>
  <TR>
    <!--旧图片名-->
    <TD><INPUT  class=text type=hidden name=path value="${houseExc.path}"> </TD></TR>
  <TR>
  <TR>
    <!--房屋Id-->
    <TD><INPUT  class=text type=hidden name=id value="${houseExc.id}"> </TD></TR>
  <TR>

    <TD class=field>户　　型：</TD>
    <TD><SELECT  name=typeId>
      <h:forEach items="${types}" var="t">
        <OPTION value=${t.id} <h:if test="${t.id==houseExc.typeId}">selected="selected"</h:if>    >${t.name}</OPTION>
      </h:forEach>
    </SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=floorage class=text type=text name=floorage value="${houseExc.floorage}"></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=price class=text type=text name=price value="${houseExc.price}"> </TD></TR>
  <TR>
    <TD class=field>发布日期：</TD>
    <TD><INPUT class=pubdate type=date name=pubdate value="<date:formatDate value="${houseExc.pubdate}" pattern="yyyy-MM-dd"/>" ></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text name=dId  id="district">
            <option>请选择</option>
            <h:forEach items="${districts}" var="d">
              <OPTION  <h:if test="${houseExc.dId==d.id}" >selected="selected"</h:if>   value=${d.id}  >${d.name}</OPTION>
                     </h:forEach>
           </SELECT>
      街：<SELECT class=text name=streetId id="street">

        <OPTION >请选择</OPTION>

      </SELECT> </TD></TR>
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=contact value="${houseExc.contact}"> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description></TEXTAREA></TD>
  </TR>
  <TR>
    <TD class=field>上传图片：</TD>
    <TD><img src="http://localhost:80/${houseExc.path}" alt="房屋图片"  width="100">
    </TD>
  </TR>
  <TR>
    <TD  class=field>图片：</TD>
    <TD><input type="file" id="pictureName" name="pfile" />   </TD>
  </TR>




  </TBODY></TABLE>
<DIV class=buttons><INPUT  value=修改 type=submit>
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
