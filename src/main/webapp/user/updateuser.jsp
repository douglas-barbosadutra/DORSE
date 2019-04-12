<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a href="UserManagerServlet?mode=userlist">Users</a>
  <a href="BuildingManagerServlet?mode=buildinglist">Buildings</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<h1>Edit user</h1>

<%UserDTO u = (UserDTO) request.getAttribute("dto");%>



		<form action="UserManagerServlet?mode=update&id=<%=u.getId()%>" method="post">

		Username: <input type="text" id="user" name="username"
			value=<%=u.getUsername()%>>
		Password: <input
			type="text" id="pass" name="password"
			value=<%=u.getPassword()%>> 
		Usertype: <select name="usertype">
  			<option value="admin" <%if(u.getUsertype().equals("admin")) {%>selected<%}%>>admin</option>
  			<option value="operatore" <%if(u.getUsertype().equals("operatore")) {%>selected<%}%>>operator</option>
  			<option value="client" <%if(u.getUsertype().equals("client")) {%>selected<%}%>>client</option>
		</select>

		<button type="submit"  name="pulsante">Edit</button>
		</form>		
	
</body>
</html>