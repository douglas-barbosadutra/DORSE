<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lettura Utente</title>
</head>
<body>

<h1>Pagina di lettura utente</h1>

<%UserDTO u = (UserDTO) request.getAttribute("userToRead");%>


<table>
	<tr> 
		<th>Username</th>
		<th>Password</th>
		<th>Usertype</th>
	</tr>
	<tr>
		<td><%=u.getUsername()%></td>
		<td> <%=u.getPassword()%></td>
		<td> <%=u.getUsertype()%></td>
	</tr>	
</table>
















</body>
</html>