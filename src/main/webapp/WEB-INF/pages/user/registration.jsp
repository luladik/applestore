<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%--<meta http-equiv="content-type" content="text/html;charset=UTF-8"/>--%>
  <jsp:include page="/WEB-INF/pages/include/head-include.jsp"/>
    <title>Registration</title>
</head>

<body>

<div class="container">
  <h1>New User Registration</h1>
  <form:form class="form-group form" name="input" method="post" action="users" modelAttribute="user">
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
    <%--Username: <input type="text" name="name"> <br/>--%>
    <%--<form:errors path="password" cssClass="error"/>--%>
    <%--Password: <input type="text" name="password"> <br/>--%>
    <%--<form:errors path="email" cssClass="error"/>--%>
    <%--Email: <input type="text" name="email"> <br/>--%>
    <%--<form:errors path="firstName" cssClass="error"/>--%>
    <%--First name: <input type="text" name="firstName"> <br/>--%>
    <%--<form:errors path="lastName" cssClass="error"/>--%>
    <%--Last name: <input type="text" name="lastName"> <br/>--%>
    <div>
      <input class="form-control" type="submit" value="Submit">
    </div>


  </form:form>
</div>
</body>
</html>
