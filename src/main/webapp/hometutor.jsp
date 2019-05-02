<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="it.contrader.dto.*" import="java.util.List" %>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Hometutor</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/vittoriostyle.css" rel="stylesheet">
</head>

<body>
<h1>PROGETTO DOSER</h1>
<% UserDTO user = (UserDTO) session.getAttribute("user");
   List<ApartmentDTO> apartments = (List<ApartmentDTO>) session.getAttribute("apartmentlist");
%>
<h2>Benvenuto <%=user.getName()%> <%=user.getSurname()%></h2>

<form class="register" action="/apartment/register" method="post">

	<label for="Address">Address</label> 
	<input type="text" name="address" id="Address"  placeholder="Insert Address">
	<input type="hidden" name="tutor_id" value="<%=user.getId()%>">
	
	<button type="submit">Register Apartment</button>
</form>

<form class="register" action="/client/register" method="post">

	<label for="Name">Name</label> 
	<input type="text" name="name" id="Name"  placeholder="Insert Name">
	
	<label for="Surname">Surname</label>
	<input type="text" name="surname" id="Surname"  placeholder="Insert Surname">
	
	<label for="Date">Birthdate</label>
	<input type="date" name="birthdate" id="Date" >
	
	<label for="Telnumber">Telephone Number</label>
	<input type="text" name="telnumber" id="Telnumber" >
	
	<label for="Apartment">Apartment</label>
	<select name="apartment_id" id="Apartment">
	<%for (ApartmentDTO a : apartments){%>
		<option value="<%=a.getId()%>"><%=a.getAddress()%></option>
	<%}%>
	</select>
	
	<input type="hidden" name="tutor_id" value="<%=user.getId()%>">
	
	<button type="submit">Register Client</button>
</form>





<form class="register" action="/apartment/register" method="post">

	<label for="Address">Address</label> 
	<input type="text" name="address" id="Address"  placeholder="Insert Address">
	<input type="hidden" name="tutor_id" value="<%=user.getId()%>">
	
	<button type="submit">Register Apartment</button>
</form>



<form class="register" action="/thing/create" method="post">

	<label for="Description">Description</label> 
	<input type="text" name="description" id="Description"  placeholder="Insert Description">
	
	<button type="submit">Insert Thing</button>


	<form class="register" action="/client/register" method="post">

	<label for="Name">Name</label> 
	<input type="text" name="name" id="Name"  placeholder="Insert Name">
	
	<label for="Surname">Surname</label>
	<input type="text" name="surname" id="Surname"  placeholder="Insert Surname">
	
	<label for="Date">Birthdate</label>
	<input type="date" name="birthdate" id="Date" >
	
	<label for="Telnumber">Telephone Number</label>
	<input type="text" name="telnumber" id="Telnumber" >
	
	<label for="Apartment">Apartment</label>
	<select name="apartment_id" id="Apartment">
	<%for (ApartmentDTO a : apartments){%>
		<option value="<%=a.getId()%>"><%=a.getAddress()%></option>
	<%}%>
	</select>
	
	<input type="hidden" name="tutor_id" value="<%=user.getId()%>">
	
	<button type="submit">Register Client</button>
</form>






</body>
</html>