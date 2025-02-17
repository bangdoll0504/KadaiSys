package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tabyouinlist")
public class TabyouinListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/s3_syskadai";
        String jdbcUser = "root";
        String jdbcPassword = "password";

        List<Tabyouin> tabyouinList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            String sql = "SELECT * FROM tabyouin";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String tabyouinid = resultSet.getString("tabyouinid");
                String tabyouinmei = resultSet.getString("tabyouinmei");
                String tabyouinaddress = resultSet.getString("tabyouinaddress");
                String tabyouintel = resultSet.getString("tabyouintel");
                int tabyouinshihonkin = resultSet.getInt("tabyouinshihonkin");
                int kyukyu = resultSet.getInt("kyukyu");

                Tabyouin tabyouin = new Tabyouin(tabyouinid, tabyouinmei, tabyouinaddress, tabyouintel, tabyouinshihonkin, kyukyu);
                tabyouinList.add(tabyouin);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException("Database connection problem", e);
        }

        request.setAttribute("tabyouinList", tabyouinList);
        request.getRequestDispatcher("/tabyouin_list.jsp").forward(request, response);
    }
}
