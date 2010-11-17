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
#cart {text-align:left; padding-left:2px; font-size:16px; position: relative; top: 120px; left:10px; width:780px}
#footer {text-align:left; padding-left:2px; font-size:16px; position: relative; top: 80px; left:10px; border-top: gray 2px solid; width:780px}
</style>
<script>
function delete_item(item_id)
{
	document.forms["updateForm"].cmd.value="delete";
	document.forms["updateForm"].id.value=item_id;
	document.forms["updateForm"].amount.value=0;
	document.forms["updateForm"].submit();
}

function update_item(item_id, amount)
{
	document.forms["updateForm"].cmd.value="update";
	document.forms["updateForm"].id.value=item_id;
	document.forms["updateForm"].amount.value=amount;
	document.forms["updateForm"].submit();
}
</script>
<body>
<center>
<table width="800" height="1050" border="0" cellpadding="0" cellspacing="0"><tr>
<td width="1px" bgcolor="#888888"></td>
<td bgcolor="white" valign="top">

<div id="category">
<table width="770">
<tr>
	<td align="left">
	<a href="index.oz">HOME</a>
	</td>
	<td align="right">
		<a href="cart.oz">Shopping Cart</a> | <a href="#">Invoice Status</a>
	</td>
</tr>
</table>

</div>
<div id="cart">
[Shopping cart]
<table>
<tr><td>
<table>
<tr><td width="500">Product Name</td><td>Amount</td><td>Action</td></tr>
</table>
</td></tr>
<c:set var="cnt" scope="session" value="0"/>
<c:forEach items="${CART}" var="order">
<c:set var="cnt" value="${cnt+1}" />
<tr><td>
	<form name="cartForm${cnt }/>"><table><tr>
	<td width="500"><a href="item.oz?id=<c:out value="${order.itemId }"/>"><c:out value="${order.productName }"/></a></td>
	<td>
		<input type="hidden" name="id" value="${cnt}">
		<input type="text" name="amount" value="${order.amount}" style="width:60px"> 
	</td>
	<td>
		<input type="button" value="Remove" onclick="delete_item(${cnt})">
		<input type="button" value="Update" onclick="update_item(${cnt}, amount.value)">
	</td>
	</tr></table></form>
</tr> 
</c:forEach>

<c:if test="${cnt == 0}">
<tr><td align="center">No product in cart</td></tr>
</c:if>
<tr><td align="right">
<c:if test="${cnt != 0 }">
[<a href="<spring:message code="store.path"/>/cart/checkout.oz">pay now</a>]
</c:if>
[<a href="<spring:message code="store.path"/>/category.oz">continue shopping</a>]
</td></tr>
</table>
</div>
<form name="updateForm" method="post" action="<spring:message code="store.path"/>/cart/update.oz"><input type="hidden" name="cmd"><input type="hidden" name="id"><input type="hidden" name="amount"></form>
</td>
</tr>
</table>
</center>
</body>
</html>