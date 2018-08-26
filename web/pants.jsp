<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/">Main site</a></p>
<p><a href="/shirts">Shirts</a></p>
<p><a href="/pants">Pants</a></p>
<p><a href="/boots">Boots</a></p>
<p><a href="/basket.jsp">Basket</a></p>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Type</th>
        <th>Colour</th>
        <th>Size</th>
        <th>Quantity</th>
    </tr>
    <c:forEach var="pants" items="${requestScope.pantsList}">
        <tr>
            <td><c:out value="${pants.product_id}"></c:out></td>
            <td><c:out value="${pants.type}"></c:out></td>
            <td><c:out value="${pants.colour}"></c:out></td>
            <td><c:out value="${pants.size}"></c:out></td>
            <td><c:out value="${pants.quantity - pants.reserved}"></c:out></td>
            <td>
                <form method="post" action="/basket">
                    <input type="text" name="quantityToBuy" width="20" value="1">
                    <c:choose>
                    <c:when test="${pants.quantity-pants.reserved>0}">
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
            <input type="hidden" name="productIdToBuy" value="${pants.product_id}">
            </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
