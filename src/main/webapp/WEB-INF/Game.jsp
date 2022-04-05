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
		<c:forEach items="${players}" var="p">
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
			<c:out value="${game.die0Value}"></c:out> <!-- Må sette game som attributt, og bruke game.die1 osv -->
		</div>
		<div id="die_2">
			<c:out value="${game.die1Value}"></c:out>
		</div>
		<div id="die_3">
			<c:out value="${game.die2Value}"></c:out>
		</div>
		<div id="die_4">
			<c:out value="${game.die3Value}"></c:out>
		</div>
		<div id="die_5">
			<c:out value="${game.die4Value}"></c:out>
		</div>

	</div>

	<!-- Form for Roll knappen, hidden value representerer hvilke terninger som skal trilles. Skal bare bestå av 0 og 1, der de
	representerer true/false. 
	
	<form id="takeRoll" action="YatzyGameServlet" method="post">
		<input id="diceToBeRolled" type=hidden name="diceToBeRolled" value="00000"></input>
		<button id="Roll" type="submit" value="Roll" name="Roll Dice">Roll Dice</button>
	</form> -->
	
	
	<!-- Dette er Jørgen sitt forsøk på å sende riktige verdier for hvilke terninger som skal
	trilles, til POST i YatzyGameServlet (tror ihvertfall det blir post)
	<input type="button" class="button" value="roll selected dice" onclick=rollDice()> -->
	
	
	<button type="button" class="button" onclick=rollDice()>Roll non-green dice</button>









	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="LogicYatzy.js"></script>
</body>
</html>