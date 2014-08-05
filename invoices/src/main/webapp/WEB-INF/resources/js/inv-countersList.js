var contextStringA = "counter"; 
		
$(document).ready(function() {
	prepareShowDetailsWindow();
	addNewElemAction();
});
		
		
function resetCounterDetailsData(counter){
	console.log(counter);
	$("#counterDetailsTable #id").val(counter.id);
	console.log(counter.id);
	$("#counterDetailsTable #serial").val(counter.name);
	console.log(counter.name);
	$("#counterDetailsTable #description").val(counter.description);
	console.log(counter.description);
	$("#counterDetailsTable #active").val(counter.active);

}
		