<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<html>
<head>
<title>관리자 메뉴 - 공지 관리</title>
</head>
<link rel=stylesheet type="text/css" href="<spring:message code="store.path"/>/css/admin-general.css" >
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/page.css" />
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/buttons.css" />
<body><center><table width="800" height="1000"><tr><td valign="top">
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>

<div style="position:relative;top:10;left:10">
<table class="solid-border-1" border="0" cellpadding="0" cellspacing="0">
	<tr class="header-1" height="25" align="center">
		<td width="80">Ref No.</td>
		<td width="300">Title</td>
		<td width="120">Date</td></tr>
	
	<c:forEach items="${NOTICE_LIST}" var="notice">
	<tr class="content-1" height="25">
		<td align="center" class="top-line-1">
			<a href="edit.oz?nid=<c:out value="${notice.noticeId}"/>"><c:out value="${notice.noticeId }"/></a></td>
		<td style="overflow:hidden;text-overflow:ellipsis;" class="top-line-1">
			<a href="edit.oz?nid=<c:out value="${notice.noticeId}"/>"><c:out value="${notice.title}"/></a></td>
		<td align="center" class="top-line-1">
			<c:out value="${notice.regDate}"/></td>
	</tr>
	</c:forEach>
</table>
<a href="add.oz" class="btn"  style="position:relative;top:10;left:400">공지추가</a>
</div>

</td></tr></table></center></body>
</html>