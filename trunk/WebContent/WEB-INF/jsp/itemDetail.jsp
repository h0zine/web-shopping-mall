<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>    
<html>
<head>
<title><spring:message code="store.name"/> - 상품정보</title>
</head>
<style type="text/css">
a:link   	{color: gray; text-decoration: none}
a:visited 	{color: gray; text-decoration: none}
a:hover 	{color: black; background-color: white; text-decoration: underline}

body {margin:0; padding:0; background:#BBBBBB;}

#category {text-align:left; padding-left:2px; font-size:16px; position: relative; top: 80px; left:10px; border-bottom: gray 2px solid; width:780px}
#content  {text-align:left; padding-left:2px; font-size:16px; position: relative; top: 80px; left:10px; width:780px}
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
	<c:forEach items="${path }" var="category">
		> <a href="category.oz?cid=<c:out value="${category.id }"/>"><c:out value="${category.name }"/></a>
	</c:forEach>
	</td>
	<td align="right">
		<a href="cart.oz">Shopping Cart</a> | <a href="#">Invoice Status</a>
	</td>
</tr></table>
</div>

<div id="content">
<form name="frm" action="cart/add.oz" method="post">
<font color="red"><c:out value="${loginErrorMsg }"/></font>
<table>
	<tr>
		<td rowspan="5"><img src="<c:out value="${item.pictureUrl}"/>" border="0"/></td>
		<td>product</td>
		<td>
			<c:out value="${item.itemName}"/>
		</td>
	</tr>
	<tr>
		<td>price</td>
		<td><c:out value="${item.price}"/></td>
	</tr>
	<tr>
		<td>stock</td>
		<td><c:out value="${item.amount}"/></td>
	</tr>
	<tr>
		<td>amount</td>
		<td><input type="text" name="amount"></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type="submit" value="Buy"></td>
	</tr>
	<tr>
		<td colspan="3">
			<c:out value="${item.description}"/>
		</td>
	</tr>
</table>
<input type="hidden" name="item" value=<c:out value="${item.itemId }"/>>
</form>
</div>

</td>
</tr>
</table>
</center>
</body>
</html>