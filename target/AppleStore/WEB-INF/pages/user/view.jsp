<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <jsp:include page="/WEB-INF/pages/include/head-include.jsp"/>
    <title>${user.name}</title>
</head>
<body>
<div class="jumbotron">
    <div class="container" style="margin-left: 120px">
        <div style="margin-bottom: 20px"><h2>Profile</h2></div>
        <fieldset class="form-group">
            <label class="col-sm-2 control-label">Username:</label>

            <label class="col-sm-10">${user.name}</label>
        </fieldset>

        <fieldset class="form-group">
            <label class="col-sm-2 control-label">First Name:</label>

            <label class="col-sm-10">${user.firstName}</label>
        </fieldset>

        <fieldset class="form-group">
            <label class="col-sm-2 control-label">Last Name:</label>

            <label class="col-sm-10">${user.lastName}</label>
        </fieldset>

        <fieldset class="form-group">
            <label class="col-sm-2 control-label">Email:</label>

            <label class="col-sm-10">${user.email}</label>
        </fieldset>

        <fieldset class="form-group">
            <label class="col-sm-2 control-label">Phone:</label>

            <label class="col-sm-10">${user.phone}</label>
        </fieldset>

        <fieldset class="form-group">
            <label class="col-sm-2 control-label">Password:</label>

            <label class="col-sm-10">${user.password}</label>
        </fieldset>

        <a class="btn btn-danger" href="/${user.name}/edit">Edit Profile</a>

    </div>
</div>

</body>
</html>
