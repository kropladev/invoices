<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript"
	src="<spring:url value='/resources'/>/fancybox/jquery.fancybox.js"></script>
<div id="section_edit" class="floatLeft register">
	<form:form action="/invoice/edit" method="POST" commandName="invoice">
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
		<div class="floatLeft" id="action_buttons">
			<table>
				<tr>
					<td colspan="4">
						<button type="button" name="editable" id="buttonEditable">Edit</button>
						<button type="submit" name="saveButton" id="buttonSave"
							value="Save">Save</button>
						<button type="submit" name="deleteButton" id="deleteButton" value="Delete">Delete</button>
						<button type="button" name="cancelButton" id="cancelButton" value="Cancel">Cancel</button>
					</td>
				</tr>
			</table>
		</div>
	</form:form>
</div>