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
		<h1>Register!</h1>
	    
	    <p class="text-danger"><form:errors path="user.*"/></p>
	    
	    <form:form method="POST" action="/registration" modelAttribute="user">
	        <p>
	            <form:label path="email">Email:</form:label>
	            <form:input type="email" path="email" class="form-control col-4"/>
	        </p>
	        <p>
	            <form:label path="password">Password:</form:label>
	            <form:password path="password" class="form-control col-4"/>
	        </p>
	        <p>
	            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
	            <form:password path="passwordConfirmation" class="form-control col-4"/>
	        </p>
	        <input type="submit" value="Register!" class="btn btn-info mb-3"/>
	    </form:form>
	    
	    <a href="/login">Login Here</a>
	
	
	
	
	</div>
</body>
</html>