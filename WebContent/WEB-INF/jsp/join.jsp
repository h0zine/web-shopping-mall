<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<Html>
<head>
<title><spring:message code="store.name"/> - 회원가입</title>
<body>
<script language="JavaScript" src="/js/member_join.js"></script>

<div>
<form  name="joinFrm" action="member.join.oz" method="post" enctype="multipart/form-data">
<!-- 
 onSubmit="return joinCheck(this);">
 --> 
<spring:bind path="user">
  <font color="red"><c:out value="${struts.errorMessage}"/></font>
</spring:bind>

<!--회원가입 시작-->
<table border=0 cellpadding=0 cellspacing=0 width=100%>
  <tr><td height=3 bgcolor=#999999></td></tr>
  <!--기본정보-->
  <tr>
    <td bgcolor=#F9F9F9 style="padding:10">
	  ID: <input type="text" name="id" size="20" onClick="idCheck();" maxlength="12" class="input" readOnly>
	  <input type="button" value="check" onclick="javascript:idCheck();">
	  <span class="s11">(3~12 After English, number and joining the ID fringe land is wrong)</span>
	</td>
  </tr>
  <tr height=28>
    <td>
      Password: <input type=password name="passwd1" size=20 class="input">
	  <span class="s11">(English and number of 4 or more characters)</span>
	</td>
  </tr>
  <tr height=28>
    <td>
	  Password Confirm: <input type=password name="passwd2" size=20 class="input">
	</td>
  </tr>
  <tr height=28>
    <td>
      name: <input type=text name="name" size=20 class="input" >
    </td>
  </tr>
  <tr height=28>
	<td>
	  nickname:
	  <input name="nick" type="text" class="input" size="20" readonly onClick="nickCheck()" />
	  <input type="button" value="check" onClick="nickCheck()"">
	</td>
  </tr>
  <tr height=28>
	<td>
	  photo:
	  <input name="photo" type="file" class="input" size="20" />
	</td>
  </tr>
  <tr height=28>
    <td>
      icon:
      <input name="icon" type="file" class="input" size="20" />
    </td>
  </tr>
  <tr height=28>
	<td>
	  Post code:
	  <input type=text name="post" size=5 class="input">
	</td>
	</tr>
	<tr>
      <td>
        Address 1:
        <input type=text name="address1" id='addr1' size=80 class="input">
      </td>
    </tr>
	<tr height=28>
      <td>
        Address 2:
        <input type=text name="address2" id='addr2' size=80 class="input">
      </td>
    </tr>
    <tr height=28>
	  <td>
	    telephone:
		<input type=text name="tphone" size=12 class="input">
	  </td>
	</tr>
    <tr height=28>
	  <td>
	    mobile :
		<input type=text name="hphone" size=12 class="input">
      </td>
	</tr>
    <tr height=28 style="padding-top:3px;padding-bottom:3px">
      <td>
        email :
		<input type=text name="email" size=30 class="input"><br>
		<input type="checkbox" name="reemail">Received the service which gets clogged?
      </td>
    </tr>
	<!--추가정보-->
    <tr height=28>
	  <td>
	    birth day: 
		<input type=text name="birthday1" size=8 class="input">Year
		<input type=text name="birthday2" size=5 class="input">Month
		<input type=text name="birthday3" size=5 class="input">Day
	  </td>
	</tr>
								
	<tr>
	  <td height=80 align=center>
		<input type="button" onclick="submit()">
	  </td>
	</tr>
</table>
<!-- 회원가입 끝 --> 
</form>
</div>

</body>
</html>				
