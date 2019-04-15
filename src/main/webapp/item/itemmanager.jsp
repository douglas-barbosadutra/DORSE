<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Item manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a href="homeoperatore.jsp">Home</a>
  <a href="BuildingManagerServlet?mode=buildinglistOP">Buildings</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<h1>Item in ambient ${ambientId} </h1>


<table>
	<tr> 
		<th>ItemType</th>
		<th>Description</th>
		<th></th>
		<th></th>
	</tr>
	<%List<ItemDTO> list = (List<ItemDTO>) request.getAttribute("list");
	for(ItemDTO i: list) {%> 
	<tr>
		<td> 
			<a href=ItemManagerServlet?mode=read&id=<%=i.getId()%>><%=i.getItemType()%></a>
		</td>
			<td> 
			<%=i.getDescription()%></a>
		</td>
		<td><a href=ItemManagerServlet?mode=preupdate&id=<%=i.getId()%>>Edit</a>
			</td>
		<td><a href=ItemManagerServlet?mode=delete&id=<%=i.getId()%>>Delete</a>
	</tr>	
	<%} %>
</table>

	<form id="floatright" action="ItemManagerServlet" method="get">

  <div class="row">
    <div class="col-25">
      <label  for="desc">Itemtype:</label> 
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
      <label  for="desc">Description:</label> 
    </div>
    <div class="col-75">
      <input type="text" id="desc" name="description" placeholder="Insert description..."> 
    </div>
  </div>
		<input type="hidden" name="mode" value="insert">
		<input type="hidden" name="ambientId" value="<%=session.getAttribute("ambientId")%>">
		<button type="submit">Insert</button>
	</form>

<%@ include file="../css/footer.jsp" %>
</body>
</html>