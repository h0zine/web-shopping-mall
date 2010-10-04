<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<html>
<head>
<title>관리자 메뉴 - 이벤트 관리</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>

<table>
	<tr><td>이벤트 명</td><td>메뉴</td></tr>
<c:forEach items="${EVENT_LIST}" var="event">
	<tr>
		<td>
			<c:out value="${event.eventName }"/></td>
		<td>
			[<a href="delEvent.oz?id=<c:out value="${event.eventId }"/>"">-</a>] 
			[<a href="editEvent.oz?id=<c:out value="${event.eventId }"/>"">=</a>]</td>
	</tr>
</c:forEach>
	<tr><td colspan="2"><a href="addEvent.oz">이벤트 추가</a></td></tr>
</table>
</body>
</html>