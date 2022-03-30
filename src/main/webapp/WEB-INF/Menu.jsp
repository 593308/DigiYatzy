<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Games</title>
</head>
<body>


	 <form action="CreateGameServlet" method="post">
	 	<input type="submit" class="pure-button pure-button-primary" value="Create Game "/>
	 </form>
	 <br>
	 <form action="JoinGameServlet" method="post">
	 	<input type ="number" name="gameId" value="GameId">
	 	<br> 
	 	<input type="submit" class="pure-button pure-button-primary" value="Join Game">
	 	
	 	
	 </form>

	
	 

</body>
</html>