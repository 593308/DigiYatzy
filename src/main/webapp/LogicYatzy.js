"use strict";

/*let finished = false;
let playerInTurn;
let currentPlayer;
*/

/**
PROBLEM: måten terningene refreshes på, med .load lager nye divs
inne i eksisterende divs. Det er derfor det blir kukk med grafikken,
og at eventlisteners ikke blir lagt til ordentlig
*/

//Setter opp dice første gangen siden lastes
//window.onload = initYatzy();

//setupDice();

//Tilhørende element er på linje 105 i game.jsp
//let diceToBeRolled = document.getElementById("diceToBeRolled");
let diceToBeRolled = "11111";

let username = document.getElementById("username").innerText;
let hostPlayer = document.getElementById("hostPlayer").innerText;
let gameState = document.getElementById("gameState").innerText;
let roundCount = document.getElementById("roundCount").innerText;
let currentPlayer = document.getElementById("currentPlayer").innerText;
let diceRollCount = document.getElementById("diceRollCount").innerText;

initYatzy();

console.log("Test av session attributes: " 
			+ "username: " + username
			+ " hostPlayer: " + hostPlayer
			+ " gameState: " + gameState
			+ " roundCount: " + roundCount
			+ " currentPlayer: " + currentPlayer
			+ " diceRollCount: " + diceRollCount);

function initYatzy() {
	
	if (username == hostPlayer && gameState == "PLAYER_JOIN") {
		console.log("du er host og kan starte spillet");
		document.getElementById("startGame").style.display = "block";
		continousUpdate();
	}
	
	else if (username == currentPlayer) {
		setupDice();
	}
	else {
		continousUpdate();
		document.getElementById("rollButton").style.display = "none";
	}
	
}

function startGameStatus() {
	
	makePostRequestVoid("/DigiYatzy/YatzyGameServlet" +
						"?updateGameStatus=startGame");
						
	setTimeout(location.reload(), 200);
}

//let takeRoll = document.getElementById("takeRoll");

function setupDice() {

//Måtte prøve å flytte denne til setup, for å plukke opp riktig element

let die_1 = document.getElementById("die_1");
let die_2 = document.getElementById("die_2");
let die_3 = document.getElementById("die_3");
let die_4 = document.getElementById("die_4");
let die_5 = document.getElementById("die_5");

//Hver die får sin egen element id som paramater.
die_1.myParam = "die_1";
die_2.myParam = "die_2";
die_3.myParam = "die_3";
die_4.myParam = "die_4";
die_5.myParam = "die_5";


//Sjekk kommentar linje 87 for hva funksjon gjør
die_1.addEventListener("click", changeStatus);
die_2.addEventListener("click", changeStatus);
die_3.addEventListener("click", changeStatus);
die_4.addEventListener("click", changeStatus);
die_5.addEventListener("click", changeStatus);

//Alle terninger starter som unlocked. Mellom kast må bruker locke terninger på nytt.
die_1.classList.add("unlocked");
die_2.classList.add("unlocked");
die_3.classList.add("unlocked");
die_4.classList.add("unlocked");
die_5.classList.add("unlocked");

}

//Har som mål å oppdatere hidden value for diceToBeRolled, sjekk linje 105 i Game.jsp
let updateDice = function () {
    diceToBeRolled = "";

    if (document.getElementById("die_1").classList.contains("locked")) {
        diceToBeRolled += 0;
    }
    else {
        diceToBeRolled += 1;
    }

    if (document.getElementById("die_2").classList.contains("locked")) {
        diceToBeRolled += 0;
    }
    else {
        diceToBeRolled += 1;
    }
    if (document.getElementById("die_3").classList.contains("locked")) {
        diceToBeRolled += 0;
    }
    else {
        diceToBeRolled += 1;
    }
    if (document.getElementById("die_4").classList.contains("locked")) {
        diceToBeRolled += 0;
    }
    else {
        diceToBeRolled += 1;
    }
    if (document.getElementById("die_5").classList.contains("locked")) {
        diceToBeRolled += 0;
    }
    else {
        diceToBeRolled += 1;
    }

	//Linjen trengs ikke, men viser hva som skjer underveis på klientsiden
    console.log(diceToBeRolled);


}

//Denne linjen trengs antageligvis ikke. Kan oppdatere locked/unlocked hver gang bruker trykker på en terning
//takeRoll.addEventListener("submit", updateDice(), false);



//Hvis en terning har locked i classList, fjernes den og unlocked legges til. Ellers skjer det motsatte.
function changeStatus(evt) {


    if (document.getElementById(evt.currentTarget.myParam).classList.contains("locked")) {
        document.getElementById(evt.currentTarget.myParam).classList.remove("locked");
        document.getElementById(evt.currentTarget.myParam).classList.add("unlocked");
    } else {
        document.getElementById(evt.currentTarget.myParam).classList.remove("unlocked");
        document.getElementById(evt.currentTarget.myParam).classList.add("locked");
    }
	
	updateDice();

}

//Her begynner Jørgen sin kuking i javascript

//funskjonen funker, sender til post i gameServlet hvilke terninger som trilles
function rollDice() {
	
	//OBS! Må sjekke om det er din tur (playerinturn == currentplayer)
	
		console.log("disse dice sendes til servlet: " + diceToBeRolled);
		
		makePostRequestVoid("/DigiYatzy/YatzyGameServlet" +
						"?diceSelection=" + diceToBeRolled);
						
		updatePage();
	
}

//DISSE ER AJAX KALL TIL SERVLETENE
function makePostRequestVoid(url) {

	var request = new XMLHttpRequest();
	request.open("POST", url, false);
	request.send();
}

function makePostRequest(url) {
		var request = new XMLHttpRequest();
		request.open("POST", url, false);
		request.send();
	
		if (request.responseText) {
	
		var parser = new DOMParser();
		var xmlDoc = parser.parseFromString(request.responseText,
					"text/xml");
	
		return xmlDoc;
		} else {
			return null;
			}
}

function makeGetRequestVoid(url) {

	var request = new XMLHttpRequest();
	request.open("GET", url, false);
	request.send();
}

function makeGetRequest(url) {
		var request = new XMLHttpRequest();
		request.open("GET", url, false);
		request.send();
	
		if (request.responseText) {
	
		var parser = new DOMParser();
		var xmlDoc = parser.parseFromString(request.responseText,
					"text/xml");
	
		return xmlDoc;
		} else {
			return null;
			}
}

//Oppdaterer terningverdier når/hvis de har blitt trillet
function updatePage()
{
	//Denne funker som en vanlig refresh av page
	//setTimeout(location.reload(), 100);
	location.reload();
	
	//CURRENT PROBLEM: THIS CREATES DIVS INSIDE OF EXISTING DIVS
	//$( "#die_1" ).load(window.location.href + " #die_1" );
	//$( "#die_2" ).load(window.location.href + " #die_2" );
	//$( "#die_3" ).load(window.location.href + " #die_3" );
	//$( "#die_4" ).load(window.location.href + " #die_4" );
	//$( "#die_5" ).load(window.location.href + " #die_5" );
	
	//$("#dice").load(" #dice > *");
	
	//$("#die_1").load(" #die_1 > *");
	//$("#die_2").load(" #die_2 > *");
	//$("#die_3").load(" #die_3 > *");
	//$("#die_3").load(" #die_4 > *");
	//$("#die_4").load(" #die_5 > *");
	
	//Eventlisteners må settes opp på nytt osv.
	//setupDice();

}
/**
Trenger å oppdatere siden hvert sekund, men bare hvis det ikke er din tur.
Kan by på problemer: Når siden oppdateres vil også scriptet kjøres på nytt.
Og hva skjer hvis man trykker på en knapp akkurat når siden skal refreshes? HÆLVETEEEE */


//Funksjonen kalles når spillet settes i gang (vet ikke helt hvordan enda)
/**function startGame() {
	
	continousUpdate(finished);
	
	
}
*/

//Etter spillet er started oppdateres spillet helt til finished, hvis det ikke er din tur

function continousUpdate() {
	setInterval(function() {
		if ((gameState != "FINISHED") && (username != currentPlayer)) {
			
			updatePage();
			
		}
	}, 1000);
}















