<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>


<form action="/user/register" method="post">

	<label for="Username">Username</label> 
	<input type="text" name="username" id="Username"  placeholder="Insert Username" >
	
	<label for="Password">Password</label> 
	<input type="text" name="password" id="Password"  placeholder="Insert Pasword" >
	
	<label for="Email">E-mail</label> 
	<input type="text" name="email" id="Email" placeholder="Insert E-mail">
	
	<label for="Name">Name</label> 
	<input type="text" name="name" id="Name"  placeholder="Insert Name " >
	
	<label for="Surname">Surname</label> 
	<input type="text" name="surname" id="Surname"  placeholder="Insert Surname " >
	
	<label for="Birthdate">Birthdate</label> 
	<input type="date" name="birthdate" id="Birthdate">
	
	<label for="Address">Address</label> 
	<input type="text" name="address" id="Address"  placeholder="Insert Address " >
	
	<label for="Telnumber">Telephone Number</label> 
	<input type="text" name="telnumber" id="Telnumber"  placeholder="Insert Telephone number " >
	
	<label for="ccc">Credit Card, bitch</label> 
	<input type="text" name="ccc" id="ccc"  placeholder="Insert CCC " >

	<label for="UserType">UserType</label> 
	<select id= "UserType">
	<option value="OPERATOR">Operator<option>
	<option value="TUTOR">Tutor<option>
	</select>
	
</form>




</body>
</html>