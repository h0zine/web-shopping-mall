<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<html>
<head>
<title><spring:message code="store.name"/></title>
</head>
<body>

[상품  분류]
<div>
HOME
<c:forEach items="${categoryList}" var="category">
	| <a href="category.oz"><c:out value="${category.name }"/></a> 
</c:forEach>
</div>

<br><br>
[이벤트 목록]

<c:forEach items="${eventList}" var="event">
<br>
<div>
	<c:out value="${event.eventName }"/> --
	
	<c:forEach items="${event.items}" var="eventItem">
		<c:out value="${eventItem.itemName}"/>	
	</c:forEach>
</div>
</c:forEach>

</body>
</html>