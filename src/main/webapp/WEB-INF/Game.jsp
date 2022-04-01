<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Style.css" type="text/css" />
<title>DigiYatzy</title>
</head>
<body>

 <h1>DigiYatzy</h1>
    <div id="score">
    <table>
	
	
	<tr id="playas">
		<c:forEach items="${game.players}" var="p">
       	 	<th></th>
        	<th><c:out value="${p.username}"></c:out></th>
	
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
  </div>

	<div id="dice">
		<div id="die_1">
			<c:out value="${game.die1Value}"></c:out> <!-- Må sette game som attributt, og bruke game.die1 osv -->
		</div>
		<div id="die_2">
			<c:out value="${die2}"></c:out>
		</div>
		<div id="die_3">
			<c:out value="${die3}"></c:out>
		</div>
		<div id="die_4">
			<c:out value="${die4}"></c:out>
		</div>
		<div id="die_5">
			<c:out value="${die5}"></c:out>
		</div>

	</div>

	<!-- Form for Roll knappen, hidden value representerer hvilke terninger som skal trilles. Skal bare bestå av 0 og 1, der de
	representerer true/false.
	-->
	<form id="takeRoll" action="YatzyGameServlet" method="post">
		<input id="diceToBeRolled" type=hidden name="diceToBeRolled" value="00000"></input>
		<button id="Roll" type="submit" value="Roll" name="Roll Dice">Roll Dice</button>
	</form>


	<script src="LogicYatzy.js"></script>
</body>
</html>