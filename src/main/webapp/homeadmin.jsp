<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin main menu</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>

<div class="header">D<img class="imgheader" src="css/DoserLogo.svg" alt="DoserLogo">SER
</div>


<div class="navbar">
  <a class="active" href="homeadmin.jsp">Home</a>
  <a href="UserManagerServlet?mode=userlist">Users</a>
  <a href="BuildingManagerServlet?mode=buildinglist">Buildings</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">

<h1>Welcome ${user}</h1>

</div>
</body>
</html>