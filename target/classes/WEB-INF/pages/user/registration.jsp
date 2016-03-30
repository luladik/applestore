<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<meta http-equiv="content-type" content="text/html;charset=UTF-8"/>--%>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
              type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
                integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
                crossorigin="anonymous"></script>

        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>"/>
    <title>Sign Up</title>
</head>

<body>
<div class="wrapper">
<form:form class="form-signin" name="input" method="post" action="users" modelAttribute="user">
    <h2 class="form-signin-heading">Sign Up</h2>
    <div>
        <label>Username: </label>
        <form:input class="form-control" type="text" path="name"/>
        <form:errors path="name" cssClass="error"/>
    </div>
    <div>
        <label>Password: </label>
        <form:input class="form-control" type="text" path="password"/>
        <form:errors path="password" cssClass="error"/>
    </div>
    <div>
        <label>Email: </label>
        <form:input class="form-control" type="text" path="email"/>
        <form:errors path="email" cssClass="error"/>
    </div>
    <div>
        <label>First name: </label>
        <form:input class="form-control" type="text" path="firstName"/>
        <form:errors path="firstName" cssClass="error"/>
    </div>
    <div>
        <label>Last name: </label>
        <form:input class="form-control" type="text" path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>
    </div>
    <div style="margin: 20px 10px 0 10px ">
        <input class="btn btn-primary btn-lg" type="submit" value="Submit">
        <a href="/" class="btn btn-danger btn-lg" style="float: right">Cancel</a>
    </div>
</form:form>
</div>

</body>
</html>
