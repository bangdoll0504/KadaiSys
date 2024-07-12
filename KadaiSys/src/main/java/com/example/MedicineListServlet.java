package com.example;

import java.io.IOException;
import java.sql.Connection;
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

@WebServlet("/medicine_list")
public class MedicineListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Medicine> medicines = new ArrayList<>();

        try (Connection connection = DatabaseConnection.initializeDatabase()) {
            String sql = "SELECT * FROM medicine";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String medicineId = resultSet.getString("medicineid");
                String medicineName = resultSet.getString("medicinename");
                String unit = resultSet.getString("unit");
                medicines.add(new Medicine(medicineId, medicineName, unit));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("medicines", medicines);
        request.getRequestDispatcher("medicine_list.jsp").forward(request, response);
    }
}
