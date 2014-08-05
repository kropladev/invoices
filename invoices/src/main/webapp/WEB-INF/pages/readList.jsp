<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<div id="content" class="content floatLeft">
			<div id="tableWrapper" >
				<div id="tableTitleContainer">
					<input type="hidden" value="${tableTitle}" id="tableTitle"/>
				</div>
				<table cellpadding="0" cellspacing="0" border="0" class="display"
					id="listOfElements" width="100%">
					<thead>
						<tr>
							<th>ID</th>
							<th>date</th>
							<th>counters</th>
						</tr>
					</thead>
					<c:forEach items="${elemList}" var="elem">
						<tr>
							<td id='invId'>${elem.id}</td>
							<td>${elem.readDate}</td>
							<td>
							<c:forEach items="${elem.counterStatusesList}" var="subElem">
								<p>${subElem.id}</p>
							</c:forEach> 
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<script type="text/javascript"
			src="<spring:url value='/resources'/>/js/inv-common.js"></script>	
		<script type="text/javascript"
			src="<spring:url value='/resources'/>/js/inv-readList.js"></script>	    
        
        
        
        