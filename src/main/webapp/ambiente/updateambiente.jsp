<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit ambient</title>
</head>
<body>
<%@include file="../css/header.jsp"%>

<div class="navbar">
  <a href="homeoperatore.jsp">Home</a>
  <a href="BuildingManagerServlet?mode=buildinglistOP">Buildings</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

	<%
		AmbienteDTO a = (AmbienteDTO) request.getAttribute("dto");
		int id = a.getId();
	%>
<br>

	<form action="AmbienteManagerServlet?mode=update&id=<%=id%>" method="post">
		<div class="row">
			<div class="col-25">
				<label for="desc">Description:</label>
			</div>
			<div class="col-75">
				<input type="text" id="desc" name="descrizione" placeholder="Insert description...">
			</div>
		</div>
		<button type="submit" name="pulsante">Edit</button>
	</form>

	<%@ include file="../css/footer.jsp" %>
</body>
</html>