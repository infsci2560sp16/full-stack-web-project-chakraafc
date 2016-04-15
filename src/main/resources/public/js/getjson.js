
/*
function loadAJAX(){
var request;
if (window.XMLHttpRequest)  {

request=new XMLHttpRequest();

} else{
  request= new ActiveObject("Microsoft.XMLHTTP");
}

request.open('GET', 'api/salary');
request.onreadystatechange=function(){
  if((request.readyState==4) && (request.status==200)){

      var items=json.parse(request.responseTest);
      var output= '<ul>';
      for (var key in items){
        output +='<li>'+ items[key].name+'<li>';
      }
      output +='</ul>';
      document.getElementById('update').innnerHTML=output;

  }
}
request.send();


}//loadAJAX
*/
