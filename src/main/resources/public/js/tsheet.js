<script language="javascript">
   var xmlhttp;
   function init() {
      // put more code here in case you are concerned about browsers that do not provide XMLHttpRequest object directly
      xmlhttp = new XMLHttpRequest();
   }
   function getdetails() {
       var empno = document.getElementById("empno");
       var url = "http://localhost:8084/restful.webservices.cp/resources/employee/"+value.empno ;
       xmlhttp.open('GET',url,true);
       xmlhttp.send(null);
       xmlhttp.onreadystatechange = function() {

              var empname =  document.getElementById("empname");
              var age =  document.getElementById("age");
              if (xmlhttp.readyState == 4) {
                 if ( xmlhttp.status == 200) {
                      var det = eval( "(" +  xmlhttp.responseText + ")");
                      if (det.age > 0 ) {
                         empname.value = det.name;
                         age.value = det.age;
                      }
                      else {
                          empname.value = "";
                          age.value ="";
                          alert("Invalid Employee ID");
                      }
                }
                else
                      alert("Error ->" + xmlhttp.responseText);
             }
       };
   }
 </script>
