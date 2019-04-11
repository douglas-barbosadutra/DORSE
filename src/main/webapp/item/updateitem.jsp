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
	
	
<form action="ItemManagerServlet?mode=update&id=<%=id%>" method="post">


		Descrizione: <input type="text" id="desc" name="description"
			value="<%=i.getDescription()%>">
		Id Item: <input
			type="text" id="amb" name="ambientId"
			value=<%=i.getAmbientId()%>> 
			
		<button type="submit" >Modifica</button>

</form>
</body>
</html>