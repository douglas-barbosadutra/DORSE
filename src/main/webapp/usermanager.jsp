<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Utenti</title>
</head>
<body>


<% List<UserDTO> userlist = (List<UserDTO>)request.getAttribute("userlist");%>

<table>
	<tr> 
		<th>Username</th>
		<th>Password</th>
		<th>Usertype</th>
	</tr>
	<% for(UserDTO u: userlist) {%> 
	<tr>
		<td> 
			<%=u.getUsername()%>
		</td>
		<td> 
			<%=u.getPassword()%>
		</td>
		<td> 
			<%=u.getUsertype()%>
		</td>
	</tr>	
	<%} %>
</table>

</body>
</html>