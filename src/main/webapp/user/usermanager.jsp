<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Manager</title>
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
			<td><a href=UserManagerServlet?mode=readtoupdate&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=UserManagerServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>

	<h2>Insert new user</h2>

	<form action="UserManagerServlet?mode=insert" method="post">

		Username: <input type="text" id="user" name="username"
			placeholder="inserisci username">
		Password: <input
			type="text" id="pass" name="password"
			placeholder="inserisci password"> 
		Usertype: <input
			type="text" id="type" name="usertype"
			placeholder="inserisci lo usertype">

		<button type="submit" name="pulsante">Insert</button>
	</form>



	<%
		if (request.getAttribute("ans") != null) {

			String mode = request.getParameter("mode");
			boolean ans = (boolean) request.getAttribute("ans");

			switch (mode) {

			case "insert":

				if (ans) {
	%>
	<h3>Insert successful</h3>
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
	<h3>Insert failed</h3>
	<%
		}
				break;
				
			case "update":

				if (ans) {
	%>
	<h3>Edit successful</h3>
	<%
		} else {
	%>
	<h3>Edit failed</h3>
	<%
		}
				break;

		}

		}
	%>


</body>
</html>