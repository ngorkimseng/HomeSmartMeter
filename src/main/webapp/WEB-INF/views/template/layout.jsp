<%@page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  	<spring:url value="/resources/public/uikit/css/uikit.min.css" var="uikitCSS"/>
  	
  	<spring:url value="/resources/public/font-awesome/css/font-awesome.min.css" var="fontawesome"/>
  	<spring:url value="/resources/public/css/style.css" var="customCSS"/>
  	
  	<spring:url value="/resources/public/uikit/js/uikit.min.js" var="uikitJS"/>
  	<spring:url value="/resources/jspdf/libs/FileSaver/FileSaver.min.js" var="fileSaverJS"/>
  	<spring:url value="/resources/jspdf/libs/js-xlsx/xlsx.core.min.js" var="xlsxJS"/>
  	<spring:url value="/resources/jspdf/libs/jsPDF/jspdf.min.js" var="jspdfJS"/>
  	<spring:url value="/resources/jspdf/libs/jsPDF-AutoTable/jspdf.plugin.autotable.js" var="jspdfAutoTableJS"/>
  	<spring:url value="/resources/jspdf/tableExport.min.js" var="tableExportJS"/>
  	<spring:url value="/resources/public/js/main.js" var="mainJS"/>
  	
  	<link href="${uikitCSS}" rel="stylesheet"/>
  	<link href="${fontawesome}" rel="stylesheet"/>
  	<link href="${customCSS}" rel="stylesheet"/>
</head>

<body>

<div class="loading-spinner"></div>
    <div class="site">
        <tiles:insertAttribute name="navigation" />
        <div class="site-content">
            <div class="top_jumbotron">
                <div class="uk-container">
                    <div class="text_wrapper uk-text-center">
                        <h1 class="heading">
                            We are Escott Team
                        </h1>
                        <p class="team_desc">
                            We build and manage IOT (Internet Of Things) System.
                        </p>
                    </div>
                </div>
            </div>

            <div class="section_menu_bar uk-flex  uk-flex-center">
                <ul class="section_menu_nav uk-flex-inline uk-flex-wrap-around" uk-switcher="connect: .section_container">
                    <li>
                        <a id="dashboardMenu" href="#">Dashboard</a>
                    </li>
                    <li>
                        <a id="sourceMenu" href="#">Source</a>
                    </li>
                    <li>
                        <a id="eventMenu" href="#">Event</a>
                    </li>
                    <li>
                        <a id="exportMenu" href="#">Export</a>
                    </li>
                </ul>
            </div>
            
            <tiles:insertAttribute name="body" />
            
            </div>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="${uikitJS}"></script>
		<script src="${fileSaverJS}"></script>
		<script src="${xlsxJS}"></script>
		<script src="${jspdfJS}"></script>
		<script src="${jspdfAutoTableJS}"></script>
		<script src="${tableExportJS}"></script>
		<script src="${mainJS}"></script>
<!-- 		<script>
		    $(document).ready(function(){
		    	$(".js-example-basic-multiple").select2();
		    	var date_input=$('input[name="date"]');
		        var options={
		          format: 'mm/dd/yyyy',
		          todayHighlight: true,
		          autoclose: true,
		        };
		        date_input.datepicker(options);
		    });
		</script> -->
	</body>
</html>
		
