<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container" id="body">
    <div class="row">
        <c:forEach var="category" items="${allCategories}">
            <div class="col-sm-3">
                <div class="panel panel-primary">
                    <div class="panel-body" style="text-align: center">
                        <a href="/categories/${category.id}">
                            <img src="${category.imagePath}" class="img-responsive" alt>
                        </a>
                    </div>
                    <div class="panel-footer">
                        <a href="/categories/${category.id}">${category.name}</a>
                    </div>
                        <%--<div class="panel-footer">${category.name}</div>--%>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>