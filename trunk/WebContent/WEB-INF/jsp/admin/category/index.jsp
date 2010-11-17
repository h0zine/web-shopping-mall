<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<html>
<head>
<title><spring:message code="store.name"/> - Category Manager</title>
</head>
<link rel=stylesheet type="text/css" href="<spring:message code="store.path"/>/css/admin-general.css" >
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/page.css" />
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/buttons.css" />
<body><center><table width="800" height="1000"><tr><td valign="top">
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>
<div style="position:relative;top:10;left:10">
<table class="solid-border-1" border="0" cellpadding="0" cellspacing="0">
	<tr align="center" height="25">
		<td class="header-1" width="300">Category</td>
		<td class="header-1" width="100">Action</td></tr>
	
	<c:forEach items="${CATEGORY_LIST}" var="category">
	<tr height="25">
		<td class="content-1 top-line-1" style="padding: 0 5">
			<c:forEach begin="0" end="${category.depth}" step="1">&nbsp;</c:forEach>
			<c:out value="${category.name }"/></td>
		<td class="content-1 top-line-1" align="center">
			<a href="editCategory.oz?id=${category.id }" class="button micro gray">[E]</a> 
			<a href="addCategory.oz?parent=${category.id }" class="button micro blue">[A]</a>
			<a href="delCategory.oz?id=${category.id }" class="button micro orange">[D]</a> 
			</td>
	</tr>
	</c:forEach>
</table>
<a href="addCategory.oz" class="button mini blue" style="position:relative;top:10;left:360">Add</a>
</div></td></tr></table></center>
</body>
</html>