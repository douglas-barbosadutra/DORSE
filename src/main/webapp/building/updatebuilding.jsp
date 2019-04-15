<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.BuildingDTO" import="java.util.*" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Building</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a href="UserManagerServlet?mode=userlist">Users</a>
  <a class="active" href="BuildingManagerServlet?mode=buildinglist">Buildings</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div clas="main">



	<%
		BuildingDTO b = (BuildingDTO) request.getAttribute("dto");
		List<UserDTO> operatorList = (List)request.getAttribute("operatorList");
		List<UserDTO> clientList = (List<UserDTO>)request.getAttribute("clientList");
	%>
	
	
	
	
	 <form id="floatleft" action="BuildingManagerServlet" method="get" >
	 		<input type="hidden" name="mode" value="update">
			<input type="hidden" name="id" value="<%=b.getId()%>">
			
  <div class="row">
    <div class="col-25">
      <label  for="address">Address</label> 
    </div>
    <div class="col-75">
      <input type="text" id="user" name="indirizzo" value="<%=b.getIndirizzo()%>">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="client">Client</label>
    </div>
    <div class="col-75">
      <select id="client" name="clientId" >
		<% for (UserDTO c : clientList) { %>
  			<option <%if (b.getUserId() == c.getId()) {%> selected <%} %> value="<%=c.getId()%>"><%=c.getUsername()%></option>
  			<% } %>
		</select>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label id="floatleft" for="operator">Operator</label>
    </div>
   		 <div class="col-75">
      		<select id="operator" name="operatorId">
      			
		<% for (UserDTO op : operatorList) { %>
  			<option <%if (b.getOperatorId() == op.getId()) {%> selected <%} %> value="<%=op.getId()%>"><%=op.getUsername()%></option>
  <% } %>
</select>
    	</div>
  </div>
   
      <button type="submit" >Edit</button>
</form>
   
	
	
</div>
<%@ include file="../css/footer.jsp" %>
</body>
</html>