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
	   		$('<td></td>').text(result1.experience).appendTo(tr);
	  		$('<td></td>').text(result1.from3to5yrs).appendTo(tr);
	  		$('<td></td>').text(result1.from0to1yrs).appendTo(tr);
	  		$('<td></td>').text(result1.from4to10yrs).appendTo(tr);

	  },
	  error: function(xhr, textStatus, errorThrown) {
	    alert("error");
	  }
	});
