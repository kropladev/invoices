var contextStringA = "invoice"; 

$(document).ready(function() {
	prepareShowDetailsWindow(contextStringA);
	addNewElemAction(contextStringA);
});

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
	