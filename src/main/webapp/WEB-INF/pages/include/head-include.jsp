<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="req" value="${pageContext.request}"/>
<c:set var="url" value="${req.requestURL}"/>
<meta name="viewport" content="width = device-width, initial-scale = 1"/>



<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="https://fonts.googleapis.com/css?family=Merriweather:300,400,700"/>" rel="stylesheet"
      type="text/css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
      type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
