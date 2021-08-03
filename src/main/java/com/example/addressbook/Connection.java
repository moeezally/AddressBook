package com.example.addressbook;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    String url = "jdbc:mysql://localhost:3306/adresses";
    String dbUsername = "root";
    String dbPassword = "moeez99";
    java.sql.Connection con;
    Statement st;

    public Statement makeStatement() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 2. Create a connection
        con = DriverManager.getConnection(url, dbUsername, dbPassword);
        st = con.createStatement();
        return st;
    }


}
