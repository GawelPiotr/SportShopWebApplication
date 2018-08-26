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
    <title>Admin</title>
</head>
<body>

<p><a href="/">Main site</a></p>
<p><a href="/shirts">Shirts</a></p>
<p><a href="/pants">Pants</a></p>
<p><a href="/boots">Boots</a></p>

<h2>Add new product:</h2>
<table border="1">
    <tr>
        <th>Type</th>
        <th>Colour</th>
        <th>Size</th>
        <th>Quantity on store</th>
        <th>Quantity on buy</th>
    </tr>
    <tr>
        <form method="post" action="/addProduct">
            <td>
                <select name="type">
                    <option value="boot">boot</option>
                    <option value="pants">pants</option>
                    <option value="shirt">shirt</option>
                    <%--zrobić ściąganie wartości z enuma--%>
                </select>
            </td>
            <td><input type="text" name="colour"></td>
            <td><input type="text" name="size"></td>
            <td><input type="text" name="quantity"></td>
            <td><input type="text" name="reserved" value="0"></td>
        </form>
    </tr>
</table><br><br>

<h2>List of products:</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Type</th>
        <th>Colour</th>
        <th>Size</th>
        <th>Quantity on store</th>
        <th>Quantity reserved</th>
    </tr>
    <c:forEach var="list" items="${requestScope.list}">
        <tr>
            <td><c:out value="${list.product_id}"></c:out></td>
            <td><c:out value="${list.type}"></c:out></td>
            <td><c:out value="${list.colour}"></c:out></td>
            <td><c:out value="${list.size}"></c:out></td>
            <td><c:out value="${list.quantity}"></c:out></td>
            <td><c:out value="${list.reserved}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

