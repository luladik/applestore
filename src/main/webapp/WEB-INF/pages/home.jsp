<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <jsp:include page="/WEB-INF/pages/include/head-include.jsp"/>
    <title><spring:message code="welcome"/></title>
</head>
<body>
<div class="container">

    <div class="container">
        <div class="left-container">
            <h2>Products</h2>
            <c:forEach var="item" items="${productList}">
                <div class="row">
                    <c:out value="${item.name}"/> &nbsp;
                    <a href="cart/add/${item.id}">Add to cart</a> <br/>
                </div>
            </c:forEach>
        </div>

        <div class="right-container">
            <h2>Categories</h2>
            <c:forEach var="category" items="${allCategories}">
                <a href="categories/${category.id}"><c:out value="${category.name}"/></a> <br/>
            </c:forEach>
        </div>
    </div>

</div>

</body>
</html>