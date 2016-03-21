<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container">

    <div class="jumbotron" style="margin-top: 20px;">
        <h1>Devcolibri.com</h1>
        <p class="lead">
            Devcolibri - это сервис предоставляющий всем желающим возможность обучаться программированию.
        </p>
        <sec:authorize access="!isAuthenticated()">
            <p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Войти</a></p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <p>Ваш логин: <sec:authentication property="principal.username" /></p>
            <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Выйти</a></p>

        </sec:authorize>
    </div>

    <div class="footer">
        <p>© Devcolibri 2014</p>
    </div>

</div>
<%--<div class="container-fluid">--%>
    <%--<div class="row">--%>
        <%--<c:forEach var="category" items="${allCategories}">--%>
            <%--<div class="col-sm-2">--%>
                <%--<div class="panel panel-primary">--%>
                    <%--<div class="panel-body"><img src="${category.imagePath}" class="img-responsive"--%>
                                                 <%--style="width: 100%"--%>
                                                 <%--alt="Image"></div>--%>
                    <%--<div class="panel-footer">${category.name}</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</c:forEach>--%>
    <%--</div>--%>
<%--</div>--%>
</body>
</html>