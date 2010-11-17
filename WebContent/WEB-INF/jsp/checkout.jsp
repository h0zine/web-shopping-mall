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
	
}

function update_item(item_id, amount)
{
	alert(item_id+","+amount);
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
	<a href="/<spring:message code="store.path"/>/index.oz">HOME</a>
	</td>
	<td align="right">
		<a href="cart.oz">Shopping Cart</a> | <a href="#">Invoice Status</a>
	</td>
</tr></table>
</div>
<div id="cart">
[Order]
<form method="post" action="checkout.oz">
	<input type="hidden" name="buyerId" value="${invoice.buyerId }"/>
<table>
	<tr><td colspan="2">Buyer Info</td></tr>
	<tr><td>Name</td><td><input type="text" name="buyerName"></td></tr>
	<tr><td>Email</td><td><input type="text" name="buyerEmail"></td></tr>
	<tr><td>Phone</td><td><input type="text" name="buyerPhone"></td></tr>
	<tr><td>PIN</td><td><input type="text" name="buyerId"></td></tr>
</table>

<table>
	<tr><td colspan="2">Post To</td></tr>
	<tr><td>name</td><td><input type="text" name="receiverName"></td></tr>
	<tr><td>Email</td><td><input type="text" name="receiverEmail"></td></tr>
	<tr><td>Phone</td><td><input type="text" name="receiverPhone"></td></tr>
	<tr><td>Address</td><td><input type="text" name="address1"></td></tr>
	<tr><td>Address</td><td><input type="text" name="address2"></td></tr>
	<tr><td>Postcode</td><td><input type="text" name="postcode"></td></tr>
	<tr><td>State</td><td><input type="text" name="state"></td></tr>
</table>

<table>
	<tr><td colspan="2">Pay Info</td></tr>
	<tr><td>product cost</td><td>${invoice.productCost }</td></tr>
	<tr><td>delivery fee</td><td>${invoice.deliveryCost }</td></tr>
	<tr><td>total</td><td>${invoice.productCost + invoice.deliveryCost }</td></tr>
	<tr><td>pay method</td><td><input type="text" name="paymethod"></td></tr>
	<tr><td>memo</td><td><input type="text" name="memo"></td></tr>
</table>

<input type="submit" value="buy">

</form>
</div>

</td>
</tr>
</table>
</center>
</body>
</html>