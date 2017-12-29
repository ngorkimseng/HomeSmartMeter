<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
	<title>SpringMVC Tutorials</title>
</head>

<body>
	<h3>SpringMVC-Tiles-Integration</h3>

	<spring:url value="dashboard" var="go" htmlEscape="true" />
	<a href="${go}">View Data (with the template content)</a>
</body>
</html>
