<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>    
<html>
<head>
<title><spring:message code="store.name"/> - 판매관리</title>
</head>
<body>
<form  name="frm" action="invoiceDetail.oz" method="post">
<font color="red"><c:out value="${loginErrorMsg }"/></font>
<table>
	<tr>
		<td>일련번호</td>
		<td>
			<spring:bind path="invoice.id">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>구입일</td>
		<td>
			<spring:bind path="invoice.issueDate">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>업데이트일</td>
		<td>
			<spring:bind path="invoice.lastUpdate">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>물품비용</td>
		<td>
			<spring:bind path="invoice.productCost">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>배송비용</td>
		<td>
			<spring:bind path="invoice.deliveryCost">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>지불방법</td>
		<td>
			<spring:bind path="invoice.paymethod">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>처리상태</td>
		<td>
			<spring:bind path="invoice.status">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>메모</td>
		<td>
			<spring:bind path="invoice.memo">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>구매자아이디</td>
		<td>
			<spring:bind path="invoice.buyerId">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>구매자이름</td>
		<td>
			<spring:bind path="invoice.buyerName">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>구매자이메일</td>
		<td>
			<spring:bind path="invoice.buyerEmail">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>구매자전화번호</td>
		<td>
			<spring:bind path="invoice.buyerPhone">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>수취인이름</td>
		<td>
			<spring:bind path="invoice.receiverName">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>수취인이메일</td>
		<td>
			<spring:bind path="invoice.receiverEmail">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>수취인전화번호</td>
		<td>
			<spring:bind path="invoice.receiverPhone">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>배송지주소 1</td>
		<td>
			<spring:bind path="invoice.address1">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>배송지주소 2</td>
		<td>
			<spring:bind path="invoice.address2">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>우편번호</td>
		<td>
			<spring:bind path="invoice.postcode">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td>주</td>
		<td>
			<spring:bind path="invoice.state">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr>
		<td colspan="2" align="right">
			<input type="submit" value="업데이트">
		</td>
	</tr>
</table>
</form>

<table>
	<tr>
		<td>주문번호</td>
		<td>주문일시</td>
		<td>업데이트</td>
		<td>주문자</td>
		<td>수신자</td>
		<td>상태</td>
		<td>주문일시</td></tr>
	
	<c:forEach items="${ORDER_LIST}" var="order">
	<tr>
		<td><a href="orderDetail.oz?id=<c:out value="${invoice.id }"/>"><c:out value="${invoice.id }"/></a></td>
		<td><c:out value="${invoice.issueDate }"/></td>
		<td><c:out value="${invoice.lastUpdate }"/></td>
		<td><c:out value="${invoice.buyerName }"/></td>
		<td><c:out value="${invoice.receiverName }"/></td>
		<td><c:out value="${invoice.status }"/></td>
		<td><c:out value="${invoice.lastUpdate }"/></td>
	</tr>
</c:forEach>
</table>

</body>
</html>