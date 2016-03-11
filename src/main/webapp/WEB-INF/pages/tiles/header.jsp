<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<header class="container">

    <div class="row">
        <h1 class="col-sm-4">Apple Store</h1>
        <nav class="col-sm-8 text-right">

            <a href="categories?create">Add New Category</a>

            <div style="float:right">
                <a href="products?create">Add New Product</a>


                <c:choose>
                    <c:when test="${empty loggedInUser.name}">
                        <a href="users?registration">Sign Up</a>
                        <%--<spring:message code="homePage.registrationLink"/>--%>
                        <a href="login">Login</a>
                    </c:when>
                    <c:otherwise>
                        Hello ${loggedInUser.firstName}! &nbsp;
                        <a href="logout">Logout</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </nav>
    </div>
</header>
