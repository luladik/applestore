<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6"><h2>View Category</h2></div>
        <div class="col-md-6"><a href="/categories/${category.id}/edit">Edit Category</a></div>
    </div>

    <strong> ${category.name} </strong>


    <h2>Products</h2>

    <c:forEach var="item" items="${category.products}">
        <c:out value="${item.name}"/> <br/>
    </c:forEach>
</div>

<div>Description: ${category.description}</div>

</body>
</html>
