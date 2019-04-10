
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.BuildingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Building</title>
</head>
<body>
<h1>Pagina di modifica Building</h1>



	<%
		BuildingDTO b = (BuildingDTO) request.getAttribute("building");
		int id = b.getId();
	%>
	
	
<form action="BuildingManagerServlet?mode=update&id=<%=id%>" method="post">


		<input type="text" id="user" name="indirizzo"
			value="<%=b.getIndirizzo()%>">
		<input
			type="text" id="pass" name="user"
			value=<%=b.getUserId()%>> 
			
		<button type="submit" value="Insert" name="pulsante">Modifica</button>

</form>

</body>
</html>