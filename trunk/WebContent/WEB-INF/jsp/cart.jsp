<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title><spring:message code="store.name"/></title>
</head>
<body>

[Shopping cart]
<div>
<table>
<tr><td>제품명</td><td>수량</td><td>삭제</td></tr>
<c:forEach items="${CART}" var="order">
<form name="cartForm">
<tr>
	<input type="hidden" name="id" value="<c:out value="${order.orderId}"/>">
	<td><a href="item.oz?id=<c:out value="${order.itemId }"/>"><c:out value="${order.productName }"/></a></td>
	<td>
		<input type="text" name="amount" value=<c:out value="${order.amount }"/>> 
		<input type="button" value="업데이트">
	</td>
	<td><input type="button" value="삭제"></td>
</tr> 
</form>
</c:forEach>
</table>
[<a href="<spring:message code="store.path"/>/cart/checkout.oz">구매</a>] [<a href="<spring:message code="store.path"/>/category.oz">쇼핑계속</a>]
</div>
</body>
</html>