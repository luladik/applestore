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
<%--<jsp:useBean id="loggedInUser" scope="request"--%>
			 <%--class="com.madislav.store.model.Customer"/>--%>

	<div class="container">
	<div style="float:right; margin-top: -30px;">
		<p>${loggedInUser.name}</p>
		<c:choose>
			<c:when test="${empty loggedInUser.name}">
				<a href="users?registration"><spring:message code="homePage.registrationLink"/> </a>
				<a href="login">Login</a>
			</c:when>
			<c:otherwise>
				Hello ${loggedInUser.firstName}! &nbsp;
				<a href="cart">Go To Cart</a>
				<a href="logout">Logout</a>
			</c:otherwise>
		</c:choose>
	</div>
		<div class="nav nav-pills">
			<div style="float:right; margin-right: auto">
				<a href="categories?create">Categories</a>
			</div>
			<div style="float:right">
				<a href="products?create">Products</a>
			</div>
			<div>
				<a href="login">Login</a>
			</div>
			<div>
				<a href="users?registration">Sign Up</a>
			</div>
		</div>

	<h1>${message}</h1>
	<h2>Products:</h2>
	<c:forEach var="item" items="${productList}">
		<c:out value="${item.name}"/> &nbsp;
		<a href="cart/add/${item.id}">Add to cart</a> <br/>
	</c:forEach>

	<c:forEach var="category" items="${allCategories}">
		<a href="categories/${category.id}"><c:out value="${category.name}"/></a> <br/>
	</c:forEach>
	</div>
</body>
</html>