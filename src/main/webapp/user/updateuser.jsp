<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Utente</title>
</head>
<body>
<h1>Pagina di modifica utente</h1>

<%UserDTO u = (UserDTO) request.getAttribute("dto");%>



		<form action="UserManagerServlet?mode=update&id=<%=u.getId()%>" method="post">

		username: <input type="text" id="user" name="username"
			value=<%=u.getUsername()%>>
		password: <input
			type="text" id="pass" name="password"
			value=<%=u.getPassword()%>> 
		usertype: <input
			type="text" id="type" name="usertype"
			value=<%=u.getUsertype()%>>

		<button type="submit"  name="pulsante">Modifica</button>
		</form>		
	
</body>
</html>