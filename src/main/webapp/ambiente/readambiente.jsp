<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.*" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ambient</title>
</head>
<body>
	<h1>Ambient</h1>

	<%AmbienteDTO a = (AmbienteDTO) request.getAttribute("dto");
	%>


	<table>
		<tr>
			<th>Description</th>
			<th>Building</th>

		</tr>
		<tr>
			<td><%=a.getDescrizione()%></td>
			<td><%=a.getBuildingid()%></td>

		</tr>
	</table>

<a href="ItemManagerServlet?mode=itemlistby&ambientId=<%=a.getId()%>" > Manage items</a>

</body>
</html>