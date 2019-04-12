<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
<title>Item manager ${ambientId}</title>
</head>
<body>
<h1>Item manager ${ambientId} </h1>


<table>
	<tr> 
		<th>ItemType</th>
		<th>Description</th>
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
		<td><a href=ItemManagerServlet?mode=preupdate&id=<%=i.getId()%>>Modifica</a>
			</td>
		<td><a href=ItemManagerServlet?mode=delete&id=<%=i.getId()%>>Cancella</a>
	</tr>	
	<%} %>
</table>



	<h2>Inserisci un nuovo item in questo ambiente</h2>

	<form
		action="ItemManagerServlet" method="get">

		ItemType: <input type="text" id="tipo" name="itemType"
			placeholder="inserisci l'itemtype">
		Descrizione: <input type="text" id="tipo" name="description"
			placeholder="inserisci la descrizione"> <input type="hidden"
			name="mode" value="insert">
		<input type="hidden" name="ambientId"
			value="<%=session.getAttribute("ambientId")%>">
		<button type="submit">Inserisci</button>
	</form>




	<%
		if (request.getAttribute("ans") != null) {
			String mode = request.getParameter("mode");
			boolean ans = (boolean) request.getAttribute("ans");
			switch (mode) {
			case "insert":
				if (ans) {
	%>
	<h3>L'inserimento è andato alla grande!</h3>
	<%
		} else {
	%>
	<h3>Ritenta, sarai più fortunato...</h3>
	<%
		}
				break;
			case "delete":
				if (ans) {
	%>
	<h3>La cancellazione è andata alla grande!</h3>
	<%
		} else {
	%>
	<h3>Ritenta, sarai più fortunato...</h3>
	<%
		}
				break;
			case "update":
				if (ans) {
	%>
	<h3>La modifica è andata alla grande!</h3>
	<%
		} else {
	%>
	<h3>Ritenta, sarai più fortunato...</h3>
	<%
		}
				break;
			}
		}
	%>

</body>
</html>