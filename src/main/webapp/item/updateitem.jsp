<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
<title>Edit Item</title>
</head>
<body>
<%@ include file="header.jsp" %>



	<%
		ItemDTO i = (ItemDTO) request.getAttribute("dto");
		int id = i.getId();
	%>
	<div class="navbar">
  <a href="homeoperatore.jsp">Home</a>
  <a href="BuildingManagerServlet?mode=buildinglistOP">Buildings</a>
  <a href="AmbienteManagerServlet?mode=ambientelist">Rooms</a>
  <a class="active" href="ItemManagerServlet?mode=itemlist">Items</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<br>
	
<form action="ItemManagerServlet?mode=update&idToUpdate=<%=id%>" method="post">
		<div class="row">
			<div class="col-25">
				<label for="item">Itemtype:</label>
			</div>
			<div class="col-75">
		     <select id="type" name="itemType">
  				<option value="attuatore">actuator</option>
  				<option value="sensore">sensor</option>
			</select> 		
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="desc">Description:</label>
			</div>
			<div class="col-75">
				<input type="text" id="desc" name="description" placeholder="Insert description...">
			</div>
		</div>
		<input type="hidden" name="ambientId" value=<%=i.getAmbientId()%>> 
		<button type="submit" name="pulsante">Edit</button>
	</form>



<%@ include file="footer.jsp" %>
</body>
</html>