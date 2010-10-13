<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>    
<html>
<head>
<title><spring:message code="store.name"/> - 카테고리 수정</title>
</head>
<body>
<form  name="frm" action="userDetail.oz" method="post">
<spring:bind path="user">
  <font color="red"><c:out value="${status.errorMessage}"/></font>
</spring:bind>

<font color="red"><c:out value="${loginErrorMsg }"/></font>
<table>
	<tr>
		<td>아이디</td>
		<td><c:out value="${user.id}"/></td>
	</tr>

	<tr>
		<td>이름</td>
		<td><c:out value="${user.name}"/></td>
	</tr>

	<tr>
		<td>닉네임</td>
		<td><c:out value="${user.nick}"/></td>
	</tr>

	<tr>
		<td>사진</td>
		<td><c:out value="${user.photo}"/></td>
	</tr>

	<tr>
		<td>아이콘</td>
		<td><c:out value="${user.icon}"/></td>
	</tr>

	<tr>
		<td>전화번호</td>
		<td><c:out value="${user.tphone}"/></td>
	</tr>

	<tr>
		<td>핸드폰</td>
		<td><c:out value="${user.hphone}"/></td>
	</tr>

	<tr>
		<td>직장전화</td>
		<td><c:out value="${user.comtel}"/></td>
	</tr>

	<tr>
		<td>이메일</td>
		<td><c:out value="${user.email}"/></td>
	</tr>

	<tr>
		<td>우편번호</td>
		<td><c:out value="${user.post}"/></td>
	</tr>

	<tr>
		<td>주소 1 (street)</td>
		<td><c:out value="${user.address1}"/></td>
	</tr>

	<tr>
		<td>주소 2 (town, state, nation)</td>
		<td><c:out value="${user.address2}"/></td>
	</tr>

	<tr>
		<td>생일</td>
		<td><c:out value="${user.birthday}"/></td>
	</tr>

	<tr>
		<td>회원등급</td>
		<td>
			<spring:bind path="user.level">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>방문횟수</td>
		<td><c:out value="${user.visit}"/></td>
	</tr>

	<tr>
		<td>방문시간</td>
		<td><fmt:formatDate type="date" value="${user.visitTime}" /></td>
	</tr>

	<tr>
		<td>자기소개</td>
		<td><c:out value="${user.intro}"/></td>
	</tr>

	<tr>
		<td>메모</td>
		<td>
			<spring:bind path="user.memo">
			<textarea name="<c:out value="${status.expression}"/>"><c:out value="${status.value}"/></textarea>
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