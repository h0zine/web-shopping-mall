<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>    
<html>
<head>
<title><spring:message code="store.name"/> - Edit Notice</title>
</head>

<link rel=stylesheet type="text/css" href="<spring:message code="store.path"/>/css/admin-general.css" >
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/page.css" />
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/buttons.css" />

<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/jquery.cleditor.css" /> 
<script type="text/javascript" src="<spring:message code="store.path"/>/js/jquery.min.js"></script> 
<script type="text/javascript" src="<spring:message code="store.path"/>/js/jquery.cleditor.min.js"></script> 
<script type="text/javascript"> 
$(document).ready(function() {
    $("#content").cleditor( {
    	width:      650,
    	height:		300
    })[0].focus();
  });
</script>
<script type="text/javascript">
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-18352523-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script> 

<body><center><table width="800" height="1000"><tr><td valign="top">
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>
<div style="position:relative;top:10;left:10">
<form  name="frm" action="edit.oz" method="post">
<spring:bind path="notice">
  <font color="red"><c:out value="${status.errorMessage}"/></font>
</spring:bind>

<spring:bind path="notice.noticeId">
	<input type="hidden"
		name ="<c:out value="${status.expression}"/>"
		value="<c:out value="${status.value}"/>">
</spring:bind>

<font color="red"><c:out value="${loginErrorMsg }"/></font>
<table class="solid-border-1" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="80" class="header-1" align="center">Title</td>
		<td width="670" class="content-1" style="padding: 5 5">
			<spring:bind path="notice.title">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20" style="width:450px">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td width="80" class="top-line-1 header-1" align="center">Content</td>
		<td height="300" class="top-line-1 content-1" style="padding: 5 5">
			<spring:bind path="notice.content">
			<textarea name="<c:out value="${status.expression}"/>" id="content"><c:out value="${status.value}"/></textarea>
			<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
</table>
<input type="submit" class="button mini blue" style="position:relative;top:10;left:650" value="update"> 
<input type="button" class="button mini orange" style="position:relative;top:10;left:650" value="delete" onclick="delfrm.submit()">
</form>
<form name="delfrm" method="post" action="delete.oz">
	<spring:bind path="notice.noticeId">
	<input type="hidden"
		name ="nid"
		value="<c:out value="${status.value}"/>">
	</spring:bind>
</form>
</div>
</td></tr></table></center></body>
</html>