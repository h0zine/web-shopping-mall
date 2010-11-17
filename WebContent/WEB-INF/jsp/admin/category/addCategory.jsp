<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<% int parentid = 0; try { parentid = Integer.parseInt(request.getParameter("parent")); } catch (Exception e) {} %>
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
	<form  name="frm" action="addCategory.oz" method="post">
		<spring:bind path="category">
		  <font color="red"><c:out value="${status.errorMessage}"/> </font>
		</spring:bind>
		<spring:bind path="category.name">
			<font color="red"><c:out value="${status.errorMessage}"/><br><br></font>
		</spring:bind>
		<input type="hidden" name ="parent" value="<%= parentid %>">
		<font color="red"><c:out value="${loginErrorMsg }"/></font>
		<table class="solid-border-1" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td class="header-1" width="100">Category</td>
				<td class="content-1" width="200">
					<input type="text" name="name" maxlength="20" style="width:230px">
				</td>
			</tr>
		</table> 
		
		<input type="submit" value="Add" style="position:relative;top:10;left:280">

		
	</form>
</td></tr></table>
</div></td></tr></table></center>
</body>
</html>