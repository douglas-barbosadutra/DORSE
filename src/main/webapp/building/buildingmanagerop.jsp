<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.*" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Buildings</title>
</head>
<body>
<%@include file="../css/header.jsp"%>



<div class="navbar">
  <a href="homeoperatore.jsp">Home</a>
  <a  class="active" href="BuildingManagerServlet?mode=buildinglistOP">Buildings</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>


<%List<BuildingDTO> list = (List<BuildingDTO>) request.getAttribute("list");%>

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


<%@include file="../css/footer.jsp"%>
</body>
</html>