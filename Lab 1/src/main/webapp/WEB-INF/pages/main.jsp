<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <title>Main page with Spring-MVC</title>
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body>
    <h1>Success Registration!</h1>
    <p>First Name - ${user.firstname}</p>
    <p>Last Name - ${user.lastname}</p>
    <p>Username - ${user.username}</p>
    <p>Password - ${user.password}</p>
    <a href="/" class="btn btn-default">Back</a>
</body>