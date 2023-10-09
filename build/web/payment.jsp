<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}


.row {
  display: -ms-flexbox; 
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}


.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}


.col-50,
.col-75 {
  padding: 0 16px;
  width: 30%;
}

.container {
  float: center;
  width: 70%;
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}
.v{
margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
  }


input[type=text] {

  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 40%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

</style>
<script type="text/javascript" src="pay.js">
</script>
</head>
<body>

<h2>Payment</h2>
<div class="row">
  <div class="col-75">
    <div class="container">
        <form action="sets" onsubmit="return finalcheck()">
      
        

          <div class="col-50">
            <h3>Payment</h3>
            <label for="fname">Accepted Cards</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-mastercard" style="color:blue;"></i>
              <i class="fa fa-cc-amex" style="color:red;"></i>
              
            </div>
            <label for="cname">Name on Card</label>
            <input style="width: 150%;" type="text"  id="cname" name="cardname" placeholder="Enter your name">
            <p style="color: red;" id = "qwerty1" ></p>
            <label for="ccnum">Credit card number</label>
            <input style="width: 150%;" type="text"  id="ccnum" name="cardnum" placeholder="Enter credit card number without any special characters ">
            <p style="color: red;" id = "qwerty"></p>
            <label for="expmonth">Expiry Month</label>
            <select id="mySelect" class="v">
            <option value="jan">January</option>
            <option value="feb">February</option>
            <option value="mar">March</option>
            <option value="apr">April</option>
            <option value="may">May</option>
            <option value="jun">June</option>
            <option value="jul">July</option>
            <option value="aug">August</option>
            <option value="sep">September</option>
            <option value="oct">October</option>
            <option value="nov">November</option>
            <option value="dec">December</option>
            </select>
            
                <label for="expyear">Expiry Year</label>
                <select id="expyear" class="v">
                <option value="2020">2020</option>
                <option value="2021">2021</option>
                <option value="2022">2022</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
                </select>
                <label for="cvv">CVV</label>
                <input style="width: 150%;" type="password" id="cv" name="cv" placeholder="Enter CVV(3-digit number provided on the backside of credit card)"> 

                <p style="color: red;" id="demo"></p>
              
          </div>
             
           
            <a href="sets">Proceed</a>
        </form>
    
  
  

</body>
</html>
