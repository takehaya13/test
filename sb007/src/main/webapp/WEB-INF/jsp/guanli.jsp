<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>布谷租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">

<META name=GENERATOR ></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>
<DIV class=search><LABEL class="ui-green searchs"><a href="../../fabu.jsp" title="">发布房屋信息</a></LABEL>
<LABEL class="ui-green searchs"><a href="/house/search" title="">浏览</a></LABEL>
<LABEL class=ui-green><INPUT onclick='document.location="/user/login"' value="退       出" type=button name=search></LABEL>
</DIV></DIV>
<DIV class="main wrap">
  <input type="hidden" id="hpageNum" name="pageNum">
<DIV id=houseArea>
<TABLE class=house-list>
  <TBODY>

<c:forEach items="${pageInfo.list}" var="house">
  <TR>
    <TD class=house-thumb><SPAN><A href="/house/details?Hid=${house.HId}"  target="_blank"><img src="/house/images?imgName=${house.HImg}" width="100" height="75" alt=""></A></SPAN></TD>
    <TD>
      <DL>
        <DT><A href="/house/details?Hid=${house.HId}"  target="_blank">${house.HName}</A></DT>
        <DD>${house.HLoc1}${house.HLoc2},${house.HRect}<BR>联系方式：123 </DD></DL></TD>

    <TD class=house-type><LABEL class=ui-green><INPUT onclick="update(${house.HId})" value="修    改" type=button name=search></LABEL></TD>
    <TD class=house-price><LABEL class=ui-green><INPUT onclick="delect(${house.HId})" value="删    除" type=button name=search></LABEL></TD>
  </TR>
</c:forEach>
  </TBODY>
</TABLE>
</DIV>
<script>
  function delect(hid) {
    location.href="/house/delect?hid="+hid;

  }
  function update(hid) {
    location.href="/house/updateGl?hid="+hid;
  }
</script>

<DIV class=pager>
<UL>
<c:forEach var="pageNumber" begin="1" end="${pageInfo.pages}">

  <LI class=current>
    <A href="?pageNum=${pageNumber}"
          parseContent="true" showError="true" targets="houseArea"
          ajaxAfterValidation="false" validate="false"
          dojoType="struts:BindAnchor">${pageNumber}</A>
   </LI>
</c:forEach>
</UL>
  <SPAN class=total>${pageInfo.pageNum}/${pageInfo.pages}页</SPAN> </DIV></DIV>

<DIV id=footer class=wrap>

<DL>
  <DT>布谷租房 © 2010 布谷租房 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
