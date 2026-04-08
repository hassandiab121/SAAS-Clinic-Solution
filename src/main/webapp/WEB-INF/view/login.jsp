<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
login Man!, you can enter before login.
			<form action="LoginAndDispatch" method="POST">
			        <h2>User Login</h2>
			
			        <div>
					            <label for="username">Username:</label>
					            <input type="text" id="username" name="username" required>
			        </div>
			        
			        <br>
			        <div>
					            <label for="password">Password:</label>
					            <input type="password" id="password" name="password" required>
			        </div>
			
			        <br>
			        <div>
			           			 <button type="submit">Log In</button>
			        </div>
			    </form>
</body>
</html>