<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.BuildingDTO" import="java.util.*" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Building</title>
</head>
<body>
<h1>Pagina di modifica Building</h1>



	<%
		BuildingDTO b = (BuildingDTO) request.getAttribute("dto");
		int id = b.getId();
		List<UserDTO> operatorList = (List)request.getAttribute("operatorList");
	%>
	
	
<form action="BuildingManagerServlet" method="get">

		<input type="hidden" name="mode" value="update">
		<input type="hidden" name="id" value="<%=id%>">
		indirizzo: <input type="text" id="user" name="indirizzo"
			value="<%=b.getIndirizzo()%>">
		Id Utente: <input
			type="text" id="pass" name="userId"
			value=<%=b.getUserId()%>> 
		Operatore: <select name="operatorId">
		<% for (UserDTO op : operatorList) { %>
  			<option <%if (b.getOperatorId() == op.getId()) {%> selected <%} %> value="<%=op.getId()%>"><%=op.getUsername()%></option>
  <% } %>
</select>
			
		<button type="submit">Modifica</button>

</form>

</body>
</html>