<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <jsp:include page="/WEB-INF/pages/include/head-include.jsp"/>
    <title>View product</title>
</head>
<body>
<div class="container">

    <h2>View Product</h2>
    <sec:authorize access="hasRole('ADMIN')">
        <a href="<c:url value="/products/${product.id}/edit"/>">Edit Category</a>
    </sec:authorize>
    <div><strong> Name: </strong></div>
    <div> ${product.name} </div>
    <div><strong> Description: </strong></div>
    <div> ${product.description}</div>
    <div>
        <img src="${product.imagePath}" style="max-width: 500px; height: 200px">
    </div>
    <a href="<c:url value="/cart/add/${product.id}"/> ">Add To Cart</a>

</div>
</body>
</html>