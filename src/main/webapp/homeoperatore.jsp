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

<a href="BuildingManagerServlet?mode=buildinglistOP"> Visualizza i Building </a>


<%if (request.getAttribute("view")=="buildings") {
List<BuildingDTO> list = (List<BuildingDTO>) request.getAttribute("list");%>

<table>
<tr> 
	<th>Indirizzo</th>
	<th>User</th>
</tr>
<%for(BuildingDTO b: list) {%> 
<tr>
	<td> 
		<a href=AmbienteManagerServlet?mode=ambientelistby&buildingId=<%=b.getId()%>><%=b.getIndirizzo()%></a>
	</td>
	<td> 
		<%=b.getUserId()%>
	</td>
</tr>	
<%} %>
</table>
<%}%>

<br> </br>

<form action="LogoutServlet" method="post">
<button type="submit" value="Logout" name="pulsante">Logout</button>
</form>

</body>
</html>