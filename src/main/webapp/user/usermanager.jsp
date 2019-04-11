<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Utenti</title>
</head>
<body>


	<%
		List<UserDTO> list = (List<UserDTO>) request.getAttribute("list");
	%>

	<table>
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Usertype</th>
		</tr>
		<%
			for (UserDTO u : list) {
		%>
		<tr>
			<td><a href=UserManagerServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getUsername()%>
			</a></td>
			<td><%=u.getPassword()%></td>
			<td><%=u.getUsertype()%></td>
			<td><a href=UserManagerServlet?mode=readtoupdate&id=<%=u.getId()%>>Modifica</a>
			</td>
			<td><a href=UserManagerServlet?mode=delete&id=<%=u.getId()%>>Cancella</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>

	<h2>Inserisci un nuovo utente</h2>

	<form action="UserManagerServlet?mode=insert" method="post">

		username: <input type="text" id="user" name="username"
			placeholder="inserisci username">
		password: <input
			type="text" id="pass" name="password"
			placeholder="inserisci password"> 
		usertype: <input
			type="text" id="type" name="usertype"
			placeholder="inserisci lo usertype">

		<button type="submit" name="pulsante">Inserisci</button>
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