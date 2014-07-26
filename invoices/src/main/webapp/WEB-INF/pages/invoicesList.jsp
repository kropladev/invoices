<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
		<script type="text/javascript"
			src="<spring:url value='/resources'/>/js/inv-invoicesList.js"></script>	
        
        
        
        