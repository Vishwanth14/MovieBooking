function check3(){
	var n = document.form3.r3;
	for(i=0;i<n.length;i++)
	{
		if(n[i].checked == true)
		{
			return true;
		}
	}
	alert("Select a time");
	return false;
}