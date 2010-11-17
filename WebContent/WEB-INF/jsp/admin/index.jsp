<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<html>
<head>
<title><spring:message code="store.name"/> - 관리자 메뉴</title>
</head>
<link rel=stylesheet type="text/css" href="<spring:message code="store.path"/>/css/admin-general.css" >
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/page.css" />
<body>
<center>
<table width="800" height="1000"><tr><td valign="top">
<span><%@ include file="/WEB-INF/jsp/admin/menu.jsp" %></span>
</td></tr></table>
</center>
</body>
</html>