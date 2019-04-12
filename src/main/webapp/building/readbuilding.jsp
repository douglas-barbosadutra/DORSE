<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="it.contrader.dto.BuildingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lettura Building</title>
</head>
<body>
	<h1>Pagina di lettura Building</h1>

	<%
		BuildingDTO b = (BuildingDTO) request.getAttribute("dto");
	%>


	<table>
		<tr>
			<th>Indirizzo</th>
			<th>User</th>
			<th>Operatore</th>
		</tr>
		<tr>
			<td><%=b.getIndirizzo()%></td>
			<td><%=b.getUserId()%></td>
			<td><%=b.getOperatorId()%></td>
		</tr>
	</table>

</body>
</html>