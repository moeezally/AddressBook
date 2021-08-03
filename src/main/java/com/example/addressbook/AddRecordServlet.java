package com.example.addressbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "AddRecordServlet", value = "/AddRecordServlet")
public class AddRecordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String gender = request.getParameter("gender");
        System.out.println(name + city + country + gender);

        boolean added = InsertRecord(name, city, country, gender);
        if (added) {
            response.sendRedirect("DashboardServlet?added=true");
        } else {
            response.sendRedirect("dashboard.jsp?added=false");
        }

    }

    public boolean InsertRecord(String name, String city, String country, String gender) {
        boolean added = false;
        Connection connection = new Connection();
        try {
            // 3. Create a statement
            Statement st = connection.makeStatement();

            // 4. Create a query
            String query = "INSERT INTO `adresses`.`address_table`(`country`,`city`,`name`,`gender`)VALUES('" + country + "','" + city + "','" + name + "','" + gender + "');";
            int result = st.executeUpdate(query);
            // 6. Close all connections
            if (result != 0) {
                added = true;
            }
            st.close();
            connection.con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return added;
    }
}
