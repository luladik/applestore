<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
  <jsp:include page="/WEB-INF/pages/include/head-include.jsp"/>
    <title>Registration</title>
</head>
<body>
<h1>New User Registration</h1>
<div class="container">
  <form:form class="form-group form" name="input" method="post" action="users" modelAttribute="user">
    <form:errors path="name" />
    Username: <input type="text" name="name"> <br/>
    <form:errors path="password"/>
    Password: <input type="text" name="password"> <br/>
    <form:errors path="email"/>
    Email: <input type="text" name="email"> <br/>
    <form:errors path="firstName"/>
    First name: <input type="text" name="firstName"> <br/>
    <form:errors path="lastName"/>
    Last name: <input type="text" name="lastName"> <br/>

    <input type="submit" value="Submit">

  </form:form>
</div>
</body>
</html>
