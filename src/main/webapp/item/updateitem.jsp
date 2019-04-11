<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Item</title>
</head>
<body>
<h1>Pagina di modifica Item</h1>



	<%
		ItemDTO i = (ItemDTO) request.getAttribute("dto");
		int id = i.getId();
	%>
	
	
<form action="ItemManagerServlet?mode=update&idToUpdate=<%=id%>" method="post">


		ItemType: <input type="text"  name="itemtype"
			value="<%=i.getItemType()%>">
		Descrizione: <input
			type="text"name="description"
			value=<%=i.getDescription()%>> 
			<input
			type="hidden" name="ambientId"
			value=<%=i.getAmbientId()%>> 
			
		<button type="submit" >Modifica</button>

</form>
</body>
</html>