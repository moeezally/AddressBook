package com.example.addressbook;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "LoginServlet", value = "/loginCheck")
public class loginCheck extends HttpServlet {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setEmail(request.getParameter("email"));
        setPassword(request.getParameter("password"));

        System.out.println(getEmail());
        System.out.println(getPassword());

        boolean userExist = checkUser();

        if (userExist) {
            HttpSession Session = request.getSession();
            Session.setAttribute("email", getEmail());
            response.sendRedirect("DashboardServlet?login=true");
        } else {
            response.sendRedirect("index.jsp?true=0");
        }
    }

    public boolean checkUser() {
        boolean value = false;

        try {

            // 2. Create a connection class object
            Connection connection = new Connection();
            try {
                // 3. Create a statement
                Statement st = connection.makeStatement();

                // 4. Create a query
                String query = "select * from adresses.users where email='" + getEmail() + "' and password='" + getPassword() + "'";
                System.out.println(query);

                // 5. Create a ResultSet
                ResultSet rs = st.executeQuery(query);

                if (rs.next()) {
                    value = true;
                    System.out.println(rs.getRow());
                }

                // 6. Close all connections
                rs.close();
                st.close();
                connection.con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (Exception e) {

            e.printStackTrace();
        }
        return value;
    }


}