<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>    
<html>
<head>
<title><spring:message code="store.name"/> - 공지등록</title>
</head>
<body>
<form  name="frm" action="add.oz" method="post">
<spring:bind path="notice.popup">
<input type="hidden" name="<c:out value="${status.expression}"/>" value="false"/>
</spring:bind>
<spring:bind path="notice">
  <font color="red"><c:out value="${status.errorMessage}"/></font>
</spring:bind>

<font color="red"><c:out value="${loginErrorMsg }"/></font>
<table>
	<tr>
		<td>공지제목</td>
		<td>
			<spring:bind path="notice.title">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td>공지내용</td>
		<td>
			<spring:bind path="notice.content">
			<textarea name="<c:out value="${status.expression}"/>"><c:out value="${status.value}"/></textarea>
			<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="추가">
		</td>
	</tr>
</table>
</form>
</body>
</html>