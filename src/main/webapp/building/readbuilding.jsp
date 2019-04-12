<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="it.contrader.dto.BuildingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
<title>Building</title>
</head>
<body>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a href="UserManagerServlet?mode=userlist">Users</a>
  <a href="BuildingManagerServlet?mode=buildinglist">Buildings</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
	<h1>Building</h1>

	<%
		BuildingDTO b = (BuildingDTO) request.getAttribute("dto");
	%>


	<table>
		<tr>
			<th>Address</th>
			<th>User</th>
			<th>Operator</th>
		</tr>
		<tr>
			<td><%=b.getIndirizzo()%></td>
			<td><%=b.getUserId()%></td>
			<td><%=b.getOperatorId()%></td>
		</tr>
	</table>

</body>
</html>