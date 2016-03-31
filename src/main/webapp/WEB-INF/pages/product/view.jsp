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

    <h2 style="margin-left: 40px; margin-bottom: 20px">${product.name}</h2>

    <div class="container" style="margin-left: 50px">
        <div class="row">
            <div class="col-md-3">
                <img src="${product.imagePath}" style="max-width: 300px; max-height: 400px">
            </div>
            <div class="col-md-5" style="margin-left: 50px"><strong> Description: </strong>

                <div>${product.description}</div>
                <h2>$${product.price}</h2>

                <div style="margin-top: 20px">
                    <a href="<c:url value="/cart/add/${product.id}"/> " class="btn btn-danger">
                        <span class="glyphicon glyphicon-shopping-cart"></span> Add To Cart
                    </a>
                </div>
                <div>
                    <sec:authorize access="hasRole('ADMIN')">
                        <a href="<c:url value="/products/${product.id}/edit"/>"
                           class="btn btn-warning btn-md">Edit Product</a>
                    </sec:authorize>
                </div>


            </div>
        </div>
    </div>
</div>
</body>
</html>