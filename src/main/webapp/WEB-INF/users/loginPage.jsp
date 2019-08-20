<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

	<div class="container">
	
		<h1>Login</h1>
		
	    <p><c:out value="${error}" /></p>
	    
	    <form method="post" action="/login">
	        <p>
	            <label for="email">Email</label>
	            <input type="text" id="email" name="email" class="form-control col-4"/>
	        </p>
	        <p>
	            <label for="password">Password</label>
	            <input type="password" id="password" name="password" class="form-control col-4"/>
	        </p>
	        <input type="submit" value="Login!" class="btn btn-info mb-3"/>
	    </form>    
	    
	    <a href="/registration">Register Here</a>
	
	
	
	</div>
</body>
</html>