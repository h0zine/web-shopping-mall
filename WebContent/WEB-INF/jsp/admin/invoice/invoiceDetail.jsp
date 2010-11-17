<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>    
<html>
<head>
<title><spring:message code="store.name"/> - Invoice Manager</title>
</head>
<link rel=stylesheet type="text/css" href="<spring:message code="store.path"/>/css/admin-general.css" >
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/page.css" />
<link rel="stylesheet" type="text/css" href="<spring:message code="store.path"/>/css/buttons.css" />
<body><center><table width="800" height="1000"><tr><td valign="top">
<%@ include file="/WEB-INF/jsp/admin/menu.jsp" %>
<div style="position:relative;top:10;left:10">
<form  name="frm" action="invoiceDetail.oz" method="post">
<font color="red"><c:out value="${loginErrorMsg }"/></font>
<table class="solid-border-1" border="0" cellpadding="0" cellspacing="0">
	<tr height="25">
		<td class="header-1" align="center" width="120">Ref No.</td>
		<td colspan="3" class="content-1" style="padding: 0 5">&nbsp;${invoice.id }</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-1" align="center">Order Date</td>
		<td class="content-1 top-line-1" style="padding: 0 5" width="200">&nbsp;${invoice.issueDate }
		</td>

		<td class="header-1 top-line-1" align="center" width="120">Update Date</td>
		<td class="content-1 top-line-1" style="padding: 0 5" width="200">&nbsp;${invoice.lastUpdate }</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-1" align="center">Product Price</td>
		<td class="content-1 top-line-1" style="padding: 0 5">&nbsp;${invoice.productCost }</td>

		<td class="header-1 top-line-1" align="center">Delivery Fee</td>
		<td class="content-1 top-line-1" style="padding: 0 5">&nbsp;${invoice.deliveryCost }</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-1" align="center">Pay Method</td>
		<td class="content-1 top-line-1" style="padding: 0 5">&nbsp;${invoice.paymethod}</td>

		<td class="header-1 top-line-1" align="center">Status</td>
		<td class="content-1 top-line-1"><select name="status">
			<option value="Payed" <c:if test="${order.status=='Ordered'}">SELECTED</c:if>>Payed</option>
			<option value="Ready" <c:if test="${order.status=='Ready'}">SELECTED</c:if>>Ready</option>
			<option value="Posted" <c:if test="${order.status=='Posted'}">SELECTED</c:if>>Posted</option>
			<option value="Received" <c:if test="${order.status=='Received'}">SELECTED</c:if>>Received</option>
			<option value="RefundReq" <c:if test="${order.status=='RefundReq'}">SELECTED</c:if>>Refund Req</option>
			<option value="Refunded" <c:if test="${order.status=='Refunded'}">SELECTED</c:if>>Refunded</option>
			</select>
		</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-1" align="center">Note</td>
		<td colspan="3" class="content-1 top-line-1" style="padding: 0 5">&nbsp;${invoice.memo }</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-2" align="center">Pin No.</td>
		<td class="content-1 top-line-2" style="padding: 0 5">&nbsp;${invoice.buyerId }</td>

		<td class="header-1 top-line-2" align="center">Buyer Name</td>
		<td class="content-1 top-line-2" style="padding: 0 5">&nbsp;${invoice.buyerName }</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-1" align="center">Buyer Email</td>
		<td class="content-1 top-line-1" style="padding: 0 5">
			<spring:bind path="invoice.buyerEmail">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>

		<td class="header-1 top-line-1" align="center">Buyer Phone</td>
		<td class="content-1 top-line-1" style="padding: 0 5">
			<spring:bind path="invoice.buyerPhone">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-2" align="center">Reciver Name</td>
		<td class="content-1 top-line-2" style="padding: 0 5">
			<spring:bind path="invoice.receiverName">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>

		<td class="header-1 top-line-2" align="center">Receiver Email</td>
		<td class="content-1 top-line-2" style="padding: 0 5">
			<spring:bind path="invoice.receiverEmail">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-1" align="center">Receiver Phone</td>
		<td colspan="3" class="content-1 top-line-1" style="padding: 0 5">
			<spring:bind path="invoice.receiverPhone">
			<input type="text"
				name="<c:out value="${status.expression}"/>"
				value="<c:out value="${status.value}"/>" maxlength="20">
				<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-2" align="center">Address</td>
		<td colspan="3" class="content-1 top-line-2" style="padding: 0 5">
			<spring:bind path="invoice.address1">
			<input type="text" name="${status.expression}" value="${status.value}" maxlength="20" style="width:450">
			<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-1" align="center">Address</td>
		<td colspan="3" class="content-1 top-line-1" style="padding: 0 5">
			<spring:bind path="invoice.address2">
			<input type="text" name="${status.expression}" value="${status.value}" maxlength="20" style="width:450">
			<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>

	<tr height="25">
		<td class="header-1 top-line-1" align="center">Postcode</td>
		<td class="content-1 top-line-1" style="padding: 0 5">
			<spring:bind path="invoice.postcode">
			<input type="text" name="${status.expression}" value="${status.value}" maxlength="20" style="width:80">
			<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>

		<td class="header-1 top-line-1" align="center">State</td>
		<td class="content-1 top-line-1" style="padding: 0 5">
			<spring:bind path="invoice.state">
			<input type="text" name="${status.expression}" value="${status.value}" maxlength="20" style="width:120">
			<font color="red"><c:out value="${status.errorMessage}"/></font>
			</spring:bind>
		</td>
	</tr>
</table>
<input type="submit" value="Update" class="button mini blue" style="position:relative;top:10;left:560">
			
<spring:bind path="invoice.id">
	<input type="hidden" name="id" value="${invoice.id}">
</spring:bind>
			
</form>
</div>

<div style="position:relative;top:50;left:10">
<table class="solid-border-1" border="0" cellpadding="0" cellspacing="0">
	<tr height="25">
		<td class="header-1" align="center" width="80">Ref No.</td>
		<td class="header-1" width="220">제품명</td>
		<td class="header-1" align="center" width="60">수량</td>
		<td class="header-1" align="center" width="80">가격</td>
		<td class="header-1" align="center" width="60">처리상태</td>
		<td class="header-1" align="center" width="80">주문일</td>
		<td class="header-1" align="center" width="80">업데이트</td>
	</tr>
	
	<spring:bind path="invoice.order">
	<c:forEach items="${status.value }" var="odr">
	<tr height="25">
		<td align="center" class="content-1 top-line-1"><a href="orderDetail.oz?id=${odr.orderId }">${odr.orderId }</a></td>
		<td class="content-1 top-line-1">${odr.productName }</td>
		<td align="center" class="content-1 top-line-1">${odr.amount }</td>
		<td align="center" class="content-1 top-line-1">${odr.price }</td>
		<td align="center" class="content-1 top-line-1">${odr.status }</td>
		<td align="center" class="content-1 top-line-1">${odr.createDate }</td>
		<td align="center" class="content-1 top-line-1">${odr.lastUpdate }</td>
	</tr>
	</c:forEach>
	</spring:bind>
</table>
</div></td></tr></table></center>
</body>
</html>