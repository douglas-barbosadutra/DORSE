<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Ambiente</title>
</head>
<body>
<h1>Pagina di modifica Ambiente</h1>



	<%
		AmbienteDTO a = (AmbienteDTO) request.getAttribute("ambiente");
		int id = a.getId();
	%>
	
	
<form action="AmbienteManagerServlet?mode=update&id=<%=id%>" method="post">


		Descrizione: <input type="text" id="desc" name="descrizione"
			value="<%=a.getDescrizione()%>">
		Id Building: <input
			type="text" id="buil" name="building"
			value=<%=a.getBuildingid()%>> 
			
		<button type="submit" name="pulsante">Modifica</button>

</form>
</body>
</html>