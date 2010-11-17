<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>    
<html>
<head>
<title><spring:message code="store.name"/> - Product manager</title>
</head>
<link rel=stylesheet type="text/css" href="<spring:message code="store.path"/>/css/admin-general.css" >
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/page.css" />
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/buttons.css" />
<body><center><table width="800" height="1000"><tr><td valign="top">
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>
<div style="position:relative;top:10;left:10">

<form name="frm" action="edtItem.oz" method="post">
	<table class="solid-border-1" border="0" cellpadding="0" cellspacing="0">
	<tr height="25">
		<td class="header-1" align="center" width="120">Name</td>
		<td class="content-1" style="padding: 0 5">
			<input type="text" name="itemName" value="${item.itemName }" maxlength="20">
		</td>
	</tr>
	<tr height="25">
		<td class="header-1 top-line-1" align="center">Price (Cent)</td>
		<td class="content-1 top-line-1" style="padding: 0 5">
			<input type="text" name="price" value="${item.price }" maxlength="20">
		</td>
	</tr>
	<tr height="25">
		<td class="header-1 top-line-1" align="center">Image URL</td>
		<td class="content-1 top-line-1" style="padding: 0 5">
			<input type="text" name="pictureUrl" value="${item.pictureUrl}" maxlength="80">
		</td>
	</tr>
	<tr height="25">
		<td class="header-1 top-line-1" align="center">Stock</td>
		<td class="content-1 top-line-1" style="padding: 0 5">
			<input type="text" name="amount" value="${item.amount}" maxlength="20">
		</td>
	</tr>
	<tr height="25">
		<td class="header-1 top-line-1" align="center">Category</td>
		<td class="content-1 top-line-1" style="padding: 0 5">
			<select name="categoryId1">
			<option value="0">-Empty-</option>
			<c:forEach items="${CATEGORY_LIST }" var="category">
				<option value="${category.id }" <c:if test="${category.id == item.categoryId1}">SELECTED</c:if>>${category.name }</option>
			</c:forEach>
			</select>
		</td>
	</tr>
	<tr height="25">
		<td class="header-1 top-line-1" align="center">Category</td>
		<td class="content-1 top-line-1" style="padding: 0 5">
			<select name="categoryId2">
			<option value="0">-Empty-</option>
			<c:forEach items="${CATEGORY_LIST }" var="category">
				<option value="${category.id }" <c:if test="${category.id == item.categoryId2}">SELECTED</c:if>>${category.name }</option>
			</c:forEach>
			</select>
		</td>
	</tr>
	<tr height="25">
		<td class="header-1 top-line-1" align="center">Category</td>
		<td class="content-1 top-line-1" style="padding: 0 5">
			<select name="categoryId3">
			<option value="0">-Empty-</option>
			<c:forEach items="${CATEGORY_LIST }" var="category">
				<option value="${category.id }" <c:if test="${category.id == item.categoryId3}">SELECTED</c:if>>${category.name }</option>
			</c:forEach>
			</select>
		</td>
	</tr>
	<tr height="25">
		<td class="header-1 top-line-1" align="center">Event</td>
		<td class="content-1 top-line-1" style="padding: 0 5">
			<select name="eventId1">
			<option value="0">-Empty-</option>
			<c:forEach items="${EVENT_LIST }" var="event">
				<option value="${event.eventId }" <c:if test="${event.eventId == item.eventId1}">SELECTED</c:if>>${event.eventName }</option>
			</c:forEach>
			</select>
		</td>
	</tr>
	<tr height="25">
		<td class="header-1 top-line-1" align="center">Event</td>
		<td class="content-1 top-line-1" style="padding: 0 5">
			<select name="eventId2">
			<option value="0">-Empty-</option>
			<c:forEach items="${EVENT_LIST }" var="event">
				<option value="${event.eventId }" <c:if test="${event.eventId == item.eventId2}">SELECTED</c:if>>${event.eventName }</option>
			</c:forEach>
			</select>
		</td>
	</tr>
	<tr height="25">
		<td class="header-1 top-line-1" align="center">Event</td>
		<td class="content-1 top-line-1" style="padding: 0 5">
			<select name="eventId3">
			<option value="0">-Empty-</option>
			<c:forEach items="${EVENT_LIST }" var="event">
				<option value="${event.eventId }" <c:if test="${event.eventId == item.eventId3}">SELECTED</c:if>>${event.eventName }</option>
			</c:forEach>
			</select>
		</td>
	</tr>
	<tr height="25">
		<td class="header-1 top-line-1" align="center">Desc.(HTML)</td>
		<td class="content-1 top-line-1" style="padding: 5 5">
			<spring:bind path="item.description">
			<textarea rows="20" cols="80" name="<c:out value="${status.expression}"/>"><c:out value="${status.value}"/></textarea>
			<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	</table>
	<input type="hidden" name="itemId" value="${item.itemId }">
	<input type="submit" value="Update" class="button mini blue" style="position:relative;top:10;left:630">
</form>

</div></td></tr></table></center>
</body>
</html>