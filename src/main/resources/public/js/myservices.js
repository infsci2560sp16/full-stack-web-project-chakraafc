$(document).ready(function() {
	$('#submit').click(function()
  {

        var firstname = document.getElementById("firstname").value;
        var lastname = document.getElementById("lastname").value;
        var address = document.getElementById("address").value;
        var city = document.getElementById("city").value;
        var state = document.getElementById("state").value;
        var zipcode = document.getElementById("zipcode").value;
        var employeeid = document.getElementById("employeeid").value;
        var email = document.getElementById("email").value;
        var pass = document.getElementById("pass").value;




         var send= JSON.stringify({ "register-fname": firstname , "register-lastname": lastname , "register-address": address, "register-city":city, "register-state": state,
         "register-zipcode":zipcode, "register-employeeid":employeeid, "register-email": email, "register-password":pass});
      $.ajax({
          contentType:'application/json',
          url:"/adduser",
          type:"POST",
          datatype: "json",
          data: send,
          success: function(data)
          {
            alert("succeeded");
            window.location.href='/user_info';
         }

        });
    }
  );
  $('.searchoption').bind('click', function(event) {
  		$('.searchoption').find('ul').animate({
  			height: 120},
  			200);
  		event.stopPropagation();
  	});

  	$(document).bind('click', function(event) {
  		$('.searchoption').find('ul').animate({
  			height: 0},
  			200);
  	});

  	$('.searchoption').find('li').bind('click', function(event) {
  		$('.searchoption').find('ul').animate({
  			height: 0},
  			200);
  		$('.searchoption').find('label').text($(this).text());
  		event.stopPropagation();
  	});

  	$('.strecth').bind('click', function(event) {
  		$('nav').animate({
  			width: 250},
  			200);
  		$('nav ul').animate({
  			width: 250},
  			200);
  		$('nav ul li').animate({
  			width: 248},
  			200);
  		$('.strecth').animate({
  			left: 220},
  			200);
  	});
  });

function employeeValidation()
{
	var firstname= document.getElementById("firstname").value;
	var lastname= document.getElementById("lastname").value;
	var email= document.getElementById("email").value;
	var address= document.getElementById("address").value;
	var city= document.getElementById("city").value;
	var state= document.getElementById("state").value;

	var zipcode= parseInt(document.getElementById("zipcode").value);
	var employeeid= document.getElementById("employeeid").value;
	var pass=document.getElementById("pass").value;
	var pass1=document.getElementById("pass1").value;
	var emailreg= /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,6}$/;
	var alphareg=/^[A-Za-z]+$/;
	var alphanum= /^[0-9a-zA-Z]+$/;



	if(firstname!=="" && lastname!=="" && address!=="" && city!=="" && state!=="" && zipcode!=="" && employeeid!=="" && email!=="")
	{
		if(email.match(emailreg))
		{
			if(firstname.match(alphareg))
			{
				if(employeeid.match(alphanum))
				{
	              if(pass.match(pass1))
				  {
					  if(pass.length>=6 && pass.length<=20)
					  {
						alert("data suceessfully validated");
			            return true;
					  }
					  else
					  {
						alert("password must contain 6 to 20 character");
                       return false;
					  }
				  }
				  else
				  {
					alert("password cannot be matched");
					return false;
				  }

				}
				else
				{
				alert("enter a valid emp id");
				return false;
				}

			}
			else{
				alert("enter a valid first name");
				return false;
			}
		}

		else{
			alert("enter a valid email");
			return false;
		}
	}
	else{
		alert("all fields are required");
		return false;
	}

}
