<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>    
<html>
<head>
<title><spring:message code="store.name"/> - 상품 수정</title>
</head>
<script type="text/javascript" src="/WEB-INF/js/jquery-1.4.2.js"></script>     
<script type="text/javascript">                                         
	$(document).ready(function() {
	   $("a").click(function() {
	     alert("Hello world!");
	   });
	 });
</script>
<body>
<a href="">test</a>
<form  name="frm" action="addItem.oz" method="post">
<font color="red"><c:out value="${loginErrorMsg }"/></font>
<table>
	<tr>
		<td>상품 명</td>
		<td>
			<spring:bind path="item.itemName">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td>가격</td>
		<td>
			<spring:bind path="item.price">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td>이미지 URL</td>
		<td>
			<spring:bind path="item.pictureUrl">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td>재고량</td>
		<td>
			<spring:bind path="item.amount">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td>카테고리 1</td>
		<td>
			<spring:bind path="item.categoryId1">
			<select name="<c:out value="${status.expression}"/>">
			<c:forEach items="${CATEGORY_LIST }" var="category">
				<option value="<c:out value="${category.id }"/>"><c:out value="${category.name }"/></option>
			</c:forEach>
			</select>
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td>카테고리 2</td>
		<td>
			<spring:bind path="item.categoryId2">
			<select name="<c:out value="${status.expression}"/>">
			<c:forEach items="${CATEGORY_LIST }" var="category">
				<option value="<c:out value="${category.id }"/>"><c:out value="${category.name }"/></option>
			</c:forEach>
			</select>
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td>카테고리 3</td>
		<td>
			<spring:bind path="item.categoryId3">
			<select name="<c:out value="${status.expression}"/>">
			<c:forEach items="${CATEGORY_LIST }" var="category">
				<option value="<c:out value="${category.id }"/>"><c:out value="${category.name }"/></option>
			</c:forEach>
			</select>
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td>이벤트 1</td>
		<td>
			<spring:bind path="item.eventId1">
			<select name="<c:out value="${status.expression}"/>">
			<c:forEach items="${EVENT_LIST }" var="event">
				<option value="<c:out value="${event.eventId }"/>"><c:out value="${event.eventName }"/></option>
			</c:forEach>
			</select>
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td>이벤트 2</td>
		<td>
			<spring:bind path="item.eventId2">
			<select name="<c:out value="${status.expression}"/>">
			<c:forEach items="${EVENT_LIST }" var="event">
				<option value="<c:out value="${event.eventId }"/>"><c:out value="${event.eventName }"/></option>
			</c:forEach>
			</select>
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td>이벤트 3</td>
		<td>
			<spring:bind path="item.eventId3">
			<select name="<c:out value="${status.expression}"/>">
			<c:forEach items="${EVENT_LIST }" var="event">
				<option value="<c:out value="${event.eventId }"/>"><c:out value="${event.eventName }"/></option>
			</c:forEach>
			</select>
			<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td>설명</td>
		<td>
			<spring:bind path="item.description">
			<textarea rows="20" cols="80" name="<c:out value="${status.expression}"/>"><c:out value="${status.value}"/></textarea>
			<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="submit" value="추가">
		</td>
	</tr>
</table>
</form>
</body>
</html>