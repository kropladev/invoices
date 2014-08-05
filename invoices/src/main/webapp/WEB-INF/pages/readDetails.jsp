<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript"
	src="<spring:url value='/resources'/>/fancybox/jquery.fancybox.js"></script>
<div id="section_edit" class="floatLeft register">
	<form:form id="mainForm" action="/read/edit" method="POST" commandName="elem">
		<div id="elemDetailsTable">
			<!-- <table id="invDetailsTable"> -->
			<div>
				<label>Counter ID</label>
				<form:input path="id"></form:input>
			</div>
			<div>
				<label>Date</label>
				<form:input path="readDate"></form:input>
			</div>
			
			<div>
			<hr>
				<p> Counter Statuses </p>
					<div>
						<label>Counter</label>
						<form:select path="status.counter" >
							<form:options items="${counterList}"  itemLabel="serial" itemValue="id" />
						</form:select>
					</div>
					<div>
						<label>Amount</label>
						<form:input path="status.amount"/>
					</div>
					<div><form:</div>
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