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

<body>
<center>
<table width="800" height="1050" border="0" cellpadding="0" cellspacing="0"><tr>
<td width="1px" bgcolor="#888888"></td>
<td bgcolor="white" valign="top">

<div id="category">
<table width="770">
<tr>
	<td align="left">
	<a href="<spring:message code="store.path"/>/index.oz">HOME</a>
	</td>
	<td align="right">
		<a href="cart.oz">Shopping Cart</a> | <a href="#">Invoice Status</a>
	</td>
</tr></table>

</div>
<div id="cart">
[Invoice List]<br>

<table border="1">
	<tr>
		<td>id</td>
		<td>order date</td>
		<td>status</td>
		<td>post to</td>
		<td>address</td>
		<td>phone (buyer)</td>
		<td>phone (receiver)</td>
		<td>price</td>
		<td>delivery fee</td>
	</tr>
<c:forEach items="${INVOICE_LIST}" var="invoice">
	<tr>
		<td>${invoice.id }</td>
		<td>${invoice.issueDate }</td>
		<td>${invoice.status }</td>
		<td>${invoice.receiverName }</td>
		<td>${invoice.address1 } ${invoice.address2 } ${invoice.postcode } ${invoice.state }</td>
		<td>${invoice.buyerPhone }</td>
		<td>${invoice.receiverPhone }</td>
		<td>${invoice.productCost }</td>
		<td>${invoice.deliveryCost }</td>
	</tr>
	<tr>
		<td>memo</td>
		<td colspan="8">${invoice.memo }</td>
	</tr>
	<tr>
		<td colspan="9">
			order:<br>
			<table border="1">
				<tr><td>product</td><td>amount</td><td>price</td><td>status</td></tr>
			<c:forEach items="${invoice.order}" var="order">
				<tr>
					<td>${order.productName }</td><td>${order.amount }</td><td>${order.price }</td><td>${order.status}</td>
				</tr>
			</c:forEach>
			</table>
		</td>
	</tr>
</c:forEach>
</table>

</div>

</td>
</tr>
</table>
</center>
</body>
</html>