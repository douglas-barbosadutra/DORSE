<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<h1>Edit user</h1>

<%UserDTO u = (UserDTO) request.getAttribute("dto");%>



		<form action="UserManagerServlet?mode=update&id=<%=u.getId()%>" method="post">

		Username: <input type="text" id="user" name="username"
			value=<%=u.getUsername()%>>
		Password: <input
			type="text" id="pass" name="password"
			value=<%=u.getPassword()%>> 
		Usertype: <input
			type="text" id="type" name="usertype"
			value=<%=u.getUsertype()%>>

		<button type="submit"  name="pulsante">Edit</button>
		</form>		
	
</body>
</html>