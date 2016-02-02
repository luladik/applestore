<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
  <jsp:include page="/WEB-INF/pages/include/head-include.jsp"/>
  <title>Edit Category</title>
</head>
<body>
<h1>
  Apple Store
</h1>
  <div class="container">
  <h2>Edit Category</h2>
    <div class="form-group form">
      <form:form name="input" method="post" modelAttribute="category" action="/categories/${category.id}">
        <div>
          <label>Name: </label>
          <form:input class="form-control" type="text" path="name"/>
          <%--<form:errors path="name"/>--%>
        </div>
        <div>
          <label>Description: </label>
          <form:textarea class="form-control" path="description"/>
          <%--<form:errors path="name"/>--%>
        </div>
        <div>
          <input class="form-control submit" type="submit" value="Submit">
        </div>
      </form:form>
    </div>
  </div>

</body>
</html>