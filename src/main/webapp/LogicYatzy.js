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



let updateDice = function (die1, die2, die3, die4, die5, diceLocked) {
   
    diceLocked = "";

    if (die1.classList.contains("locked")) {
        diceLocked += 0;
    }
    else {
        diceLocked += 1;
    }

    if (die2.classList.contains("locked")) {
        diceLocked += 0;
    }
    else {
        diceLocked += 1;
    }
    if (die3.classList.contains("locked")) {
        diceLocked += 0;
    }
    else {
        diceLocked += 1;
    }
    if (die4.classList.contains("locked")) {
        diceLocked += 0;
    }
    else {
        diceLocked += 1;
    }
    if (die5.classList.contains("locked")) {
        diceLocked += 0;
    }
    else {
        diceLocked += 1;
    }

    diceToBeRolled.value = diceLocked;
	


}
takeRoll.addEventListener("submit", updateDice(die_1, die_2, die_3, die_4, die_5, diceLocked), false);





function changeBackgroundColor(evt) {

    if (document.getElementById(evt.currentTarget.myParam).classList.contains("locked")) {
        document.getElementById(evt.currentTarget.myParam).classList.remove("locked");
        document.getElementById(evt.currentTarget.myParam).classList.add("unlocked");
    } else {
        document.getElementById(evt.currentTarget.myParam).classList.remove("unlocked");
        document.getElementById(evt.currentTarget.myParam).classList.add("locked");
    }

}


