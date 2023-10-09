function check1(){
	var n = document.form2.r2;
	for(i=0;i<n.length;i++)
	{
		if(n[i].checked == true)
		{
			return true;
		}
	}
	alert("Select a Theatre");
	return false;
}