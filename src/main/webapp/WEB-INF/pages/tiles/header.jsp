<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid" id="header">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">APPLE STORE UA</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <sec:authorize access="hasRole('ADMIN')">
                <li class>
                    <a href="<c:url value="/categories/create"/>"> Add New Category</a>
                </li>
                <li class>
                    <a href="<c:url value="/products/create"/>">Add New Product</a>
                </li>
            </sec:authorize>

            <sec:authorize access="!isAuthenticated()">
                <li class=>
                    <a href="<c:url value="/login"/>" role="button">Sign In</a>
                </li>
                <li class>
                    <a href="<c:url value="/users?registration"/>" role="button">Sign Up</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class>
                    <a href="<c:url value="/cart"/>" role="button">
                        &nbsp;
                        <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
                        &nbsp;
                    </a>
                </li>
                <li class>
                    <a href="#" role="button">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        &nbsp;
                        <sec:authentication property="principal.username"/>
                    </a>
                </li>
                <li class>
                    <a href="<c:url value="/logout"/>" role="button">Logout</a>
                </li>
            </sec:authorize>
        </ul>
    </div>
</nav>