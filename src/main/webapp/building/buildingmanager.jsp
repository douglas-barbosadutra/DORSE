<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.BuildingDTO" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Building manager</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@ include file="header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a href="UserManagerServlet?mode=userlist">Users</a>
  <a class="active" href="BuildingManagerServlet?mode=buildinglist">Buildings</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">

<% List<BuildingDTO> list = (List<BuildingDTO>) request.getAttribute("list");
List<UserDTO> operatorList = (List<UserDTO>)request.getAttribute("operatorList");
List<UserDTO> clientList = (List<UserDTO>)request.getAttribute("clientList");%>

<br>


<table>
	<tr> 
		<th>Address</th>
		<th>User</th>
		<th>Operator</th>
			<th></th>
			<th></th>
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






 <form id="floatright" action="BuildingManagerServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label  for="address">Address</label> 
    </div>
    <div class="col-75">
      <input type="text" id="address" name="indirizzo" placeholder="Insert address..."> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="client">Client</label>
    </div>
    <div class="col-75">
      <select id="client" name="userId">
      <option value="0">Select client:</option>
			<%
				for (UserDTO c : clientList) {
			%>
			<option value="<%=c.getId()%>"><%=c.getUsername()%></option>
			<%
				}
			%>
		</select>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label id="floatleft" for="operator">Operator</label>
    </div>
   		 <div class="col-75">
      		<select id="operator" name="operatorId">
      			<option value="0">Select operator:</option>
					<%
						for (UserDTO op : operatorList) {
					%>
					<option value="<%=op.getId()%>"><%=op.getUsername()%></option>
					<%
						}
					%>
			</select>	
    	</div>
  </div>
   
      <button type="submit" >Insert</button>
</form>
   



<%-- 	<%
		if (request.getAttribute("ans") != null) {
			String mode = request.getParameter("mode");
			boolean ans = (boolean) request.getAttribute("ans");
			switch (mode) {
			case "insert":
				if (ans) {
	%>
	<res>Insert successful<res>
	<%
		} else {
	%>
	<res>Insert failed<res>
	<%
		}
				break;
			case "delete":
				if (ans) {
	%>
	<res>Delete successful</res>
	<%
		} else {
	%>
	<res>Delete failed<res>
	<%
		}
				break;
			case "update":
				if (ans) {
	%>
	<res>Update successful<res>
	<%
		} else {
	%>
	<res>Update failed<res>
	<%
		}
				break;
			}
		}
	%>
 --%>

 
 </div>
<%@ include file="footer.jsp" %>
</body>
</html>