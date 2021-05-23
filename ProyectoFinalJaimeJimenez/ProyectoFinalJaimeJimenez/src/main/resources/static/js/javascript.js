let el = document.getElementById('cambioColor');
let val = el.innerHTML;

if (val === "Excepcional") {
	el.className = "card-text exotico";
} else if (val === "Legendario") {
	el.className = "card-text legendario";
}


function validateForm() {
	var x = document.forms["myForm"]["fname"].value;
	if (x == "") {
		alert("Name must be filled out");
		return false;
	}
}






