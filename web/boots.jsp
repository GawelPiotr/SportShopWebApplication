<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Type</th>
        <th>Colour</th>
        <th>Size</th>
        <th>Quantity</th>
    </tr>
    <c:forEach var="boots" items="${requestScope.bootsList}">
        <tr>
            <td><c:out value="${boots.product_id}"></c:out></td>
            <td><c:out value="${boots.type}"></c:out></td>
            <td><c:out value="${boots.colour}"></c:out></td>
            <td><c:out value="${boots.size}"></c:out></td>
            <td><c:out value="${boots.quantity}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
