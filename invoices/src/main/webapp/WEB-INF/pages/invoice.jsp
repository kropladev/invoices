<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/includes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css" title="currentStyle">
@import
	"<spring:url value='/resources'/>/css/redmond/jquery-ui-1.10.4.custom.css"
	;

@import "<spring:url value='/resources'/>/css/demo_page.css";

@import "<spring:url value='/resources'/>/css/demo_table.css";

@import "<spring:url value='/resources'/>/css/invoices.css";
</style>
<script type="text/javascript"
	src="<spring:url value='/resources'/>/js/jquery.js"></script>
<script type="text/javascript"
	src="<spring:url value='/resources'/>/js/jquery-ui.custom.js"></script>
<script type="text/javascript"
	src="<spring:url value='/resources'/>/js/jquery.dataTables.js"></script>

</head>
<body>
	<div id="page">
		<div id="menu" class="floatLeft">
			<p>Menu</p>
		</div>
		<div id="container" class="floatLeft">
			<div id="section_edit">
				<form:form action="invoiceDo.htm" method="POST" commandName="invoice">
					<div class="floatLeft">
						<table>
							<tr>
								<td>Invoice ID</td>
								<td><form:input path="id"></form:input></td>
							</tr>
							<tr>
								<td>Name</td>
								<td><form:input path="name"></form:input></td>
							</tr>
							<tr>
								<td>Desc</td>
								<td><form:input path="description"></form:input></td>
							</tr>
							<tr>
								<td>Amount</td>
								<td><form:input path="amount"></form:input></td>
							</tr>
							<tr>
								<td>Invoice symbol</td>
								<td><form:input path="invoiceId"></form:input></td>
							</tr>
							<tr>
								<td>Category</td>
								<td><form:input path="category"></form:input></td>
							</tr>
							<tr>
								<td>Pay Date</td>
								<td><form:input type="date" path="payDate"></form:input></td>
							</tr>
						</table>
					</div>
					<div class="floatLeft">
						<table>
							<tr>
								<td>Mo Time</td>
								<td><form:input type="date-time local" path="moTime"></form:input></td>
							</tr>
						</table>
					</div>
					<table>
						<tr>
							<td colspan="4">
								<button type="submit" name="action" value="Add">Add</button>
								<button type="submit" name="action" value="Edit">Edit</button>
								<button type="submit" name="action" value="Delete">Delete</button>
								<button id="button" type="submit" name="action" value="Search">Search</button>
							</td>
						</tr>
					</table>
				</form:form>
			</div>
			<div id="section_dataList">
				<table cellpadding="0" cellspacing="0" border="0" class="display"
					id="example" width="100%">
					<thead>
						<tr>
							<th>ID</th>
							<th>name</th>
							<th>desc</th>
							<th>amount</th>
							<th>symbol</th>
						</tr>
					</thead>
					<c:forEach items="${invoiceList}" var="invoice">
						<tr>
							<td>${invoice.id}</td>
							<td>${invoice.name}</td>
							<td>${invoice.description}</td>
							<td>${invoice.amount}</td>
							<td>${invoice.invoiceId}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
			$('#example').dataTable();
			$("button").button();
			// 			/* $('#section_edit').position({
			// 				  my: "center",
			// 				  at: "center",
			// 				  of: "#container"
			// 				}); */
		});
	</script>
</body>
</html>