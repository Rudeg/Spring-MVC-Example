<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
    <head>
        <title>Add new post</title>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
    </head>
    <body>
        <div class="header">
            <h1>Welcome, ${username}</h1>
            <a class="btn btn-warning" href="<c:url value="/j_spring_security_logout" />">Logout</a>
            <a href="/" class="btn btn-default">Back</a>
        </div>
        <br/>
        <c:if test="${not empty error}">
            <div class="errorblock">
                Your login attempt was not successful, try again.<br /> Caused :
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>

        <form action="/addPost" method='POST'>
            <div class="form-group">
                <legend >Add new post</legend>
            </div>
            <div class="form-group">
                <label for="title" class="control-label">Title</label>
                <input type="text" class="form-control add-post" name="title" id="title" placeholder="Title" required="required">
            </div>
            <div class="form-group">
                <label for="text" class="control-label">Text</label>
                <textarea name="text" class="form-control add-post" id="text" placeholder="Text" required="required"></textarea>
            </div>
            <br/>
            <div class="form-group">
                <div class="col-lg-offset-0">
                    <button type="submit" class="btn btn-default">Add post</button>
                </div>
            </div>
        </form>
    </body>
</html>