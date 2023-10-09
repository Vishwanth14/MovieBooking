function dare()
{
    var u = document.getElementById('un').value;
    var p = document.getElementById('pa').value;
    var c = document.getElementById('co').value;
    var e = document.getElementById('em').value;
    var ph = document.getElementById('ph').value;
    var emg = document.getElementById('new_error');
    var pattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
    emg.style.padding = "5px";
    var text;
    if(isNaN(u) == false)
    {
        text = "Enter a name";
        emg.innerHTML = text;
        return false;
    }
    if(p.length < 6)
    {
        text = "Password length must be greater than 6 ";
        emg.innerHTML = text;
        return false
    }
    if(p != c)
    {
        text = "Both the passwords should match";
        emg.innerHTML = text;
        return false
    }
    if(pattern.test(e) == false)
    {
            text = "Enter a valid email";
            emg.innerHTML = text;
            return false
    }
    if((isNaN(ph)) || (ph.length != 10))
    {
        text = "Enter a valid mobile no";
        emg.innerHTML = text;
        return false
    }
}