<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="<spring:url value='/resources'/>/fancybox/jquery.fancybox.js"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		//	$(".modalbox").fancybox();
	});
</script>
<div id="section_edit" class="floatLeft register">
	<form:form action="invoiceDo.htm" method="POST" commandName="invoice">
		<div id="invDetailsTable">
			<!-- <table id="invDetailsTable"> -->
			<div>
				<label>Invoice ID2</label>
				<form:input path="id"></form:input>
			</div>
			<div>
				<label>Name</label>
				<form:input path="name"></form:input>
			</div>
			<div>
				<label>Desc</label>
				<form:input path="description"></form:input>
			</div>
			<div>
				<label>Amount</label>
				<form:input path="amount"></form:input>
			</div>
			<div>
				<label>Invoice symbol</label>
				<form:input path="invoiceId"></form:input>
			</div>
			<div>
				<label>Category</label>
				<form:input path="category"></form:input>
			</div>
			<div>
				<label>Pay Date</label>
				<form:input type="date" path="payDate"></form:input>
			</div>
			<div>
				<label>Mo Time</label>
				<form:input type="datetime-local" path="moTime"></form:input>
			</div>
		</div>
		<!-- 	<div class="floatLeft">
							<table>
								
							</table>
						</div> -->
		<div class="floatLeft" id="action_buttons">
			<table>
				<tr>
					<td colspan="4">
						<!-- <button type="submit" name="action" value="Add">Add</button> -->
						<button type="button" name="editable" id="buttonEditable">Edit</button>
						<button type="submit" name="action" id="buttonEditSubmit"
							value="Edit">Submit</button>
						<button type="submit" name="action" value="Delete">Delete</button>
						<!-- <button id="button" type="submit" name="action" value="Search">Search</button> -->
					</td>
				</tr>
			</table>
		</div>
	</form:form>
</div>