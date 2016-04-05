$(function () {
  $.ajax({
    url: "/api/find",
    type : "get",
    success: function (result) {
      var member = JSON.parse(result);
      for (var i = 0; i < member.length; i++) {
        if (i%2 !== 0) {
          $("div#members").append('<div class="edemo">'+

                                '<h4>Firstname:'+member[i].firstname+'</h4>'+
                                '<br/>'+'<p>employee id: '+member[i].employeeid+'</p>'+
                                  '<br/>'+'<p>Salary: '+member[i].salary+'</p>'+
                                  '<br/>'+'<p>Increment: '+member[i].increment+'</p>'+
                                    '<br/>'+'<p>Bonus: '+member[i].bonus+'</p>'+'</div>');
        } else {
          $("div#members").append('<div class="demo">'+

                                          '<h4>Firstname:'+member[i].firstname+'</h4>'+
                                          '<br/>'+'<p>employee id: '+member[i].employeeid+'</p>'+
                                            '<br/>'+'<p>Salary: '+member[i].salary+'</p>'+
                                            '<br/>'+'<p>Increment: '+member[i].increment+'</p>'+
                                              '<br/>'+'<p>Bonus: '+member[i].bonus+'</p>'+'</div>');


        }
      }

    }});
  });
