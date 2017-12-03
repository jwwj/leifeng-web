
				
function onClick1() {
	
		document.getElementById("cur1").className = "current";
		document.getElementById("cur2").className = "current1";
		document.getElementById("tab1").style.display = "block";
		document.getElementById("tab2").style.display = "none";
	}
function onClick2() {
	
	document.getElementById("cur1").className = "current1";
	document.getElementById("cur2").className = "current";
	document.getElementById("tab2").style.display = "block";
	document.getElementById("tab1").style.display = "none";

}