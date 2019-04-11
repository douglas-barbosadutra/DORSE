<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.BuildingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Building</title>
</head>
<body>


<% List<BuildingDTO> list = (List<BuildingDTO>) request.getAttribute("list");%>

<table>
	<tr> 
		<th>Indirizzo</th>
		<th>User</th>
	</tr>
	<% for(BuildingDTO b: list) {%> 
	<tr>
		<td> 
			<a href=BuildingManagerServlet?mode=read&id=<%=b.getId()%>><%=b.getIndirizzo()%></a>
		</td>
		<td> 
			<a href=UserManagerServlet?mode=read&id=<%=b.getUserId()%>><%=b.getUserId()%></a>
		</td>
		<td><a href=BuildingManagerServlet?mode=preupdate&id=<%=b.getId()%>>Modifica</a>
			</td>
		<td><a href=BuildingManagerServlet?mode=delete&id=<%=b.getId()%>>Cancella</a>
	</tr>	
	<%} %>
</table>


	<h2>Inserisci un nuovo building</h2>

	<form action="BuildingManagerServlet?mode=insert" method="post">

		Indirizzo: <input type="text" id="indirizzo" name="indirizzo"
			placeholder="inserisci l'indirizzo">
		Id Utente: <input
			type="text" id="user" name="userId"
			placeholder="inseriscil'ID dello user"> 
			
		<button type="submit"  name="pulsante">Inserisci</button>
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