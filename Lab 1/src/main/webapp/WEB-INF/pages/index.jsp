<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
    <head>
        <meta charset="utf-8">
        <title>Test page with Spring-MVC</title>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
    </head>
    <body>
        <h1>Spring MVC Example</h1>
        <form:form method="post" action="registration.html">
            <fieldset>
                <div class="form-item">
                    <form:label path="firstname">First Name: </form:label>
                    <form:input path="firstname" class="form-control" />
                </div>
                <div class="form-item">
                    <form:label path="lastname">Last Name: </form:label>
                    <form:input path="lastname" class="form-control" />
                </div>
                <div class="form-item">
                    <form:label path="username">Username: </form:label>
                    <form:input path="username" class="form-control" />
                </div>
                <div class="form-item">
                    <form:label path="password">Password: </form:label>
                    <form:password path="password" class="form-control" />
                </div>
                <div class="form-item">
                    <form:label path="repeatPassword">Repeat Password: </form:label>
                    <form:password path="repeatPassword" class="form-control" />
                </div>
                <div class="form-item">
                    <input class="btn btn-default" type="submit" value="Registration"/>
                 </div>
            </fieldset>

        </form:form>

    </body>
</html>
