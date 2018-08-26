<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PrasnaL
  Date: 26.08.2018
  Time: 00:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basket</title>
</head>
<body>
<p><a href="/">Main site</a></p>
<p><a href="/shirts">Shirts</a></p>
<p><a href="/pants">Pants</a></p>
<p><a href="/boots">Boots</a></p>
<p><a href="/basket.jsp">Basket</a></p>
<table border="1">
    <tr>
        <th>Product Id</th>
        <th>Ordered quantity</th>
    </tr>

    <c:forEach var="basketEntry" items="${sessionScope.basket}">
        <tr>
            <td><c:out value="${basketEntry.productId}"></c:out> </td>
            <td><c:out value="${basketEntry.reservedQuantity}"></c:out> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
