$(document).ready(function() {

	jQuery.ajax({
	  url: '/api/info',
	  type: 'GET',
	  dataType: 'xml',
	  complete: function(xhr, textStatus) {

	  },
	  success: function(xml) {
	  	    $(xml).find('user_profile').each(function(index, el) {
	   		var lastname = $(this).children('ProductName').text();
	   		var firstname = $(this).children('January').text();
	   		var ssn = $(this).children('Febuary').text();
	   		var gender = $(this).children('March').text();
	   		var ta = $('#content').find('table');
	   		var tr = $('<tr></tr>').appendTo(ta);
	   		$('<td></td>').text(lastname).appendTo(tr);
	   		$('<td></td>').text(firstname).appendTo(tr);
	   		$('<td></td>').text(ssn).appendTo(tr);
	   		$('<td></td>').text(gender).appendTo(tr);
	   });
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
