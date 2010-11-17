<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<html>
<head>
<title><spring:message code="store.name"/> - Feedback Manager</title>
</head>
<link rel=stylesheet type="text/css" href="<spring:message code="store.path"/>/css/admin-general.css" >
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/page.css" />
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/buttons.css" />
<body><center><table width="800" height="1000"><tr><td valign="top">
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>
<div style="position:relative;top:10;left:10">
<table class="solid-border-1" border="0" cellpadding="0" cellspacing="0">
	<tr class="header-1" height="25" align="center">
		<td width="550">Comment</td>
		<td width="80">Point</td>
		<td width="120">Writer</td>
	</tr>
	
	<c:forEach items="${FEEDBACK_LIST}" var="feedback">
	<tr class="content-1" height="25">
		<td class="top-line-1">&nbsp;${feedback.comment }</td>
		<td class="top-line-1" align="center">${feedback.point}</td>
		<td class="top-line-1" align="center">${feedback.writerName}</td>
	</tr>
	</c:forEach>
</table>
</div></td></tr></table></center>
</body>
</html>