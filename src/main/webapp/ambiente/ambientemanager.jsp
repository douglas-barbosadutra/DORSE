<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Room manager</title>
</head>
<body>

<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a href="homeoperatore.jsp">Home</a>
  <a href="BuildingManagerServlet?mode=buildinglistOP">Buildings</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<h1>Rooms of building ${buildingId} </h1>





<%List<AmbienteDTO> list = (List<AmbienteDTO>) request.getAttribute("list");%>



<table>
	<tr> 
		<th>Description</th>
		<th></th>
		<th></th>
	</tr>
	<%for(AmbienteDTO a: list) {%> 
	<tr>
		<td> 
			<a href=AmbienteManagerServlet?mode=read&id=<%=a.getId()%>><%=a.getDescrizione()%></a>
		</td>
		<td><a href=AmbienteManagerServlet?mode=preupdate&id=<%=a.getId()%>>Edit</a>
			</td>
		<td><a href=AmbienteManagerServlet?mode=delete&id=<%=a.getId()%>>Delete</a>
	</tr>	
	<%} %>
</table>




<form id="floatright" action="AmbienteManagerServlet" method="get">
  <div class="row">
    <div class="col-25">
      <label  for="desc">Description:</label> 
    </div>
    <div class="col-75">
      <input type="text" id="desc" name="descrizione" placeholder="Insert description..."> 
    </div>
  </div>
		<input type="hidden" name="mode" value="insert">
      <button type="submit" >Insert</button>
</form>




<%@ include file="../css/footer.jsp" %>

</body>
</html>