<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/includes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css" title="currentStyle">
@import	"<spring:url value='/resources'/>/css/redmond/jquery-ui-1.10.4.custom.css";
@import "<spring:url value='/resources'/>/css/demo_page.css";
@import "<spring:url value='/resources'/>/css/demo_table.css";
/* @import "<spring:url value='/resources'/>/css/invoices.css"; */
@import "<spring:url value='/resources'/>/css/style.css";
@import "<spring:url value='/resources'/>/fancybox/jquery.fancybox.css";
</style>
<script type="text/javascript"
	src="<spring:url value='/resources'/>/js/jquery.js"></script>
<script type="text/javascript"
	src="<spring:url value='/resources'/>/js/jquery-ui.custom.js"></script>
<script type="text/javascript"
	src="<spring:url value='/resources'/>/js/jquery.dataTables.js"></script>

</head>
<body>
	<div id="page" class="page">
	
		<%@ include file="/WEB-INF/pages/template/header.jsp"%>
	
		<%@ include file="/WEB-INF/pages/template/menu.jsp"%>
		
		<p id="breadcrumbs">
    		<span >
        		<span >
            		<a property="title1" rel="#" href="#">Home</a>
		        </span>
    		    <span >
           			<a property="title2" rel="#" href="#">Uncategorized</a>
		        </span>
        		<span >
            		<span property="title3" class="breadcrumb_last">Lorem ipsum</span>
        		</span>
		    </span>
		</p>
		
		<div id="content" class="content floatLeft">
			<div id="tableWrapper" >
				<table cellpadding="0" cellspacing="0" border="0" class="display"
					id="listOfElements" width="100%">
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
							<td id='invId'>${invoice.id}</td>
							<td>${invoice.name}</td>
							<td>${invoice.description}</td>
							<td>${invoice.amount}</td>
							<td>${invoice.invoiceId}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<%@ include file="/WEB-INF/pages/invoiceDetails.jsp"%>
		
		<%@ include file="/WEB-INF/pages/template/footer.jsp"%>	
	</div>
	
	<script type="text/javascript" charset="utf-8">
		var oTable;

		$(document).ready(function() {
			/* Init the table */
			//oTable = $('#listOfElements').dataTable();
			var oTable = $("#listOfElements").DataTable({
				"bJQueryUI": true,
				"sDom": '<"H"<"#tableTitle"><"clear">f<"clear">r<"#addButtonContainer">>t<"F"ip<"#tableLengthContainer"l>>',
				"aoColumnDefs": [ { 'bSortable': false, 'aTargets': [ -1 ] }],
				 "pagingType":"simple_numbers"
				 //"sPaginationType": "extStyle"
			});

			$("#tableTitle").append($("<div/>").append("List of invoices"));
			
			/* Add a click handler to the rows - this could be used as a callback */
			/*hide submit button and...*/
			$("#buttonEditSubmit").hide();
			
			/* ...open fancybox with invoice details*/
			$("#listOfElements tbody tr").click(function(e) {
				var clickedInvoiceId=$(this).find('td[id="invId"]').text();
				console.log("clickedInvoiceId::"+clickedInvoiceId);
				var json = {"invoiceId" : clickedInvoiceId};
				/* $.ajax({
 					type: "GET",	
					  url: "axInvDetails/"+clickedInvoiceId,
					  //datatype : "json",
					 // data: JSON.stringify(json),
				        success: function(result) {
				        	resetInvoiceDetailsData(JSON.parse(result));
				        }
				}); */
			//	/api/person/' + personId, 
				
				//var jsonString = JSON.parse(resultData);
				var url = "${pageContext.request.contextPath}/axInvDetails/"+clickedInvoiceId;
				console.log("Url:"+url);
				$.get(url ,function(resultData){
					console.log("resultData:"+resultData);
					//var jsonParse = JSON.parse(resultData);
					resetInvoiceDetailsData(resultData);
				});
					
			/*		$.getJSON( "axInvDetails.htm" , function ( result ) {
						console.log("ajax call for invoice details + result:"+result);
						resetInvoiceDetailsData(JSON.parse(result));
					});
			*/		
				/* section_edit is hide by css invoice.css */
				/* declare fancybox object */
				$.fancybox({
					href : '#section_edit',
					title : 'Invoice\'s details',
					afterClose : function() {
						//when user clicks 'Close' box button::
						//hide submit button where box is about to close
						$("#buttonEditSubmit").hide();
						//show editable button
						$("#buttonEditable").show();
					}
				});
				/* disable details table on start */
				$("#invDetailsTable input").prop('disabled', true);

				//make all inputs in details table editable on 'Edit' button click 
				$("#buttonEditable").click(function(f) {
					$("#invDetailsTable input").prop('disabled', false);
					$(this).hide();
					$("#buttonEditSubmit").show();
				});
			});

			$("button").button();
			
			function resetInvoiceDetailsData(invoice){
				console.log(invoice);
				$("#invDetailsTable #id").val(invoice.id);
				console.log(invoice.id);
				$("#invDetailsTable #name").val(invoice.name);
				console.log(invoice.name);
				$("#invDetailsTable #description").val(invoice.description);
				console.log(invoice.description);
				$("#invDetailsTable #amount").val(invoice.amount);
				$("#invDetailsTable #invoiceId").val(invoice.invoiceId);
				$("#invDetailsTable #category").val(invoice.category);
				$("#invDetailsTable #payDate").val(invoice.payDate);
				$("#invDetailsTable #moTime").val(invoice.moTime);
			}
			
		});
	</script>
</body>
</html>