<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<%
	int pg;
	try {
		pg = Integer.parseInt(request.getParameter("page"));
	} catch (Exception e) {
		pg = 1;
	}
%>
<html>
<head>
<title><spring:message code="store.name"/> - Product Manager</title>
</head>
<link rel=stylesheet type="text/css" href="<spring:message code="store.path"/>/css/admin-general.css" >
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/page.css" />
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/buttons.css" />
<body><center><table width="800" height="1000"><tr><td valign="top">
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>
<div style="position:relative;top:10;left:10">
<table class="solid-border-1" border="0" cellpadding="0" cellspacing="0">
	<tr class="header-1" height="25" align="center">
		<td align="left" width="300">&nbsp;Product</td>
		<td width="120">Price</td>
		<td width="80">Stock</td>
		<td width="80">Sold</td>
		<td width="80">View</td>
		<td width="80">RegDate</td>
		<td width="80">Last Sold</td>
		<td width="90">Edit</td>
	</tr>
	
	<c:forEach items="${ITEM_LIST}" var="item">
	<tr class="content-1" height="25" align="center">
		<td align="left" class="top-line-1">&nbsp;${item.itemName }</td>
		<td class="top-line-1">${item.price }</td>
		<td class="top-line-1">${item.amount }</td>
		<td class="top-line-1">${item.sold }</td>
		<td class="top-line-1">${item.visit }</td>
		<td class="top-line-1"><fmt:formatDate type="date" value="${item.lastUpdate}" /></td>
		<td class="top-line-1"><fmt:formatDate type="date" value="${item.lastSold}" /></td>
		<td class="top-line-1">
			<a href="delItem.oz?id=${item.itemId }&page=${pg }>" class="button micro orange">DEL</a> 
			<a href="edtItem.oz?id=${item.itemId }" class="button micro blue">EDIT</a>
		</td>
	</tr>
	</c:forEach>
	
</table>
	<a href="addItem.oz" class="button mini blue" style="position:relative;top:10;left:740">New</a>
</div>
</td></tr></table></center></body>
</html>