<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <jsp:include page="/WEB-INF/pages/include/head-include.jsp"/>
    <title>Edit</title>
</head>
<body>
<h1>Apple Store</h1>

<div class="container">
    <form:form class="form-group form" name="input" method="post" action="/users/${user.name}" modelAttribute="user">
        <form:input type="hidden" path="id"/>
        <div>
            <label>Username:</label>
            <form:input class="form-control" type="text" path="name" readonly="true"/>
        </div>
        <div>
            <label>Password: </label>
            <form:input class="form-control" type="text" path="password"/>
                <%--<form:errors path="password" />--%>
        </div>
        <div>
            <label>Email:</label>
            <form:input class="form-control" type="text" path="email"/>
                <%--<form:errors path="email" />--%>
        </div>
        <div>
            <label>First Name:</label>
            <form:input class="form-control" type="text" path="firstName"/>
                <%--<form:errors path="firstName" />--%>
        </div>
        <div>
            <label>Last Name:</label>
            <form:input class="form-control" type="text" path="lastName"/>
                <%--<form:errors path="lastName" />--%>
        </div>
        <div>
            <input class="form-control" type="submit" value="Submit">
        </div>
    </form:form>
</div>
</body>
</html>