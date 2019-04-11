<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.*" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lettura Item</title>
</head>
<body>
	<h1>Pagina di lettura Item</h1>

	<%
	ItemDTO i = (ItemDTO) request.getAttribute("dto");
	%>


	<table>

		<tr>
			<th>ItemType</th>
			<th>Descrizione</th>
			<th>Ambiente</th>

		</tr>

		<tr>
			<td><%=i.getItemType()%></td>
			<td><%=i.getDescription()%></td>
			<td><%=i.getAmbientId()%></td>

		</tr>
	</table>