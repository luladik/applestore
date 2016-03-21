<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <jsp:include page="/WEB-INF/pages/include/head-include.jsp"/>
    <title>View product</title>
</head>
<body>
<div class="container">
    <h2>View Product</h2>

    <div><strong> Name: </strong></div>
    <div> ${product.name} </div>
    <div><strong> Description: </strong></div>
    <div> ${product.description}</div>
    <div>
        <img src="${product.imagePath}" style="max-width: 500px; height: 200px; border: 3px solid #73AD21">
    </div>


    <a href="/products/${product.id}/edit">Edit product</a>
</div>

<%-- <h3>Products</h3>

<c:forEach var="item" items="${category.products}">
	<c:out value="${item.name}"/> <br/>
</c:forEach>
 --%>

</body>
</html>