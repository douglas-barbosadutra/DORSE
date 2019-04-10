<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="it.contrader.dto.BuildingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<titleL>Lettura Building
</title>
</head>
<body>
	<h1>Pagina di lettura Building</h1>

	<%
		BuildingDTO b = (BuildingDTO) request.getAttribute("buildingToRead");
	%>


	<table>
		<tr>
			<th>Indirizzo</th>
			<th>User</th>

		</tr>
		<tr>
			<td><%=b.getIndirizzo()%></td>
			<td><%=b.getUserId()%></td>

		</tr>
	</table>

</body>
</html>