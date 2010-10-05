<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<html>
<head>
<title>관리자 메뉴 - 상품관리</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>

<table>
	<tr>
		<td align="center">상품명</td>
		<td align="center">가격</td>
		<td align="center">재고</td>
		<td align="center">판매량</td>
		<td align="center">조회수</td>
		<td align="center">등록일</td>
		<td align="center">마지막판매일</td>
		<td align="center">메뉴</td>
	</tr>
	
	<c:forEach items="${ITEM_LIST}" var="item">
	<tr>
		<td><a href="edtItem.oz?id=<c:out value="${item.itemId }"/>"><c:out value="${item.itemName }"/></a></td>
		<td align="center"><c:out value="${item.price }"/></td>
		<td align="center"><c:out value="${item.amount }"/></td>
		<td align="center"><c:out value="${item.sold }"/></td>
		<td align="center"><c:out value="${item.visit }"/></td>
		<td align="center"><fmt:formatDate type="date" value="${item.lastUpdate}" /></td>
		<td align="center"><fmt:formatDate type="date" value="${item.lastSold}" /></td>
		<td>
			[<a href="delItem.oz?id=<c:out value="${item.itemId }"/>">-</a>] 
			[<a href="editItem.oz?id=<c:out value="${item.itemId }"/>">=</a>]</td>
	</tr>
	</c:forEach>
	
	<tr><td colspan="8" align="right">[<a href="addItem.oz">New Item</a>]</td></tr>
</table>
</body>
</html>