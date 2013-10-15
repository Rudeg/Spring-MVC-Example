<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE>
<html>
    <head>
        <meta charset="utf-8">
        <title>Main page with Spring-MVC</title>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
    </head>

    <body>
        <div class="header">
            <h1>Welcome, ${username}</h1>
            <a class="btn btn-warning" href="<c:url value="/j_spring_security_logout" />">Logout</a>
            <a class="btn btn-success" href="/addPost">Add new Post</a>
        </div>
        <br/>
        <c:forEach items="${posts}" var="item">
            <div class="post">
                <h2 class="featurette-heading"><a href="/post/${item.id}">${item.title}</a></h2>
                <p class="lead">${item.text}</p>
                <p>Comments:${fn:length(item.comments)}<span class="post-author">Written by ${item.user.username}</span></p>
                <hr/>
            </div>
        </c:forEach>
    </body>
</html>