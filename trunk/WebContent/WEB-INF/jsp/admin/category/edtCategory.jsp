<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>    
<html>
<head>
<title><spring:message code="store.name"/> - Category Manager</title>
</head>
<link rel=stylesheet type="text/css" href="<spring:message code="store.path"/>/css/admin-general.css" >
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/page.css" />
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/buttons.css" />
<body><center><table width="800" height="1000"><tr><td valign="top">
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>
<div style="position:relative;top:100;left:30; width:600px">
<table border="0" width="600"><tr><td>
	<form  name="frm" action="editCategory.oz" method="post">
		<spring:bind path="category">
		  <font color="red"><c:out value="${status.errorMessage}"/></font>
		</spring:bind>
		
		<spring:bind path="category.parent">
			<input type="hidden"
				name ="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>">
		</spring:bind>
		
		<spring:bind path="category.id">
			<input type="hidden"
				name ="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>">
		</spring:bind>
		
		<spring:bind path="category.depth">
			<input type="hidden"
				name ="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>">
		</spring:bind>
		
		<font color="red"><c:out value="${loginErrorMsg }"/></font>
		<table class="solid-border-1" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td class="header-1" width="100">Category</td>
				<td class="content-1" width="200">
					<spring:bind path="category.name">
					<input type="text" style="width:230px"
						name="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>" maxlength="20">
						<font color="red"><c:out value="${status.errorMessage}"/></font>
					</spring:bind>
				</td>
			</tr>
		</table>
		<input type="submit" value="Update" style="position:relative;top:10;left:280">
	</form>
</td></tr></table>
</div></td></tr></table></center>
</body>
</html>