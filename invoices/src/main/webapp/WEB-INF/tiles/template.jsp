<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	        <div id="header"><tiles:insertAttribute name="header"/></div>
	        <div id="menu"><tiles:insertAttribute name="menu"/></div>
	        
	        <div id="body"><tiles:insertAttribute name="body"/></div>
	        <div id="edit"><tiles:insertAttribute name="edit"/></div>
	        
	        <div id="footer"><tiles:insertAttribute name="footer"/></div>
	    </div>
    </body>
</html>