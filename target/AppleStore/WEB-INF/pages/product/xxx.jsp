<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <jsp:include page="/WEB-INF/pages/include/head-include.jsp"/>
</head>
</head>
<body>
<div class="container">

    <h2>Create Product</h2>

    <div class="container">
        <div class="jumbotron">
            <form:form name="input" method="post"
                       modelAttribute="product" action="/products">

                <fieldset class="form-group">
                    <label for="name" class="col-sm-2 control-label">Name:</label>

                    <div class="col-sm-10">
                        <input class="form-control has-warning" type="text" id="name" placeholder="Name"/>
                    </div>
                </fieldset>

                <fieldset class="form-group">
                    <label for="description" class="col-sm-2 control-label">Description:</label>

                    <div class="col-sm-10">
                        <textarea class="form-control has-warning" id="description"
                                  style="resize: vertical" rows="3" placeholder="Description"></textarea>
                    </div>
                </fieldset>

                <fieldset class="form-group">
                    <label for="imagePath" class="col-sm-2 control-label">Image URL:</label>

                    <div class="col-sm-10">
                        <input class="form-control has-warning" type="text" id="imagePath" placeholder="Image URL"/>
                    </div>
                </fieldset>

                <fieldset class="form-group">
                    <label class="col-sm-2 control-label">Price:</label>

                    <div class="col-sm-10">
                        <form:input class="form-control has-warning" type="text" placeholder="Price" path="name"/>
                    </div>
                </fieldset>

                <div>
                    <label class="col-sm-2 control-label">Category:</label>
                    <form:select path="category.id" items="${categories}" itemLabel="name" itemValue="id">
                    </form:select>
                    <form:errors path="category"/>
                </div>
                <div>
                    <label class="col-sm-2 control-label">Featured:</label>
                    <form:checkbox path="featured" class="form-control"/>
                    <form:errors path="featured"/>
                </div>

                <%--<label class="col-sm-2 control-label"></label>--%>

                <div>
                    <input class="form-control submit" type="submit" value="Submit">
                </div>


            </form:form>
        </div>
    </div>
</div>
</body>
</html>