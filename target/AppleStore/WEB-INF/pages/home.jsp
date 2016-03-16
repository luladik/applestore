<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<meta http-equiv="content-type" content="text/html;charset=UTF-8"/>--%>
    <%--<title><spring:message code="welcome"/></title>--%>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <c:forEach var="category" items="${allCategories}">
            <div class="col-sm-3">
                <div class="panel panel-default">
                    <%--<div class="panel-heading">${category.name}</div>--%>
                    <div class="panel-body"><img src="${category.imagePath}" class="img-responsive"
                                                 style="width: 100%"
                                                 alt="Image"></div>
                    <div class="panel-footer">${category.name}</div>
                </div>
                <div>

                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>