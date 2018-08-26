
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SportShopWebApplication</title>
    <div class="jumbotron text-center">
        <img class="grafiki "src="grafiki/logo.jpg"/>
        <h1>Your Online Sport Shop </h1>
    </div>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }
        {height: 450px}

        {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }

        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        @media screen and (max-width: 767px) {
        {
            height: auto;
            padding: 15px;
        }
        {height:auto;}
        }
    </style>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">Best Sport Shop</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Home</a></li>
                    <li><a href="/shirts">Shirts</a></li>
                    <li><a href="/pants">Pants</a></li>
                    <li><a href="/boots">Boots</a> </li>
                    <li><a href="Contact.jsp">Contact</a> </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="basket.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Basket </a> </li>
                    <li><a href="Sign_in.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </div>
        </div>
    </nav></head>
<body>

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
<footer class="container-fluid text-center">
    <table>
        <td><li>Sport Shop Web Application create by: </li></td>
        <td><li>Tomasz Prasny</li></td>
        <td><li>Diana Janusczyk</li></td>
        <td><li>Daniel Czarnocki</li></td>
        <td><li>Piotr Gaweł</li></td>
    </table>
</footer>
</body>
</html>

