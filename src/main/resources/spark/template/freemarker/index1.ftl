
<!DOCTYPE html>
<html>
<head>
<title>this is my home page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"  lang="en" >
<link rel="stylesheet" type="text/css" href="../stylesheets/stylehome.css">
<style>
input[type='text'] { font-size: 24px; }
input[type='password'] { font-size: 24px; }

</style>
<script>

function userValidation()
{
var email= document.getElementById("email").value;
var pass=document.getElementById("pass").value;
var emailreg= /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,6}$/;
if(email!="" && pass!="")
{
  if(email.match(emailreg))
  {
    if(pass.length>=6 && pass.length<=20)
    {
      alert("login sucessfull");
      return true;
    }
    else
    {
    alert("password invalid- atlest 6 character needed");
    return false;
    }

  }
  else
  {
  alert("invalid email");
  return false;
  }

}
else
{
alert("user id and password cannot be left blank");
return false;
}


}
</script>
<style>
h1{font-family:cursive;
  font-size:100px;
  color:blue;
}
</style>


</head>
<body>
<div id="header">

<img src="../images/mainlogo.png" alt="Mountain View" >


</div>

<div id="nav">
<a href="index1.html">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="eservices.html">E-SERVICES</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="services.html">SERVICES</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<a href="aboutus.html">ABOUT-US</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="contact.html">CONTACT-US</a>

</div>

<div id="section">
<h1>Welcome</h1>

<form  action="function.html" method="get"  onsubmit="return userValidation()" >
<h2 style="font-family:arialblack" >Employee LOGIN</h2><br>
USERNAME:<br><input id="email" type="text" placeholder="enter email as username" size="70"  style="height: 50px;"><br><br>
PASSWORD:<br> <input id="pass" type="password" placeholder="password must contain atleast 6 character" size="70" style="height: 50px;"> <br><br>
<input type="submit" value="Login"   style="height:70px; width:100px; font-size:30px"><br><br>
<h2>New Employee: <a href="eservices.html"> click here to register</a></h2>
</form><br><br>

<p>Welcome! Ideal Homecare Agency LLC provides quality home care services in PA
and OH. Our Services are rendered by qualified employees under the direction of
a qualified Agency Directors and staffs.  Ideal Homecare Agency LLC commits to
adhering to all state, federal and local statutes and regulation and is guided
by the Agency written Mission Statement.Our agency will provide services in the
following counties:Allegheny, Westmoreland, Washington,Butler, Beaver in
Pennsylvania and Cuyahoga, Lorain, Lake, Summit, Portage, Star,Franklin, Delaware,
 Fairfield, Hamilton, Butler, Clermont in Ohio.Welcome! Ideal Homecare Agency LLC provides quality home care services in PA
 and OH. Our Services are rendered by qualified employees under the direction of
 a qualified Agency Directors and staffs.  Ideal Homecare Agency LLC commits to
 adhering to all state, federal and local statutes and regulation and is guided
 by the Agency written Mission Statement.Our agency will provide services in the
 following counties:Allegheny, Westmoreland, Washington,Butler, Beaver in
 Pennsylvania and Cuyahoga, Lorain, Lake, Summit, Portage, Star,Franklin, Delaware,
  Fairfield, Hamilton, Butler, Clermont in Ohio.Welcome! Ideal Homecare Agency LLC provides quality home care services in PA
  and OH. Our Services are rendered by qualified employees under the direction of
  a qualified Agency Directors and staffs.  Ideal Homecare Agency LLC commits to
  adhering to all state, federal and local statutes and regulation and is guided
  by the Agency written Mission Statement.Our agency will provide services in the
  following counties:Allegheny, Westmoreland, Washington,Butler, Beaver in
  Pennsylvania and Cuyahoga, Lorain, Lake, Summit, Portage, Star,Franklin, Delaware,
   Fairfield, Hamilton, Butler, Clermont in Ohio<p><br><br>
<h3<a href="#"><br>looking for job${jobAtIdeal}</a></h3>

<#if jobAtIdeal == "Technology"|| jobAtIdeal == "HealthCare"||>

        <#list 0..technologys?size-1 as i>
        <h4>${healthworker[i]}</h4>
        </#list>

       <#elseif jobAtIdeal== "HumanResources">
       <#list 0..admin?size-1 as i>
       <h4>${admin[i]}</h4>
       </#list>

        <#else>
        <#list 0..technology?size-1 as i>
        <h4>${admin[i]}</h4>
        </#list>

        </#if>

</div>


<div id="footer">
<p> copyright  &copy; chn38@pitt.edu </p>
</div>

</body>
</html>
