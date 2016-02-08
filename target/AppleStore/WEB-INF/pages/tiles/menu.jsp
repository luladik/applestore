<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<div style="float:right">
<c:choose>
	<c:when test = "${empty loggedInUser.name}">
		<a href="users?create">Register</a> &nbsp;
		<a href="login">Login</a>
	</c:when>
	<c:otherwise>
		Hello ${loggedInUser.firstName}! &nbsp;
		<a href="logout">Logout</a>
	</c:otherwise>
</c:choose>

</div>
