<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<html>
<head>
<title><spring:message code="store.name"/> - Promotion Manager</title>
</head>
<link rel=stylesheet type="text/css" href="<spring:message code="store.path"/>/css/admin-general.css" >
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/page.css" />
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/buttons.css" />
<body><center><table width="800" height="1000"><tr><td valign="top">
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>
<div style="position:relative;top:10;left:10">
<table class="solid-border-1" border="0" cellpadding="0" cellspacing="0">
	<tr class="header-1" height="25" align="center">
		<td width="350">Promotion</td>
		<td width="150">Action</td></tr>

	<c:forEach items="${EVENT_LIST}" var="event">
	<tr class="content-1" height="25">
		<td class="top-line-1">&nbsp;<c:out value="${event.eventName }"/></td>
		<td class="top-line-1" align="center">
			[<a href="editEvent.oz?id=<c:out value="${event.eventId }"/>">E</a>]
			[<a href="delEvent.oz?id=<c:out value="${event.eventId }"/>">D</a>] 
		</td></tr>
	</c:forEach>
</table>
<a href="addEvent.oz" style="position:relative;top:10;left:390">[Create Promotion]</a>
</div>
</td></tr></table></center>
</body>
</html>