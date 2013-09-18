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
                    <form:input path="firstname" class="form-control"/>
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
                    <form:label path="sex">Please select sex</form:label>
                    <p>
                        <form:radiobutton path="sex" value="M" class="form-inline"/> Male
                        <form:radiobutton path="sex" value="W" class="form-inline"/> Female
                    </p>
                </div>
                <div class="form-item">
                    <form:label path="country">Please select country:</form:label>
                    <p>
                        <form:select path="country" class="form-control">
                            <form:option  value="none" label="-"/> Female
                            <form:options items="${countryMap}" />
                        </form:select>
                    </p>
                </div>
                <div class="form-item">
                    <form:label path="progLang">Please select programming languages:</form:label>
                    <p>
                        <form:checkboxes path="progLang" items="${programmingLanguageList}" class="form-inline"/>
                    </p>
                </div>
                <div class="form-item">
                    <form:label path="receiveNewsLetter">Receive Newsletter?</form:label>
                    <form:checkbox path="receiveNewsLetter"/>
                </div>
                <div class="form-item">
                    <input class="btn btn-default" type="submit" value="Registration"/>
                 </div>
            </fieldset>

        </form:form>

    </body>
</html>
