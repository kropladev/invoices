var contextStringA = "read"; 
		
$(document).ready(function() {
	prepareShowDetailsWindow();
	addNewElemAction();
});
		
		
function resetReadsData(elem){
	console.log(elem);
	$("#counterDetailsTable #id").val(elem.id);
	console.log(counter.id);
	$("#counterDetailsTable #date").val(elem.date);
	console.log(counter.name);
}
		