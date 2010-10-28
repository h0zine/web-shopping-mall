<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title><spring:message code="store.name"/></title>
</head>

<style type="text/css">
a:link   	{color: gray; text-decoration: none}
a:visited 	{color: gray; text-decoration: none}
a:hover 	{color: black; background-color: white; text-decoration: underline}

body {margin:0; padding:0; background:#BBBBBB;}

#category {text-align:left; padding-left:2px; font-size:16px; position: relative; top: 80px; left:10px; border-bottom: gray 2px solid; width:780px}
#content {text-align:left; padding-left:2px; font-size:16px; position: relative; top: 80px; left:10px; width:780px}
#footer {text-align:left; padding-left:2px; font-size:16px; position: relative; top: 80px; left:10px; border-top: gray 2px solid; width:780px}

</style>
<body>
<center>
<table width="800" height="1050" border="0" cellpadding="0" cellspacing="0"><tr>
<td width="1px" bgcolor="#888888"></td>
<td bgcolor="white" valign="top">
<div id="category">
<table width="770"><tr>
<td align="left">
	<a href="index.oz">HOME</a>
	<c:forEach items="${categoryList}" var="category">
		| <a href="category.oz?cid=<c:out value="${category.id }"/>"><c:out value="${category.name }"/></a> 
	</c:forEach>
	</td>
	<td align="right">
		<a href="cart.oz">Shopping Cart</a> | <a href="#">Invoice Status</a>
	</td>
</tr></table>
</div>
<div id="content">
일련번호: <c:out value="${notice.noticeId }"/><br>
등록일: <c:out value="${notice.regDate }"/><br>
내용:<c:out value="${notice.content }"/>



</div>

<div id="footer">
<a href="contactus.oz">contact us</a>,  <a href="aboutus.oz">about us</a>, ...
</div>


</td>
<td width="1px" bgcolor="#888888"></td>
</tr></table></center>
</body>
</html>