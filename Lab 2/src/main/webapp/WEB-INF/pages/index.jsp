<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
    <head>
        <title>Main Page</title>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
    </head>
    <body>
        <c:if test="${not empty error}">
            <div class="errorblock">
                Your login attempt was not successful, try again.<br /> Caused :
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>

        <form class="form-horizontal" action="<c:url value='j_spring_security_check' />" method='POST'>
            <div class="form-group">
                <div class="col-lg-10">
                    <legend >Please Sign In</legend>
                </div>
            </div>
            <div class="form-group">
                <label for="username" class="col-lg-2 control-label">Username</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" name='j_username' id="username" placeholder="Username">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-lg-2 control-label">Password</label>
                <div class="col-lg-10">
                    <input type="password" name='j_password' class="form-control" id="password" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> Remember me
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <button type="submit" class="btn btn-default">Sign in</button>
                    <a href="/registration" class="btn btn-default">Registration</a>
                </div>
            </div>
        </form>
    </body>
</html>