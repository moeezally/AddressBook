package com.example.addressbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "logout", value = "/logout")
public class logout extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession Session = request.getSession();
        Session.removeAttribute("email");
        Session.removeAttribute("Addresses");
        Session.invalidate();
        response.sendRedirect("index.jsp?logout=true");
        return;
    }
}
