<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>    
<html>
<head>
<title><spring:message code="store.name"/> - Order Manager</title>
</head>
<link rel=stylesheet type="text/css" href="<spring:message code="store.path"/>/css/admin-general.css" >
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/page.css" />
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/buttons.css" />
<body><center><table width="800" height="1000"><tr><td valign="top">
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>
<div style="position:relative;top:10;left:10">
<form name="frm" action="orderDetail.oz" method="post">
<font color="red"><c:out value="${loginErrorMsg }"/></font>
<table class="solid-border-1" border="0" cellpadding="0" cellspacing="0">
	<tr height="25">
		<td class="header-1" align="center" width="120">Ref No.</td>
		<td class="content-1" style="padding: 0 5" width="350">${order.orderId}</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-1" align="center">Order Date</td>
		<td class="content-1 top-line-1" style="padding: 0 5">${order.createDate}</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-1" align="center">Update Date</td>
		<td class="content-1 top-line-1" style="padding: 0 5">${order.lastUpdate }</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-1" align="center">Product</td>
		<td class="content-1 top-line-1" style="padding: 0 5">${order.productName }</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-1" align="center">Price</td>
		<td class="content-1 top-line-1" style="padding: 0 5">${order.price }</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-1" align="center">Amount</td>
		<td class="content-1 top-line-1" style="padding: 0 5">${order.amount }</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-1" align="center">Status</td>
		<td class="content-1 top-line-1" style="padding: 0 5">
			<select name="status">
				<option value="Ordered" <c:if test="${order.status=='Ordered'}">SELECTED</c:if>>Ordered</option>
				<option value="Prepared" <c:if test="${order.status=='Prepared'}">SELECTED</c:if>>Prepared</option>
				<option value="Posted" <c:if test="${order.status=='Posted'}">SELECTED</c:if>>Posted</option>
				<option value="Returned" <c:if test="${order.status=='Returned'}">SELECTED</c:if>>Returned</option>
			</select>
		</td>
	</tr>
</table>
<a href="invoiceDetail.oz?id=${order.invoiceId }" class="button gray blue" style="position:relative;top:10;left:330">Invoice</a>
<input type="submit" class="button mini blue" style="position:relative;top:10;left:350" value="Update">

<input type="hidden" name="invoiceId" value="${order.invoiceId }" >
<input type="hidden" name="orderId" value="${order.orderId }" >

</form>
</div></td></tr></table></center>
</body>
</html>