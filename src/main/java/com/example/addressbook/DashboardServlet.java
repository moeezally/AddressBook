package com.example.addressbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "DashboardServlet", value = "/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    HttpSession Session;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 2. Create a connection class object
        Connection connection = new Connection();
        try {
            // 3. Create a statement
            Statement st = connection.makeStatement();

            // 4. Create a query
            String query = "select * from adresses.address_table";

            // 5. Create a ResultSet
            ResultSet rs = st.executeQuery(query);

            Session = req.getSession();
            ArrayList<address> AddressList = new ArrayList<address>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String country = rs.getString("country");
                String city = rs.getString("city");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                address address = new address(id, name, country, city, gender);
                AddressList.add(address);
            }
            Session.setAttribute("Addresses", AddressList);

            // 6. Close all connections
            rs.close();
            st.close();
            connection.con.close();
            if (req.getParameter("login") != null) {
                if (req.getParameter("login").equals("true")) {
                    resp.sendRedirect("dashboard.jsp?login=true");
                }
            } else if (req.getParameter("added") != null) {
                if (req.getParameter("added").equals("true")) {
                    resp.sendRedirect("dashboard.jsp?added=true");
                }
            } else if (req.getParameter("updated") != null) {
                if (req.getParameter("updated").equals("true")) {
                    resp.sendRedirect("dashboard.jsp?updated=true");
                }
            } else if (req.getParameter("deleted") != null) {
                if (req.getParameter("deleted").equals("true")) {
                    resp.sendRedirect("dashboard.jsp?deleted=true");
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}

