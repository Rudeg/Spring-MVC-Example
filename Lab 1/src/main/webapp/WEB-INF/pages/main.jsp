<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <p>First Name - <b>${user.firstname}</b></p>
    <p>Last Name - <b>${user.lastname}</b></p>
    <p>Username - <b${user.username}</b></p>
    <p>Password - <b>${user.password}</b></p>
    <p>Sex - <b>${user.sex}</b></p>
    <p>Country - <b>${user.country}</b></p>
    <p>Programming Languages - <c:forEach items="${user.progLang}" var="lang">
            <b><c:out value="${lang}" />, </b>
        </c:forEach> </p>
    <p>Receive newsletters status - <b>${user.receiveNewsLetter}</b></p>
    <a href="/" class="btn btn-default">Back</a>
</body>