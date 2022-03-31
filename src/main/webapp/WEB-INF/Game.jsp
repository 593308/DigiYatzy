<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" 
	href="Style.css" type="text/css" />
<title>DigiYatzy</title>
</head>
<body>

	<h1>DigiYatzy</h1>
	<table>

		<tr id="playas">
			<td>Players -></td>
			<c:forEach items="${player}" var="p">
			
			<c:out value=""></c:out><tr>${p.username}</tr>
			
			
			
			
			</c:forEach>
	
		</tr>
		<tr id="ones">
			<td>Ones</td>
		</tr>
		<tr id="twos">
			<td>Twos</td>
		</tr>
		<tr id="threes">
			<td>Threes</td>
		</tr>
		<tr id="fours">
			<td>Fours</td>
		</tr>
		<tr id="fives">
			<td>Fives</td>
		</tr>
		<tr id="sixes">
			<td>Sixes</td>
		</tr>
		<tr id="sum">
			<th>Sum</th>
		</tr>
		<tr id="bonus">
			<th>Bonus</th>
		</tr>
		<tr id="one pair">
			<td>One pair</td>
		</tr>
		<tr id="two pairs">
			<td>Two pairs</td>
		</tr>
		<tr id="three of a kind">
			<td>Three of a kind</td>
		</tr>
		<tr id="four of a kind">
			<td>Four of a kind</td>
		</tr>
		<tr id="small straight">
			<td>Small straight</td>
		</tr>
		<tr id="large straigh">
			<td>Large straight</td>
		</tr>
		<tr id="full house">
			<td>Full house</td>
		</tr>
		<tr id="chance">
			<td>Chance</td>
		</tr>
		<tr id="yatzy">
			<td>Yatzy</td>
		</tr>
		<tr id="total score">
			<th>Total score</th>
		</tr>






	</table>
	
	<div id="dice">
		<div id="die_1" onclick="changeBackground()">1</div>
		<div id="die_2">2</div>
		<div id="die_3">3</div>
		<div id="die_4">4</div>
		<div id="die_5">5</div>
		
	</div>
	
	<button type="button">Roll Dice</button>



	<script src="LogicYatzy.js"></script>
</body>
</html>