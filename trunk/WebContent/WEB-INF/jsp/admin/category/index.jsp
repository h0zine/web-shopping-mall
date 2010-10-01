<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<html>
<head>
<title>관리자 메뉴 - 카테고리 관리</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>

<table>
	<tr><td>카테고리명</td><td>메뉴</td></tr>
<c:forEach items="${CATEGORY_LIST}" var="category">
	<tr>
		<td>
			<c:forEach begin="0" end="${category.depth}" step="1">&nbsp;</c:forEach>
			<a href="category.oz"><c:out value="${category.name }"/></a></td>
		<td>
			[<a href="delCategory.oz?id=<c:out value="${category.id }"/>"">-</a>] 
			[<a href="editCategory.oz?id=<c:out value="${category.id }"/>"">=</a>] 
			[<a href="addCategory.oz?parent=<c:out value="${category.id }"/>">+</a>]</td>
	</tr>
</c:forEach>
	<tr><td colspan="2"><a href="addCategory.oz">카테고리 추가</a></td></tr>
</table>
</body>
</html>