function ne(){
	var p = document.getElementById('ide').value;
	if((p<=0) || (p == "") || (isNaN(p)))
	{
		alert("Enter a valid number");
		return false;
	}
	if(p > 9)
	{
		alert("You can at max chhose only 9 tickets");
		return false;
	}
	return true;
}