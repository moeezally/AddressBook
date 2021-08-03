<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Address</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<%
    HttpSession Session = request.getSession();
    if (Session.getAttribute("email") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<body style="background-image: url('bg.jpeg');padding: 10px">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8" style="background: rgba(255,255,255,0.8);padding: 10px ">
            <h1>
                Add new Address
            </h1>
            <form role="form" action="AddRecordServlet" method="POST">
                <div class="form-group">

                    <label for="name">
                        Name
                    </label>
                    <input type="text" class="form-control" id="name" name="name"/>
                </div>
                <div class="form-group">

                    <label for="city">
                        City
                    </label>
                    <input type="text" class="form-control" id="city" name="city"/>
                </div>
                <div class="form-group">

                    <label for="country">
                        Country
                    </label>
                    <input type="text" class="form-control" id="country" name="country"/>
                </div>
                <div class="form-group">
                    <label for="gender">
                        Gender
                    </label>
                    <div id="gender">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" id="male" value="male">
                            <label class="form-check-label" for="male">Male</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" id="female" value="female">
                            <label class="form-check-label" for="female">Female</label>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-secondary" name="submit">
                    Add Address
                </button>
            </form>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>

</body>
</html>
