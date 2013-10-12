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
        <div class="header">
            <h1>Welcome, ${username}</h1>
            <a class="btn btn-warning" href="<c:url value="/j_spring_security_logout" />">Logout</a>
            <a class="btn btn-success" href="/addPost">Add new Post</a>
        </div>
        <br/>
        <div class="post">
            <h2 class="featurette-heading">First featurette heading.</h2>
            <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
            <p>Comments: <span class="post-author">Written by user</span></p>
            <hr/>
        </div>
        <div class="post">
            <h2 class="featurette-heading">First featurette heading.</h2>
            <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
            <p>Comments: <span class="post-author">Written by user</span></p>
            <hr/>
        </div>
        <div class="post">
            <h2 class="featurette-heading">First featurette heading.</h2>
            <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
            <p>Comments: <span class="post-author">Written by user</span></p>
            <hr/>
        </div>
    </body>
</html>