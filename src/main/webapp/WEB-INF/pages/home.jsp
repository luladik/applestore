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
	<div style="float:right; margin-top: -30px;">
		<c:choose>
			<c:when test="${empty loggedInUser.name}">
				<a href="users?registration"><spring:message code="homePage.registrationLink"/> </a>
				<a href="login">Login</a>
			</c:when>
			<c:otherwise>
				Hello ${loggedInUser.firstName}! &nbsp;
				<a href="logout">Logout</a>
			</c:otherwise>
		</c:choose>
		<a href="users?registration">Register</a>
	</div>
		<div class="tab-container">
		<div style="float:right">
			<a href="categories?create">Cat</a>
		</div>
		<div style="float:right">
			<a href="products?create">Pro</a>
		</div>
		</div>

	<h1>${message}</h1>
	<h2>Products:</h2>
	<c:forEach var="item" items="${productList}">
		<c:out value="${item.name}"/> <br/>
	</c:forEach>

	<c:forEach var="category" items="${allCategories}">
		<a href="categories/${category.id}"><c:out value="${category.name}"/></a> <br/>
	</c:forEach>
	</div>
</body>
</html>