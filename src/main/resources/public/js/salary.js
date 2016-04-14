$(document).ready(function() {


	jQuery.ajax({
	  url: '/api/salary',
	  type: 'GET',
	  dataType: 'json',
	  complete: function(xhr, textStatus) {
	    //called when complete
	  },
	  success: function(data, textStatus, xhr) {
	  	var result1=data;
	  		var ta = $('#content').find('table');
	   		var tr = $('<tr></tr>').appendTo(ta);
	   		$('<td></td>').text(result1.experience).appendTo(th);
	  		$('<td></td>').text(result1.from3to5yrs).appendTo(th);
	  		$('<td></td>').text(result1.from0to1yrs).appendTo(th);
	  		$('<td></td>').text(result1.from4to10yrs).appendTo(th);
			

	  },
	  error: function(xhr, textStatus, errorThrown) {
	    alert("error");
	  }

	});
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
