<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<html>
<head>
<title>관리자 메뉴 - 공지 관리</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>

<table>
	<tr><td>일련번호</td><td>공지명</td><td>등록일</td></tr>
<c:forEach items="${NOTICE_LIST}" var="notice">
	<tr>
		<td>
			<c:out value="${notice.noticeId }"/></td>
		<td>
			<a href="edit.oz?nid=<c:out value="${notice.noticeId}"/>"><c:out value="${notice.title}"/></a></td>
		<td>
			<c:out value="${notice.regDate}"/></td>
	</tr>
</c:forEach>
	<tr><td colspan="2"><a href="add.oz">공지추가</a></td></tr>
</table>
</body>
</html>