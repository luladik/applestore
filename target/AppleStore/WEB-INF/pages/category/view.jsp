<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/view.css"/>"/>
</head>
<body>
<div class="container">
    <div class="container-fluid">
        <div class="row heading-wrap">
            <sec:authorize access="hasRole('ADMIN')">
                    <a href="<c:url value="/categories/${category.id}/edit"/>">Edit Category</a>
            </sec:authorize>
            <div class="col-md-12 heading">
                <h3>${category.name}</h3>
            </div>
        </div>
        <div class="row">
            <c:forEach var="item" items="${category.products}">
                <div class="col-md-3 product">
                    <figure>
                        <a href="/products/${item.id}">
                            <img src="${item.imagePath}" align="middle" alt>
                        </a>
                        <div class="overlay" style="display: none">
                            <a href="${item.imagePath}" class="zoom prettyPhoto" style="background-position: 0 0"></a>
                            <a href="#" class="link" style="background-position: 0 0"></a>
                        </div>
                    </figure>
                    <div class="detail">
                        <span>$${item.price}</span>
                        <h4>${item.name}</h4>
                        <div class="icon">
                            <a href="#" class="one tooltip"></a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<%--<div class="container">--%>
<%--<div class="row">--%>
<%--<div class="col-md-6"><h2>View Category</h2></div>--%>
<%--<div class="col-md-6"><a href="/categories/${category.id}/edit">Edit Category</a></div>--%>
<%--</div>--%>

<%--<strong> ${category.name} </strong>--%>


<%--<h2>Products</h2>--%>

<%--<c:forEach var="item" items="${category.products}">--%>
<%--<c:out value="${item.name}"/> <br/>--%>
<%--</c:forEach>--%>
<%--</div>--%>

<%--<div>Description: ${category.description}</div>--%>

</body>
</html>
