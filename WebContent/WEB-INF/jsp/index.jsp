<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title><spring:message code="store.name"/></title>
</head>
<body>

[상품  분류]
<div>
HOME
<c:forEach items="${categoryList}" var="category">
	| <a href="category.oz?cid=<c:out value="${category.id }"/>"><c:out value="${category.name }"/></a> 
</c:forEach>
</div>

<br><br>
[공지사항]
<br>
<c:forEach items="${noticeList}" var="notice">
	<c:out value="${notice.title }"/><br>
</c:forEach>

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