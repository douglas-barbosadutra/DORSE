<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.BuildingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Building</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a href="UserManagerServlet?mode=userlist">Users</a>
  <a href="BuildingManagerServlet?mode=buildinglist">Buildings</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

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

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>