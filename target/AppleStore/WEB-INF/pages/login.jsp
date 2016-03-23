<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>"/>
    <title>Login Page</title>
</head>
<body>

<div class="wrapper">

    <c:url var="loginUrl" value="/login"/>
    <form action="${loginUrl}" method="post" class="form-signin">
        <h2 class="form-signin-heading">Please login</h2>
        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                <p>Invalid username or password.</p>
            </div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div class="alert alert-success">
                <p>You have been logged out successfully.</p>
            </div>
        </c:if>
        <input type="text" class="form-control" id="username" name="ssoId" placeholder="Enter Username">

        <input type="password" class="form-control" id="password" name="password"
               placeholder="Enter Password"
               required>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>

    </form>
</div>


</body>
</html>