<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        h1 {
            color: white;
        }
    </style>
</head>
<body style="background-image: url('bg.jpeg')">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <div class="row">

                <div class="col-md-12">
                    <h1>Login to Access Address Book</h1>

                    <form role="form" action="loginCheck" method="POST"
                          style="background: rgba(255,255,255,0.8);padding: 10px ">
                        <%
                            if (request.getParameter("true") != null) {
                                if (request.getParameter("true").equals("0")) {
                                    out.println("<hr><h4>Email or Password Incorrect</h4>");

                                }
                            } else if (request.getParameter("logout") != null) {
                                if (request.getParameter("logout").equals("true")) {
                                    out.println("<hr><h4>Logged Out Successfully</h4>");

                                }
                            }
                        %>
                        <hr>
                        <div class="form-group">

                            <label for="email">
                                Email address
                            </label>
                            <input type="email" class="form-control" id="email" name="email"
                                   placeholder="Enter your e-mail"/>
                        </div>
                        <hr>
                        <div class="form-group">

                            <label for="password">
                                Password
                            </label>
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="Enter password"/>
                        </div>
                        <hr>

                        <button type="submit" class="btn btn-primary btn-block" name="submit">
                            Login
                        </button>
                        <hr>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>

</body>
</html>

