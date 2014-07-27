	var oTable;

		$(document).ready(function() {
			/* Init the table */
			var oTable = $("#listOfElements").DataTable({
				"bJQueryUI": true,
				"sDom": '<"H"<"#tableTitle">f<"clear">r<"#addButtonContainer">>t<"F"ip<"#tableLengthContainer"l>>',
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
				
				var url = getContextPath()+"/axInvDetails/"+clickedInvoiceId;
				console.log("Url:"+url);
				$.get(url ,function(resultData){
					console.log("resultData:"+resultData);
					resetInvoiceDetailsData(resultData);
				});
					
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