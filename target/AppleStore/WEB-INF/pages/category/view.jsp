<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <jsp:include page="/WEB-INF/pages/include/head-include.jsp"/>
    <title>View Category</title>
</head>
<body>
<div class="container">
    <h2>View Category</h2>
    <div><strong> Name: </strong></div>
    <div> ${category.name} </div>
    <div><strong> Description: </strong> </div>
    <div> ${category.description}</div>


    <a href="/categories/${category.id}/edit">Edit Category</a>


    <h2>Products</h2>

    <c:forEach var="item" items="${category.products}">
        <c:out value="${item.name}"/> <br/>
    </c:forEach>
</div>

</body>
</html>
