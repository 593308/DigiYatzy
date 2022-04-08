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

	<button id="startGame" type="button" class="button"
		style="display: none;" onclick=startGameStatus()>Start game!</button>

	<div class="vis">

		<div id="score">
			<table>


				<tr id="playas">
						<th></th>
					<c:forEach items="${players}" var="p">
						<th><c:out value="${p.yatzyUser.username}"></c:out></th>
					</c:forEach>
				</tr>

				<tr id="ones">
					<td>Ones</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.onesScore}"></c:out></td>
					</c:forEach>
				</tr>
				
				<tr id="twos">
					<td>Twos</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.twosScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="threes">
					<td>Threes</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.threesScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="fours">
					<td>Fours</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.foursScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="fives">
					<td>Fives</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.fivesScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="sixes">
					<td>Sixes</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.sixesScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="sum">
					<th>Sum</th>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.bonusScore}">??</c:out></td>
					</c:forEach>
				</tr>
				<tr id="bonus">
					<th>Bonus</th>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.bonusScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="one pair">
					<td>One pair</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.onePairScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="two pairs">
					<td>Two pairs</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.twoPairsScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="three of a kind">
					<td>Three of a kind</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.threeOfAKindScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="four of a kind">
					<td>Four of a kind</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.fourOfAKindScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="small straight">
					<td>Small straight</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.smallStraightScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="large straigh">
					<td>Large straight</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.largeStraightScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="full house">
					<td>Full house</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.fullHouseScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="chance">
					<td>Chance</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.chanceScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="yatzy">
					<td>Yatzy</td>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.yatzyScore}"></c:out></td>
					</c:forEach>
				</tr>
				<tr id="total score">
					<th>Total score</th>
					<c:forEach items="${players}" var="p">
						<td><c:out value="${p.totalScore}"></c:out></td>
					</c:forEach>
				</tr>
			</table>
		</div>

		<div id="gameInfo">

			<div id="gameId">
				<c:out value="${gameId}"></c:out>
			</div>
			<div id="username">
				<c:out value="${username}"></c:out>
			</div>
			<div id="hostPlayer">
				<c:out value="${game.hostPlayer}"></c:out>
			</div>
			<div id="gameState">
				<c:out value="${game.gameState}"></c:out>
			</div>
			<div id="roundCount">
				<c:out value="${game.roundCount}"></c:out>
			</div>
			<div id="currentPlayer">
				<c:out value="${game.currentPlayer}"></c:out>
			</div>
			<div id="diceRollCount">
				<c:out value="${game.diceRollCount}"></c:out>
			</div>

		</div>
	</div>

	<div id="dice">
		<div id="die_1">
			<c:out value="${game.die0Value}"></c:out>
			<!-- Må sette game som attributt, og bruke game.die1 osv -->
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


	<button id="rollButton" type="button" class="button" onclick=rollDice()>Roll
		non-green dice</button>









	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="LogicYatzy.js"></script>
</body>
</html>