"use strict";

let diceLocked = "00000";

let die_1 = document.getElementById("die_1");
let die_2 = document.getElementById("die_2");
let die_3 = document.getElementById("die_3");
let die_4 = document.getElementById("die_4");
let die_5 = document.getElementById("die_5");

let diceToBeRolled = document.getElementById("diceToBeRolled");

let takeRoll = document.getElementById("takeRoll");

die_1.myParam = "die_1";
die_2.myParam = "die_2";
die_3.myParam = "die_3";
die_4.myParam = "die_4";
die_5.myParam = "die_5";


die_1.addEventListener("click", changeBackgroundColor);
die_2.addEventListener("click", changeBackgroundColor);
die_3.addEventListener("click", changeBackgroundColor);
die_4.addEventListener("click", changeBackgroundColor);
die_5.addEventListener("click", changeBackgroundColor);

die_1.classList.add("unlocked");
die_2.classList.add("unlocked");
die_3.classList.add("unlocked");
die_4.classList.add("unlocked");
die_5.classList.add("unlocked");



let updateDice = function () {
    diceToBeRolled.Value = "";

    if (die_1.classList.contains("locked")) {
        diceToBeRolled.Value += 0;

    }
    else {
        diceToBeRolled.Value += 1;


    }

    if (die_2.classList.contains("locked")) {
        diceToBeRolled.Value += 0;
    }
    else {
        diceToBeRolled.Value += 1;
    }
    if (die_3.classList.contains("locked")) {
        diceToBeRolled.Value += 0;
    }
    else {
        diceToBeRolled.Value += 1;
    }
    if (die_4.classList.contains("locked")) {
        diceToBeRolled.Value += 0;
    }
    else {
        diceToBeRolled.Value += 1;
    }
    if (die_5.classList.contains("locked")) {
        diceToBeRolled.Value += 0;
    }
    else {
        diceToBeRolled.Value += 1;
    }


    console.log(diceToBeRolled.Value);


}
takeRoll.addEventListener("submit", updateDice(), false);





function changeBackgroundColor(evt) {


    if (document.getElementById(evt.currentTarget.myParam).classList.contains("locked")) {
        document.getElementById(evt.currentTarget.myParam).classList.remove("locked");
        document.getElementById(evt.currentTarget.myParam).classList.add("unlocked");
    } else {
        document.getElementById(evt.currentTarget.myParam).classList.remove("unlocked");
        document.getElementById(evt.currentTarget.myParam).classList.add("locked");
    }
	
	updateDice();

}


