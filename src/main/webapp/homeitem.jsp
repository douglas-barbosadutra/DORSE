<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.*" import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Item</title>
</head>
<body>

<%List<ItemDTO> items = (List<ItemDTO>) session.getAttribute("itemlist"); %>

<table>
	<tr>
		<th>Description</th>
		<th>Type</th>
		<th> Edit</th>
		<th> Edit</th>
	</tr>
	<%for(ItemDTO i:items) {%>
	<tr>
		<td><%=i.getDescription()%></td>
		<td><%=i.getType()%></td>
		
		<td>Update</td>
		<td><a href="/item/delete?item_id=<%=i.getId()%>">Delete</a></td>
	</tr>
	<%} %>


</table>



</body>
</html>