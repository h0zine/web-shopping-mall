<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>    
<html>
<head>
<title><spring:message code="store.name"/> - 카테고리 수정</title>
</head>
<body>
<form  name="frm" action="editEvent.oz" method="post">
<spring:bind path="event">
  <font color="red"><c:out value="${status.errorMessage}"/></font>
</spring:bind>

<spring:bind path="event.eventId">
	<input type="hidden"
		name ="<c:out value="${status.expression}"/>"
		value="<c:out value="${status.value}"/>">
</spring:bind>

<font color="red"><c:out value="${loginErrorMsg }"/></font>
<table>
	<tr>
		<td>카테고리명</td>
		<td>
			<spring:bind path="event.eventName">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="업데이트">
		</td>
	</tr>
</table>
</form>
</body>
</html>