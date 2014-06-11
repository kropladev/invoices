<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="<spring:url value='/resources'/>/fancybox/jquery.fancybox.js"></script>
<script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
		//	$(".modalbox").fancybox();
		});
	</script>
			<div id="section_edit" class="floatLeft">
				<form:form action="invoiceDo.htm" method="POST" commandName="invoice">
					<div class="floatleft">
						<div class="floatLeft">
							<table id="invDetailsTable">
								<tr>
									<td>Invoice ID2</td>
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
								<tr>
									<td>Mo Time</td>
									<td><form:input type="datetime-local" path="moTime"></form:input></td>
								</tr>
							</table>
						</div>
					<!-- 	<div class="floatLeft">
							<table>
								
							</table>
						</div> -->
					</div>
					<div class="floatLeft" id="action_buttons">
						<table>
							<tr>
								<td colspan="4">
									<!-- <button type="submit" name="action" value="Add">Add</button> -->
									<button type="button" name="editable" id="buttonEditable">Edit</button>
	 								<button type="submit" name="action" id="buttonEditSubmit" value="Edit">Submit</button>
									<button type="submit" name="action" value="Delete">Delete</button>
									<!-- <button id="button" type="submit" name="action" value="Search">Search</button> -->
								</td>
							</tr>
						</table>
					</div>
				</form:form>
			</div>