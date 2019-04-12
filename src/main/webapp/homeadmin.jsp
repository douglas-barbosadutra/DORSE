<html>
<head>
<title>Menu Principale Admin</title>
</head>
<body>
	<h1>Benvenuto ${utente}</h1>
	<h2>MENU PRINCIPALE ADMIN</h2>

<a href="UserManagerServlet?mode=userlist"> Gestione Utenti </a>
<br> </br>
<a href="BuildingManagerServlet?mode=buildinglist"> Gestione Building </a>
<br> </br>

<form action="LogoutServlet" method="post">
<button type="submit" value="Logout" name="pulsante">Logout</button>
</form>
</body>
</html>