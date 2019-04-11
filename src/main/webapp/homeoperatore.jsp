<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.*" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Principale Operatore</title>
</head>
<body>
	<h1>Benvenuto ${utente}</h1>
	<h2>MENU PRINCIPALE OPERATORE</h2>
<br>

<%if (request.getAttribute("view")==null) {%>
<a href="BuildingManagerServlet?mode=buildinglistOP"> Visualizza i Building </a>
<%}%>
<br>

<%if (request.getAttribute("view")=="buildings") {
List<BuildingDTO> buildinglist = (List<BuildingDTO>) request.getAttribute("buildinglistOP");%>

<table>
<tr> 
	<th>Indirizzo</th>
	<th>User</th>
</tr>
<%for(BuildingDTO b: buildinglist) {%> 
<tr>
	<td> 
		<a href=BuildingManagerServlet?mode=read&id=<%=b.getId()%>><%=b.getIndirizzo()%></a>
	</td>
	<td> 
		<%=b.getUserId()%>
	</td>
	<td>
	<a href=AmbienteManagerServlet?mode=ambientelistby&id=<%=b.getId()%>>Visualizza gli Ambienti</a>
		</td>
</tr>	
<%} %>
</table>
<%}%>



</body>
</html>