<%--
  Created by IntelliJ IDEA.
  User: justynaotapowicz
  Date: 25.08.2018
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SportShop</title>
</head>
<body>
<c:if test="${pageContext.request.remoteUser ne null }">
<h1>Hello, ${pageContext.request.remoteUser.toUpperCase()}!</h1>
</c:if>

<c:if test="${quantityToHigh}">
    <h1 style="color:red;">You ordered to many products. We do not have that much!</h1>
</c:if>

<p><a href="/">Main site</a></p>
<p><a href="/shirts">Shirts</a></p>
<p><a href="/pants">Pants</a></p>
<p><a href="/boots">Boots</a></p>
<p><a href="/basket.jsp">Basket</a></p>
<p><a href="/admin">Admin Panel</a></p>
<p><a href="/logout">Logout</a></p>


<table border="1">
    <tr>
        <th>ID</th>
        <th>Type</th>
        <th>Colour</th>
        <th>Size</th>
        <th>Quantity on store</th>
        <th>Quantity on buy</th>
        <th></th>
    </tr>
    <c:forEach var="list" items="${requestScope.list}">
    <tr>
        <td><c:out value="${list.product_id}"></c:out></td>
        <td><c:out value="${list.type}"></c:out></td>
        <td><c:out value="${list.colour}"></c:out></td>
        <td><c:out value="${list.size}"></c:out></td>
        <td><c:out value="${list.quantity - list.reserved}"></c:out></td>
        <td>
            <form method="post" action="/basket">
                <input type="text" name="quantityToBuy" width="20" value="1">
                <c:choose>
                    <c:when test="${list.quantity-list.reserved>0}">
                        <td>
                        <button type="submit">Add to basket</button>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td>
                        <button type="submit" disabled>Add to basket</button>
                        </td>
                    </c:otherwise>
                </c:choose>
        <input type="hidden" name="productIdToBuy" value="${list.product_id}">
        </form>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
