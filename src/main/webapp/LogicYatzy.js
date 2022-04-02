"use strict";

let diceLocked = "11111";

//Her er variabler jeg tror må hentes ut fra Game, og skrives i HTML
//enten skjult eller som info (som kan være nyttig)
let finished = false;
let playerInTurn;
let currentPlayer;


let die_1 = document.getElementById("die_1");
let die_2 = document.getElementById("die_2");
let die_3 = document.getElementById("die_3");
let die_4 = document.getElementById("die_4");
let die_5 = document.getElementById("die_5");

//Tilhørende element er på linje 105 i game.jsp
//let diceToBeRolled = document.getElementById("diceToBeRolled");
let diceToBeRolled = "11111";

let takeRoll = document.getElementById("takeRoll");


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


//Har som mål å oppdatere hidden value for diceToBeRolled, sjekk linje 105 i Game.jsp
let updateDice = function () {
    diceToBeRolled = "";

    if (die_1.classList.contains("locked")) {
        diceToBeRolled += 0;

    }
    else {
        diceToBeRolled += 1;


    }

    if (die_2.classList.contains("locked")) {
        diceToBeRolled += 0;
    }
    else {
        diceToBeRolled += 1;
    }
    if (die_3.classList.contains("locked")) {
        diceToBeRolled += 0;
    }
    else {
        diceToBeRolled += 1;
    }
    if (die_4.classList.contains("locked")) {
        diceToBeRolled += 0;
    }
    else {
        diceToBeRolled += 1;
    }
    if (die_5.classList.contains("locked")) {
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
						
		console.log("kaller på update game")
		updateGameStatus(); //Kommer ikke hit av en eller annen grunn
	
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

//Oppdaterer gamet
function updateGameStatus() {
	
	//updateGameStatus må reloade scoreboards og terningene
	
	//Dette funker ikke, blir ikke kalt på i rollDice
	console.log("Venter 2 sekunder, oppdaterer dice");
	setTimeout(updateDice(), 2000);
	
}

function updateDice() {
	
	console.log("Dice blir oppdatert");
	$("#dice").load(" #dice > *");
	
}

//Funksjonen kalles når spillet settes i gang (vet ikke helt hvordan enda)
function startGame() {
	
	continousUpdate(finished);
	
	
}

//Etter spillet er started oppdateres spillet helt til finished
function continousUpdate(finished) {
	setInterval(function() {
		if (!finished) {
			
			updateGameStatus(gameId);
			
		}
	}, 1000);
}














