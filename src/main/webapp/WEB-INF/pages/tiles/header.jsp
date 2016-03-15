<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet">
<header>
    <div class="container-fluid">
        <%--<div class="navbar-header">--%>
        <%----%>
        <%--</div>--%>
        <h1 class="col-sm-4">Apple Store</h1>
        <ul class="nav navbar-nav navbar-right">

            <c:choose>
                <c:when test="${loggedInUser.name == 'admin'}">
                    <li class>
                        <a href="categories?create">Add New Category</a>
                    </li>
                    <li class>
                        <a href="products?create">Add New Product</a>
                    </li>
                </c:when>
            </c:choose>


            <c:choose>
                <c:when test="${empty loggedInUser.name}">
                    <li class>
                        <a href="users?registration">Sign Up</a>
                    </li>
                    <li class>
                        <a href="login">Login</a>
                    </li>
                </c:when>
                <c:otherwise>
                    Hello ${loggedInUser.firstName}! &nbsp;
                    <li class>
                        <a href="logout">Logout</a>
                    </li>

                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</header>
