<html>
<head>
<title>Admin main menu</title>
</head>
<body>
	<h1>Welcome ${utente}</h1>
	<h2>Admin main menu</h2>

<a href="UserManagerServlet?mode=userlist"> Manage users</a>
<br> </br>
<a href="BuildingManagerServlet?mode=buildinglist"> Manage buildings </a>
<br> </br>

<form action="LogoutServlet" method="post">
<button type="submit" value="Logout" name="pulsante">Logout</button>
</form>
</body>
</html>