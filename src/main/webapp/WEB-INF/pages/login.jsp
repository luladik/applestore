<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
	<jsp:include page="/WEB-INF/pages/include/head-include.jsp"/>
<title>Login</title>
</head>
<body>
<div class="container">
<%--${loginError}--%>
<div class="form-group form">
	<%--modelAttribute=="loggedInUser"--%>
	<form:form name="input" action="/login" method="post">
		<div>
			<label>User name:</label>
			<input type="text" id="userId" name="userId" placeholder="user name" class="form-control"/>
		</div>
		<div>
			<label>Password:</label>
			<input type="password" id="password" name="password" placeholder="password" class="form-control"/>
		</div>
		<button id="loginButton" class="form-control">Login</button>
	</form:form>
</div>
</div>
</body>
</html>