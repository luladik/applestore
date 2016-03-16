<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="/">Apple Store</a>
    </div>
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
                <li class>
                    Hello ${loggedInUser.firstName}! &nbsp;
                </li>
                <li class>
                    <a href="logout">Logout</a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>