<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="it.contrader.dto.BuildingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Building</title>
</head>
<body>
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