$(document).ready(function() {
	jQuery.ajax({
	  url: '/api/info',
	  type: 'GET',
	  dataType: 'xml',
	  complete: function(xhr, textStatus) {
	    //called when complete
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
	
