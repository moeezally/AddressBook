package com.example.addressbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String gender = request.getParameter("gender");
        int id = Integer.parseInt(request.getParameter("id"));

        boolean updated = UpdateRecord(id, name, city, country, gender);
        if (updated) {
            response.sendRedirect("DashboardServlet?updated=true");
        } else {
            response.sendRedirect("dashboard.jsp?updated=false");
        }


    }

    public boolean UpdateRecord(int id, String name, String city, String country, String gender) {
        boolean updated = false;
        Connection connection = new Connection();
        try {
            // 3. Create a statement
            Statement st = connection.makeStatement();

            // 4. Create a query
            String query = "UPDATE `adresses`.`address_table` SET `country` = '" + country + "',`city` = '" + city + "',`name` = '" + name + "',`gender` = '" + gender + "' WHERE `id` = '" + id + "';";
            int result = st.executeUpdate(query);
            // 6. Close all connections
            if (result != 0) {
                updated = true;
            }
            st.close();
            connection.con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

}
