<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE>
<html>
    <head>
        <meta charset="utf-8">
        <title>${post.title}</title>
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css"/>
        <link rel="stylesheet" href="../css/style.css" type="text/css"/>
    </head>

    <body>
        <div class="header">
            <h1>Welcome, ${username}</h1>
            <a class="btn btn-warning" href="<c:url value="/j_spring_security_logout" />">Logout</a>
            <a class="btn btn-success" href="/addPost">Add new Post</a>
            <a class="btn btn-default" href="/main">Back</a>
        </div>
        <br/>
        <div class="post">
            <h2 class="featurette-heading">${post.title}</h2>
            <p class="lead">${post.text}</p>
            <br/>
        </div>
        <p>Comments:</p>
        <c:forEach items="${post.comments}" var="item">
            <br/>
            <strong>${item.title}</strong>
            <p>${item.text}<span class="post-author">Written by ${item.user.username}</span></p>
            <hr/>
        </c:forEach>
        <strong>Add new comment:</strong>
        <br/>
        <br/>
        <form action="/addComment" method="POST">
            <input type="hidden" value="${post.id}" name="postId">
            <div class="form-group">
                <input type="text" class="form-control add-comment" name="title" id="title" placeholder="Title" required="required">
            </div>
            <div class="form-group">
                <textarea name="text" class="form-control add-comment" id="text" placeholder="Text" required="required"></textarea>
            </div>
            <br/>
            <div class="form-group">
                <div class="col-lg-offset-0">
                    <button type="submit" class="btn btn-default">Add comment</button>
                </div>
            </div>
        </form>
    </body>
</html>