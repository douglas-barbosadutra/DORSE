<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.*" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Ambient</title>
</head>
<body>
<%@include file="../css/header.jsp"%>
	<%AmbienteDTO a = (AmbienteDTO) request.getAttribute("dto");
	%>


<div class="navbar">
  <a  href="homeoperatore.jsp">Home</a>
  <a href="BuildingManagerServlet?mode=buildinglistOP">Buildings</a>
    <a href="LogoutServlet" id="logout">Logout</a>
</div>

<br>


	<table>
		<tr>
			<th>Description</th>
			<th>Building</th>

		</tr>
		<tr>
			<td><a href="ItemManagerServlet?mode=itemlistby&ambientId=<%=a.getId()%>" ><%=a.getDescrizione()%></a></td>
			<td><%=a.getBuildingid()%></td>

		</tr>
	</table>


<div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>