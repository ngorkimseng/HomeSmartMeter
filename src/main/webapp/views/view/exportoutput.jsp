<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body>
<table class="table table-hover">
<tr>
<th>ID</th>
<th>Name</th>
<th>Power</th>
<th>Water</th>
<th></th>
</tr>
<tr>
<td>${data.id}</td>
<td>${data.name}</td>
<td>${data.power}</td>
<td>${data.water}</td>
<td><button class="btn btn-success">Export</button></td>
</tr>
</table>
	
</body>
</html>



