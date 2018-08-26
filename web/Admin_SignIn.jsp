
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 450px}

        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }

        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height:auto;}
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
                <a class="navbar-brand" href="index.jsp">Best Sport Shop</a>
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
    </nav>
</head>
<body>


<form method="Post" action="j_security_check">
    <table>
        <tr>
            <td colspan="2">Admin Login</td>
        </tr>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="j_username"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="j_password"/> </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Go"/></td>

        </tr>
    </table>
</form>
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

