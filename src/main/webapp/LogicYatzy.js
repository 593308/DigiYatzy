/**
 * 
 */

{
let die_1 = document.getElementById("die_1");
let die_2 = document.getElementById("die_2");
let die_3 = document.getElementById("die_3");
let die_4 = document.getElementById("die_4");
let die_5 = document.getElementById("die_5");


die_1.addEventListener("click", changeBackground());
die_2.addEventListener("click", changeBackground(die_2));
die_3.addEventListener("click", changeBackground(die_3));
die_4.addEventListener("click", changeBackground(die_4));
die_5.addEventListener("click", changeBackground(die_5));


}
function changeBackground(){

	document.getElementById("die_1").style.backgroundColor = "green"
	
}

