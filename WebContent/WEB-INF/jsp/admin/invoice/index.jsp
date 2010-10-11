<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<html>
<head>
<title>관리자 메뉴 - 카테고리 관리</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>

<table>
	<tr>
		<td>주문번호</td>
		<td>주문일시</td>
		<td>업데이트</td>
		<td>주문자</td>
		<td>수신자</td>
		<td>상태</td>
		<td>주문일시</td></tr>
	
	<c:forEach items="${INVOICE_LIST}" var="invoice">
	<tr>
		<td><a href="invoiceDetail.oz?id=<c:out value="${invoice.id }"/>"><c:out value="${invoice.id }"/></a></td>
		<td><c:out value="${invoice.issueDate }"/></td>
		<td><c:out value="${invoice.lastUpdate }"/></td>
		<td><c:out value="${invoice.buyerName }"/></td>
		<td><c:out value="${invoice.receiverName }"/></td>
		<td><c:out value="${invoice.status }"/></td>
		<td><c:out value="${invoice.lastUpdate }"/></td>
	</tr>
</c:forEach>
</table>
</body>
</html>