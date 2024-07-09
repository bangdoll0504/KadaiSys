package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/th_register")
public class th_RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tabyouinid = request.getParameter("tabyouinid");
        String tabyouinmei = request.getParameter("tabyouinmei");
        String tabyouinaddress = request.getParameter("tabyouinaddress");
        String tabyouintel = request.getParameter("tabyouintel");
        int tabyouinshihonkin = Integer.parseInt(request.getParameter("tabyouinshihonkin"));
        int kyukyu = Integer.parseInt(request.getParameter("kyukyu"));

        String jdbcUrl = "jdbc:mysql://localhost:3306/s3_syskadai";
        String jdbcUser = "root";
        String jdbcPassword = "password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            String sql = "INSERT INTO tabyouin (tabyouinid, tabyouinmei, tabyouinaddress, tabyouintel, tabyouinshihonkin, kyukyu) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, tabyouinid);
            statement.setString(2, tabyouinmei);
            statement.setString(3, tabyouinaddress);
            statement.setString(4, tabyouintel);
            statement.setInt(5, tabyouinshihonkin);
            statement.setInt(6, kyukyu);
            statement.executeUpdate();

            statement.close();
            connection.close();

            response.sendRedirect("th_register.jsp?success=true");
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException("Database connection problem", e);
        }
    }
}
