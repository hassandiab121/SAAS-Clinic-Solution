function myFunction() {
  alert("أدخل الأسم رباعي بالنسق المطلوب");
}

let id = 0;

/*
What to do for Ajax ?
1 - Create AJAX Object
2 - Define callback function
3 - Send request
*/

function deleteName(){
	let req = new XMLHttpRequest();
	
	req.onload = function sendData(){
		document.getElementById("1").remove();
	}
	
    let form = new FormData();
    
    form.append("i", "delete name from the list");
	
	req.open("PUT", "AddToDatabase")
	req.send(form);
}
	let data = "";
function getPatientName(){
	const name = document.getElementById("userInput").value;
	appendToData(name);
	
	const status = document.getElementById("status");
	appendToData(status.value);

	
	console.log(name + "\n" + status);
	// create xmlhttp object
	let xml_http_req = new XMLHttpRequest();
	
	// define a callback function
	xml_http_req.onload= function getResponse() {
		document.getElementById("output").innerHTML += "<tr id="+ 1 +"><td>"+status.options[status.selectedIndex].text +"</td><td>"+name+"</td></tr>";
		++id;
		document.getElementById("price").innerHTML = xml_http_req.response;
		
	}
	
	//send request 
	xml_http_req.open("POST","queue");
	xml_http_req.setRequestHeader("Content-Type", "text/xml; charset=utf-8");
	console.log(data);
	xml_http_req.send(data);
	data = "";
	
}

/*
Why i use this instead of FormData Object ? 
- Cause servlet can not deenacapsulate the request data intuitively, So I use a pliantext with some structure as you see.
*/

function appendToData(str){
	return data += str +"\n"
}