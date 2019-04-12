<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.BuildingDTO" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Building manager</title>
</head>
<body>


<% List<BuildingDTO> list = (List<BuildingDTO>) request.getAttribute("list");
List<UserDTO> operatorList = (List<UserDTO>)request.getAttribute("operatorList");
List<UserDTO> clientList = (List<UserDTO>)request.getAttribute("clientList");%>

<table>
	<tr> 
		<th>Address</th>
		<th>User</th>
		<th>Operator</th>
	</tr>
	<% for(BuildingDTO b: list) {%> 
	<tr>
		<td> 
			<a href=BuildingManagerServlet?mode=read&id=<%=b.getId()%>><%=b.getIndirizzo()%></a>
		</td>
		<td> 
			<a href=UserManagerServlet?mode=read&id=<%=b.getUserId()%>><%=b.getUserId()%></a>
		</td>
		<td> 
			<a href=UserManagerServlet?mode=read&id=<%=b.getOperatorId()%>><%=b.getOperatorId()%></a>
		</td>
		<td><a href=BuildingManagerServlet?mode=preupdate&id=<%=b.getId()%>>Edit</a>
			</td>
		<td><a href=BuildingManagerServlet?mode=delete&id=<%=b.getId()%>>Delete</a>
	</tr>	
	<%} %>
</table>


	<h2>Insert new building</h2>

	<form action="BuildingManagerServlet?mode=insert" method="post">

		Address: <input type="text" id="indirizzo" name="indirizzo"
			placeholder="inserisci l'indirizzo">
		Client: <select name="userId">
		<% for (UserDTO c : clientList) { %>
  			<option value="<%=c.getId()%>"><%=c.getUsername()%></option>
  <% } %>
  </select>
		Operator: <select name="operatorId">
		<% for (UserDTO op : operatorList) { %>
  			<option value="<%=op.getId()%>"><%=op.getUsername()%></option>
  <% } %>
</select>
			
		<button type="submit"  name="pulsante">Insert</button>
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
	<h3>Insert failed</h3>
	<%
		}
				break;
			case "delete":
				if (ans) {
	%>
	<h3>Delete successful</h3>
	<%
		} else {
	%>
	<h3>Delete failed</h3>
	<%
		}
				break;
			case "update":
				if (ans) {
	%>
	<h3>Update successful</h3>
	<%
		} else {
	%>
	<h3>Update failed</h3>
	<%
		}
				break;
			}
		}
	%>


</body>
</html>