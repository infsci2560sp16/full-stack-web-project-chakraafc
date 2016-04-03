//XML GET
window.onload = browseThread;
function browseThread () {
	$.ajax({
		url : "/api/forum",
		type : "get",
		success : function(result) {
			$("#inv").html("");
			console.log(result);//Testing
			threads = result.getElementsByTagName("thread");
			for ( var i = 0; i < threads.length; i++) {
        $("div#demos").append('<div class="edemo" id="demo1">'+
        												  
        		    									'<h4>Title:'+'<a href="#">'+threads[i].childNodes[0].firstChild.nodeValue+'</a></h4>'+
        													'<p>Username:'+threads[i].childNodes[1].firstChild.nodeValue+'|Practise Language:'+threads[i].childNodes[2].firstChild.nodeValue+'</p>'+
        	        								'<p class="description">Short Description:<br/>'+threads[i].childNodes[4].firstChild.nodeValue+'</p>'+
        													'<span class="time">Topic:'+threads[i].childNodes[3].firstChild.nodeValue+'</span>'+'</div>');
			}
		}
	});
