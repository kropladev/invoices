	var oTable;
	//var actualAction;
		
		$(document).ready(function() {
			
			loadDatatables();
			loadTableTitle();
			injectAddButton();
			setFormButtonsActions();
			
			//addNewElemAction();
			/* Add a click handler to the rows - this could be used as a callback */
			/*hide submit button and...*/
		//	$("#buttonSave").hide();
		
			$("button").button();
		});
		
		function setFormButtonsActions() {
			$("#cancelButton").on("click",function (){
				$.fancybox.close();
			});
		}
		
		function loadDatatables(){
			var oTable = $("#listOfElements").DataTable({
				"bJQueryUI": true,
				"sDom": '<"H"<"#tableTitleT">fr<"#addButtonContainer">>t<"F"ip<"#tableLengthContainer"l>>',
				"aoColumnDefs": [ { 'bSortable': false, 'aTargets': [ -1 ] }],
				 "pagingType":"simple_numbers"
				 //"sPaginationType": "extStyle"
			});
		}

		function injectAddButton () {
			var buttonToAdd =$("<a />").attr("href","#").attr("id","addButton").addClass("buttons").addClass("addButton");
			$("#addButtonContainer").append(buttonToAdd);
		}
		
		function addNewElemAction() {
			$("#addButton").on("click", function() {
				prepareNewBlankForm(contextStringA);
			});
		}
		
		function prepareNewBlankForm () {
			var url = getContextPath() + "/" + contextStringA + "/new.json";
			console.log("Url:"+url);
	
			$.get(url ,function(resultData){
				console.log("resultData:"+resultData);
				resetDetailsData(contextStringA,resultData);
			});
			prepareMainForm("create");
			initFancyBox('#section_edit');
		}
		
		function prepareMainForm(action) {
			$("#mainForm").attr("action",getContextPath()+"/"+contextStringA+"/"+action);
			if (action == "create") {
				$("#buttonEditable").hide();
				$("#deleteButton").hide();
				$("#buttonSave").show();
				
			} else if (action == "view") {
				$("#buttonEditable").show();
				$("#deleteButton").hide();
				$("#buttonSave").hide();
				
			} else if (action == "remove") {
				$("#buttonEditable").hide();
				$("#deleteButton").show();
				$("#buttonSave").hide();
				
			}  else if (action == "edit") {
				$("#buttonEditable").hide();
				$("#deleteButton").hide();
				$("#buttonSave").show();
			} 
		}
		
		function loadTableTitle() {
			var title = $("#tableTitle").val();
			//$("#tableTitle").append($("<div/>").append("List of invoices"));
			$("#tableTitleT").append($("<div/>").append(title));
		}

		function prepareShowDetailsWindow () {
			/* ...open fancybox with invoice details*/
			$("#listOfElements tbody tr").click(function(e) {
				var clickedId=$(this).find('td[id="invId"]').text();
				console.log("clickedId::"+clickedId);
				if (clickedId > 0) {
					var url = getContextPath() + "/" + contextStringA + 
							"/" + clickedId + "/details.json";
					console.log("Url:"+url);
					prepareMainForm("view");
					$.get(url ,function(resultData){
						console.log("resultData:"+resultData);
						resetDetailsData(contextStringA,resultData);
					});
					
					initFancyBox('#section_edit');
					
					/* disable details table on start */
					$("#invDetailsTable input").prop('disabled', true);

					//make all inputs in details table editable on 'Edit' button click 
					$("#buttonEditable").click(function(f) {
						$("#invDetailsTable input").prop('disabled', false);
						$(this).hide();
						$("#buttonSave").show();
					});
				}
			});
		}
		
		function  resetDetailsData(context, objectData) {
			if (context == "invoice") {
				resetInvoiceDetailsData(objectData);
			} else if (context == "counter") {
				resetCounterDetailsData(objectData);
			} else if (context == "read") {
				resetReadsData(objectData);
			}
		}
		
		function initFancyBox(sectionId){	
			/* section_edit is hide by css invoice.css */
			/* declare fancybox object */
			$.fancybox({
				href : sectionId,
				title : 'Invoice\'s details',
				afterClose : function() {
					//when user clicks 'Close' box button::
					//hide submit button where box is about to close
					//$("#buttonSave").hide();
					//show editable button
					//$("#buttonEditable").show();
				}
			});
		}
			
		
