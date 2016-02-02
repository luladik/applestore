<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <jsp:include page="/WEB-INF/pages/include/head-include.jsp"/>
    <title>View Profile</title>
</head>
<body>
<h2>View Profile</h2>
<div>Name: ${user.firstName} ${user.lastName}</div>
<div>Email: ${user.email}</div>

<a href="${user.name}/edit">Edit Profile</a>
</body>
</html>
