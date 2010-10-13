<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<html>
<head>
<title>관리자 메뉴 - 회원 관리</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>

<table>
	<tr><td>아이디</td><td>이름</td><td>닉네임</td></tr>
	
	<c:forEach items="${USER_LIST}" var="user">
	<tr>
		<td>
			<a href="detail.oz?id=<c:out value="${user.id }"/>"><c:out value="${user.id }"/></a></td>
		<td>
			<c:out value="${user.name }"/></td>
		<td>
			<c:out value="${user.nick }"/></td>
	</tr>
	</c:forEach>
	
</table>
</body>
</html>