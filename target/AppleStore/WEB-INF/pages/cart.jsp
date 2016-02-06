<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
  <jsp:include page="/WEB-INF/pages/include/head-include.jsp"/>
  <title>Cart</title>
</head>
<body>
<div class="container">
  <h2>Your cart</h2>
  <form action="/cart/placeOrder" method="post">
    ${cartMessage}
    <table class="table">
      <tr>
        <th> Item </th>
        <th> Quantity </th>
        <th> Price </th>
      </tr>
      <c:forEach var="item" items="${cart.contents}">
        <tr>
          <td><c:out value="${item.key.name}"/> </td>
          <td><c:out value="${item.value}"/> </td>
          <td>$<c:out value="${item.key.price}"/> </td>
        </tr>
      </c:forEach>

      <tr></tr>
      <tr>
        <td>Total</td>
        <td></td>
        <td>$${cart.totalCast}</td>
      </tr>
    </table>
    <input type="submit" value="Place Order"/>

  </form>
</div>
</body>
</html>