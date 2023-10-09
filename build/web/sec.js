function pass()
{
	var u = document.getElementById('u').value;
    var p = document.getElementById('e').value;
    var pattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
    if(isNaN(u) == false)
    {
        text = "Enter a name";
       	alert(text);
        return false;
    }
    if(pattern.test(e) == false)
    {
        text = "Enter a valid email";
        alert(text);
        return false
    }
    return true;
}