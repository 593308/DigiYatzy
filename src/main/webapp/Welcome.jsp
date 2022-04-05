<!DOCTYPE html>
<html>
<head>

<title>DigiYatzy</title>
<meta charset="ISO-8859-1">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap"
	rel="stylesheet">
<!--Stylesheet-->
<style media="screen">
*, *:before, *:after {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

body {
	background-color: #2d55a0;
}

.background {
	width: 430px;
	height: 520px;
	position: absolute;
	transform: translate(-50%, -50%);
	left: 50%;
	top: 50%;
}

.background .shape {
	height: 200px;
	width: 200px;
	position: absolute;
	border-radius: 50%;
}

form * {
	font-family: 'Poppins', sans-serif;
	color: #ffffff;
	letter-spacing: 0.5px;
	outline: none;
	border: none;
}

form h3 {
	font-size: 32px;
	font-weight: 500;
	line-height: 42px;
	text-align: center;
}

button {
	margin-top: 50px;
	width: 100%;
	background-color: #ffffff;
	color: #080710;
	padding: 15px 0;
	font-size: 18px;
	font-weight: 600;
	border-radius: 5px;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="background">
		<div class="shape"></div>
		<div class="shape"></div>
	</div>
</head>
<body>


	<form action="LoginServlet" method="get">

		<button type="submit">Log In</button>
	</form>

	<form action="RegisterServlet" method="get">

		<button type="submit">Register</button>
	</form>


</body>
</html>