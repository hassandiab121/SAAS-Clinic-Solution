<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.LinkedList"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
<script src="JS/script.js"></script>
  <link rel="stylesheet" href="CSS/style.css">
</head>

<body>
  
<!--  <form action="queue" method=post>   -->
<br>
<div id="form"> 
        <table  id="output">
            <tr>
		            <td> 
				            <select id="status">
						            <option value=0>"كشف جديد"</option>
						            <option value=1>"إعادة"</option> 
				            </select>
		            </td>
		            <td><input type="text" name="patientname"  id="userInput"/></td>
		            <td>: أسم المريض </td>
            </tr>
   
            <tr>
		            <td></td>
		            <td><input type="submit" id="btnSubmit" value="أدخال"  onclick="getPatientName()"></td>
		            <td id= "price"></td>
            </tr>
        </table>
</div>
 <!--    </form> --> 
    
    
<%  // Scriplte 1 check if you input an invalid name or not 
if (session.getValue("checker") != null) {
%>
<script>
myFunction()
</script>
<%
session.removeAttribute("checker");
}
%>



<% // Create tabel with patint name
if (application.getAttribute("patientList") != null) {
	
	LinkedList<String> patientList = (LinkedList<String>) application.getAttribute("patientList");
		for (int index = patientList.size()-1 ; index >= 0 ; index-- ) {
			out.println("<tr> <td>" + patientList.get(index) +"</td></tr>" );
			out.println("<br>");
		}
application.setAttribute("number", patientList.size());

}
%>

<button id="AddToDatabase" onclick=deleteName() >تم الكشف - أضف لقواعد البايانات</button>
    
    
    <div id="patientList"></div>
    
    <h1><%request.getAttribute("done"); %></h1>


</body>
</html>