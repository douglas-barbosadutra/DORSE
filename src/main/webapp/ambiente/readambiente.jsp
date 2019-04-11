<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.*" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lettura Ambiente</title>
</head>
<body>
	<h1>Pagina di lettura Ambiente</h1>

	<%AmbienteDTO a = (AmbienteDTO) request.getAttribute("dto");
	List<ItemDTO> list = (List<ItemDTO>) request.getAttribute("list");%>


	<table>
		<tr>
			<th>Descrizione</th>
			<th>Building</th>

		</tr>
		<tr>
			<td><%=a.getDescrizione()%></td>
			<td><%=a.getBuildingid()%></td>

		</tr>
	</table>

<a href="ItemManagerServlet?mode=itemlistby&ambientId=<%=a.getId()%>" > Gestisci Item</a>

</body>
</html>