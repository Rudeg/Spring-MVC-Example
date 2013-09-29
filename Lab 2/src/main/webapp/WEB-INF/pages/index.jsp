<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
    <head>
        <title>Main Page</title>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
    </head>
    <body>
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <div class="col-lg-10">
                    <legend >Please Sign In</legend>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail1" class="col-lg-2 control-label">Email</label>
                <div class="col-lg-10">
                    <input type="email" class="form-control" id="inputEmail1" placeholder="Email">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword1" class="col-lg-2 control-label">Password</label>
                <div class="col-lg-10">
                    <input type="password" class="form-control" id="inputPassword1" placeholder="Password">
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