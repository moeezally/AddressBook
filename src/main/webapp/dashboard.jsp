<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.addressbook.address" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>DashBoard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<%
    HttpSession Session = request.getSession();
    if (Session.getAttribute("email") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    ArrayList<address> AddressList = (ArrayList<address>) Session.getAttribute("Addresses");

%>
<body style="background-image: url('bg.jpeg');padding: 10px">

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8" style="background: rgba(255,255,255,0.8);padding: 10px ">
            <div style="display: flex;justify-content: space-between;">
                <div>
                    <h1>DASHBOARD</h1>
                </div>
                <div style="display: inline">
                    <a role="button" class="btn btn-secondary" href="new.jsp" style=" height: fit-content">Add new
                        Address </a>
                    <a role="button" class="btn btn-secondary" href="logout" style=" height: fit-content">Logout</a>
                </div>


            </div>
            <%
                if (request.getParameter("login") != null && request.getParameter("login").equals("true")) {

                    out.println("<hr><div> <h4> Logged In Successfully </h4></div><hr>");

                } else if (request.getParameter("added") != null && request.getParameter("added").equals("true")) {

                    out.println("<hr><div> <h4> Record Added Successfully </h4></div><hr>");

                } else if (request.getParameter("added") != null && request.getParameter("added").equals("false")) {

                    out.println("<hr><div> <h4> Record Could Not Be Added </h4></div><hr>");

                } else if (request.getParameter("updated") != null && request.getParameter("updated").equals("true")) {

                    out.println("<hr><div> <h4> Record Updated Successfully </h4></div><hr>");

                } else if (request.getParameter("updated") != null && request.getParameter("updated").equals("false")) {

                    out.println("<hr><div> <h4> Record Could Not Be Updated </h4></div><hr>");

                } else if (request.getParameter("deleted") != null && request.getParameter("deleted").equals("true")) {

                    out.println("<hr><div> <h4> Record Deleted Successfully </h4></div><hr>");

                } else if (request.getParameter("deleted") != null && request.getParameter("deleted").equals("false")) {

                    out.println("<hr><div> <h4> Record Could Not Be Deleted </h4></div><hr>");

                }
            %>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th> ID</th>
                    <th> Name</th>
                    <th> Gender</th>
                    <th> City</th>
                    <th> Country</th>
                    <th> Actions</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (address a : AddressList) {
                        out.println("<tr> <td>" + a.id + "</td> <td>" + a.name + "</td><td>" + a.gender + " </td> <td>" + a.city + " </td> <td>" + a.country + "</td><td><a href='Update.jsp?id=" + AddressList.indexOf(a) + "'>Update</a> | <a href='DeleteServlet?id=" + a.id + "'>Delete</a> </td></tr>");
                    }
                %>


                </tbody>
            </table>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>

</body>
</html>

