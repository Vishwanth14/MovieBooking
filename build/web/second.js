function check(){
	var n = document.form1.r1;
	for(i=0;i<n.length;i++)
	{
		if(n[i].checked == true)
		{
			return true;
		}
	}
	alert("Select a movie");
	return false;
}