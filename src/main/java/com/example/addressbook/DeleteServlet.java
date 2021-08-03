package com.example.addressbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession Session = request.getSession();
        if (Session.getAttribute("email") == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        int id = Integer.parseInt(request.getParameter("id"));

        boolean deleted = DeleteRecord(id);
        if (deleted) {
            response.sendRedirect("DashboardServlet?deleted=true");
        } else {
            response.sendRedirect("dashboard.jsp?deleted=false");
        }

    }

    public boolean DeleteRecord(int id) {
        boolean deleted = false;
        Connection connection = new Connection();
        try {
            // 3. Create a statement
            Statement st = connection.makeStatement();

            // 4. Create a query
            String query = "DELETE FROM `adresses`.`address_table` WHERE id=" + id + ";";
            int result = st.executeUpdate(query);
            // 6. Close all connections
            if (result != 0) {
                deleted = true;
            }
            st.close();
            connection.con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }


}
