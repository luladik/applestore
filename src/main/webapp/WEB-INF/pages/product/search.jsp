<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <jsp:include page="/WEB-INF/pages/include/head-include.jsp"/>
    <title>Search Product</title>
</head>
<body>
<div class="container">
    <h2>Search Products</h2>

    <div class="form-group form">
        <form:form name="input" method="get"
                   modelAttribute="product" action="/products">
            <div>
                <label>Name: </label>
                <form:input type="text" path="name" class="form-control"/>
                    <%--<form:errors path="name" />--%>
            </div>
            <div class="sel">
                <label>Category:</label>
                <form:select path="category.id" class="form-control">
                    <form:option value="NONE"> --- All Categories ---</form:option>
                    <form:options items="${categories}" itemLabel="name" itemValue="id"/>
                </form:select>
            </div>
            <div>
                <input type="submit" value="Submit" class="form-control">
            </div>


        </form:form>
    </div>

    <h2>Search Results:</h2>

    <%--<jsp:useBean id="results" scope="request" type="com.madislav.store.controller.sea"/>--%>
    <c:forEach var="product" items="${results}">
        <c:out value="${product.name}"/> <br/>
    </c:forEach>
</div>

</body>
</html>