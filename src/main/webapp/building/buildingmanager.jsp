<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.BuildingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Building</title>
</head>
<body>


<% List<BuildingDTO> buildinglist = (List<BuildingDTO>)request.getAttribute("buildinglist");%>

<table>
	<tr> 
		<th>Indirizzo</th>
		<th>User</th>
	</tr>
	<% for(BuildingDTO b: buildinglist) {%> 
	<tr>
		<td> 
			<%=b.getIndirizzo()%>
		</td>
		<td> 
			<%=b.getUserId()%>
		</td>
	</tr>	
	<%} %>
</table>

</body>
</html>