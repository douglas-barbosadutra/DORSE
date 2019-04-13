<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.*" import="java.util.List"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
<title>Operator main menu</title>
</head>
<body>
<%@include file="css/header.jsp"%>

<div class="navbar">
  <a class="active" href="homeoperatore.jsp">Home</a>
  <a href="BuildingManagerServlet?mode=buildinglistOP">Buildings</a>
  <a href="AmbienteManagerServlet?mode=ambientelist">Rooms</a>
  <a href="ItemManagerServlet?mode=itemlist">Items</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<%if (request.getAttribute("view")!="buildings") {
List<BuildingDTO> list = (List<BuildingDTO>) request.getAttribute("list");%>
<h1>Welcome ${user}</h1>
<%}%>

<%if (request.getAttribute("view")=="buildings") {
List<BuildingDTO> list = (List<BuildingDTO>) request.getAttribute("list");%>
<br>

	
<table>
<tr> 
	<th>Address</th>
	<th>User</th>
</tr>
<%for(BuildingDTO b: list) {%> 
<tr>
	<td> 
		<a href=AmbienteManagerServlet?mode=ambientelistby&buildingId=<%=b.getId()%>><%=b.getIndirizzo()%></a>
	</td>
	<td> 
		<%=b.getUserId()%>
	</td>
</tr>	
<%} %>
</table>
<%}%>



<br>

<%@ include file="css/footer.jsp" %>

</body>
</html>