<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
<title>Edit ambient</title>
</head>
<body>
<h1>Edit ambient</h1>



	<%
		AmbienteDTO a = (AmbienteDTO) request.getAttribute("dto");
		int id = a.getId();
	%>
	
	
<form action="AmbienteManagerServlet?mode=update&id=<%=id%>" method="post">


		Description: <input type="text" id="desc" name="descrizione"
			value="<%=a.getDescrizione()%>">
<!-- 		Building ID: <input -->
<!-- 			type="text" id="buil" name="buildingId" -->
<%-- 			value=<%=a.getBuildingid()%>>  --%>
			
		<button type="submit" name="pulsante">Edit</button>

</form>
</body>
</html>