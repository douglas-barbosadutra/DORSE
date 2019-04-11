<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Ambienti del building ?</title>
</head>
<body>
<h1>Ambienti del building ?</h1>





<%List<AmbienteDTO> ambientelist = (List<AmbienteDTO>) request.getAttribute("ambientelist");%>



<table>
	<tr> 
		<th>Descrizione</th>
		<th>Building</th>
	</tr>
	<%for(AmbienteDTO a: ambientelist) {%> 
	<tr>
		<td> 
			<a href=AmbienteManagerServlet?mode=read&id=<%=a.getId()%>><%=a.getDescrizione()%></a>
		</td>
		<td> 
			<a href=BuildingManagerServlet?mode=read&id=<%=a.getBuildingid()%>><%=a.getBuildingid()%></a>
		</td>
		<td><a href=AmbienteManagerServlet?mode=preupdate&id=<%=a.getId()%>>Modifica</a>
			</td>
		<td><a href=AmbienteManagerServlet?mode=delete&id=<%=a.getId()%>>Cancella</a>
	</tr>	
	<%} %>
</table>



	<h2>Inserisci un nuovo ambiente in questo building</h2>

	<form
		action="AmbienteManagerServlet" method="get">

		Descrizione: <input type="text" id="tipo" name="descrizione"
			placeholder="inserisci la descrizione"> <input type="hidden"
			name="mode" value="insert">
		<input type="hidden" name="buildingid"
			value="<%=request.getParameter("buildingid")%>">
		<button type="submit">Inserisci</button>
	</form>




	<%
		if (request.getAttribute("ans") != null) {
			String mode = request.getParameter("mode");
			boolean ans = (boolean) request.getAttribute("ans");
			switch (mode) {
			case "insert":
				if (ans) {
	%>
	<h3>L'inserimento è andato alla grande!</h3>
	<%
		} else {
	%>
	<h3>Ritenta, sarai più fortunato...</h3>
	<%
		}
				break;
			case "delete":
				if (ans) {
	%>
	<h3>La cancellazione è andata alla grande!</h3>
	<%
		} else {
	%>
	<h3>Ritenta, sarai più fortunato...</h3>
	<%
		}
				break;
			case "update":
				if (ans) {
	%>
	<h3>La modifica è andata alla grande!</h3>
	<%
		} else {
	%>
	<h3>Ritenta, sarai più fortunato...</h3>
	<%
		}
				break;
			}
		}
	%>

</body>
</html>