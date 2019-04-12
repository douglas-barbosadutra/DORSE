<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
<title>Building's ambients manager ?</title>
</head>
<body>
<h1>Ambients of building ${buildingId} </h1>





<%List<AmbienteDTO> list = (List<AmbienteDTO>) request.getAttribute("list");%>



<table>
	<tr> 
		<th>Description</th>
		<th>Building</th>
	</tr>
	<%for(AmbienteDTO a: list) {%> 
	<tr>
		<td> 
			<a href=AmbienteManagerServlet?mode=read&id=<%=a.getId()%>><%=a.getDescrizione()%></a>
		</td>
		<td><a href=AmbienteManagerServlet?mode=preupdate&id=<%=a.getId()%>>Edit</a>
			</td>
		<td><a href=AmbienteManagerServlet?mode=delete&id=<%=a.getId()%>>Delete</a>
	</tr>	
	<%} %>
</table>



	<h2>Insert new ambient</h2>

	<form
		action="AmbienteManagerServlet" method="get">

		Description: <input type="text" id="tipo" name="descrizione"
			placeholder="inserisci la descrizione"> <input type="hidden"
			name="mode" value="insert">
		<input type="hidden" name="buildingId"
			value="<%=session.getAttribute("buildingId")%>">
		<button type="submit">Insert</button>
	</form>




	<%
		if (request.getAttribute("ans") != null) {
			String mode = request.getParameter("mode");
			boolean ans = (boolean) request.getAttribute("ans");
			switch (mode) {
			case "insert":
				if (ans) {
	%>
	<h3>Insert successful</h3>
	<%
		} else {
	%>
	<h3>Insert failed</h3>
	<%
		}
				break;
			case "delete":
				if (ans) {
	%>
	<h3>Delete successful</h3>
	<%
		} else {
	%>
	<h3>Delete failed</h3>
	<%
		}
				break;
			case "update":
				if (ans) {
	%>
	<h3>Edit successful</h3>
	<%
		} else {
	%>
	<h3>Edit failed</h3>
	<%
		}
				break;
			}
		}
	%>

</body>
</html>