<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
</head>
<body>
<div class="container">
    <h2>Create Category</h2>
</div>
<div class="jumbotron">
    <div class="container">
        <form:form name="input" method="post"
                   modelAttribute="category" action="/categories">
            <fieldset class="form-group">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Name:</label>

                    <div class="col-sm-10">
                        <form:input class="form-control" type="text" path="name"/>
                        <form:errors path="name"/>
                    </div>
                </div>
            </fieldset>

            <fieldset class="form-group">
                <div>
                    <label class="col-sm-2">Description:</label>

                    <div class="col-sm-10">
                        <form:textarea rows="5" class="form-control" path="description"
                                       cssStyle="resize: vertical;"/>
                        <form:errors path="description"/>
                    </div>
                </div>
            </fieldset>

            <fieldset class="form-group">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Image URL:</label>

                    <div class="col-sm-10">
                        <form:input class="form-control" type="text" path="imagePath"/>
                        <form:errors path="imagePath"/>
                    </div>
                </div>
            </fieldset>

            <fieldset class="form-group">
                <label class="col-sm-2"></label>

                <div class="col-sm-3">
                    <input class="btn btn-primary" type="submit" value="Submit">
                </div>
            </fieldset>
        </form:form>
    </div>
</div>
</body>
</html>