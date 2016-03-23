<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container">
    <div class="container-fluid">
        <div class="row">
            <c:forEach var="category" items="${allCategories}">
                <div class="col-sm-2">
                    <div class="panel panel-primary">
                        <div class="panel-body"><img src="${category.imagePath}" class="img-responsive"
                                                     style="width: 100%"
                                                     alt></div>
                        <a href="/categories/${category.id}" style="margin-left:40px;">${category.name}</a>
                        <%--<div class="panel-footer">${category.name}</div>--%>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>