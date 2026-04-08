<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import= "Patients.*"
    %>
<!DOCTYPE html>
<html>
<head>
    <title>Queue Handler</title>
    <link >
    <script src="JS/script.js"></script>

</head>
<body>
	<div id = "PatientQueue">
    <h1>Queue</h1>
    
   <%
   PatientServices s = (PatientServices) getServletContext().getAttribute("PatientServices"); 
   if (s == null)
	   out.print("<h3>" + "There is no Patients in list untill now!" + "</h3>");
   else
  		for (Patient p : s.getPatients())
  		{
			out.println( p.toString() );
  		}

  %>
    </div>
    <!-- Output element to display processed input -->
    <div id="output"></div>
</body>
</html>
