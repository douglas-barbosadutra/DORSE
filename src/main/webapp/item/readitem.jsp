<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.*" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Lettura Item</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

	<%
	ItemDTO i = (ItemDTO) request.getAttribute("dto");
	%>
<div class="navbar">
  <a href="homeoperatore.jsp">Home</a>
  <a href="BuildingManagerServlet?mode=buildinglistOP">Buildings</a>
    <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

	<table>

		<tr>
			<th>Itemtype</th>
			<th>Description</th>
			<th>Room</th>

		</tr>

		<tr>
			<td><%=i.getItemType()%></td>
			<td><%=i.getDescription()%></td>
			<td><%=i.getAmbientId()%></td>

		</tr>
	</table>
	
<br>
<br>	
<br>
<br>	
<br>
<br>	
<br>
<br>
<br>
<br>	
<br>
<br>	
	
	<%@ include file="../css/footer.jsp" %>
</body>
</html>