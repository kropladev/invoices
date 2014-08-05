<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript"
	src="<spring:url value='/resources'/>/fancybox/jquery.fancybox.js"></script>
<div id="section_edit" class="floatLeft register">
	<form:form id="mainForm" action="/counter/edit" method="POST" commandName="counter">
		<div id="counterDetailsTable">
			<!-- <table id="invDetailsTable"> -->
			<div>
				<label>Counter ID</label>
				<form:input path="id"></form:input>
			</div>
			<div>
				<label>Serial</label>
				<form:input path="serial"></form:input>
			</div>
			<div>
				<label>Desc</label>
				<form:input path="description"></form:input>
			</div>
			<div>
				<label>Active</label>
				<form:input path="active"></form:input>
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