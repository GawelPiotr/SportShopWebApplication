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
    <c:forEach var="pants" items="${requestScope.pantsList}">
        <tr>
            <td><c:out value="${pants.product_id}"></c:out></td>
            <td><c:out value="${pants.type}"></c:out></td>
            <td><c:out value="${pants.colour}"></c:out></td>
            <td><c:out value="${pants.size}"></c:out></td>
            <td><c:out value="${pants.quantity}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
