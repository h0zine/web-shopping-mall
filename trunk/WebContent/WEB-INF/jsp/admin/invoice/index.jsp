<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<html>
<head>
<title><spring:message code="store.name"/> - Invoice Manager</title>
</head>
<link rel=stylesheet type="text/css" href="<spring:message code="store.path"/>/css/admin-general.css" >
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/page.css" />
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/buttons.css" />
<body><center><table width="800" height="1000"><tr><td valign="top">
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>
<div style="position:relative;top:10;left:10">
<table class="solid-border-1" border="0" cellpadding="0" cellspacing="0">
	<tr class="header-1" height="25" align="center">
		<td width="50">Ref</td>
		<td width="100">Order Date</td>
		<td width="100">Last Update</td>
		<td width="120">Buyer</td>
		<td width="100">Receiver</td>
		<td width="80">Status</td>
		<td width="100">Price</td>
		<td width="100">Delivery</td>
		</tr>
	
	<c:forEach items="${INVOICE_LIST}" var="invoice">
	<tr class="content-1" height="25" align="center">
		<td class="top-line-1">&nbsp;<a href="invoiceDetail.oz?id=<c:out value="${invoice.id }"/>"><c:out value="${invoice.id }"/></a></td>
		<td class="top-line-1">&nbsp;<c:out value="${invoice.issueDate }"/></td>
		<td class="top-line-1">&nbsp;<c:out value="${invoice.lastUpdate }"/></td>
		<td class="top-line-1">&nbsp;<c:out value="${invoice.buyerName }"/></td>
		<td class="top-line-1">&nbsp;<c:out value="${invoice.receiverName }"/></td>
		<td class="top-line-1">&nbsp;<c:out value="${invoice.status }"/></td>
		<td class="top-line-1">&nbsp;<c:out value="${invoice.productCost }"/></td>
		<td class="top-line-1">&nbsp;<c:out value="${invoice.deliveryCost }"/></td>
	</tr>
</c:forEach>
</table>
</div>
</td></tr></table></center></body>
</html>