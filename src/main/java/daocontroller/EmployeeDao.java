package daocontroller;

import conexion.SingletonConexionDB;
import model.Client;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {

    public static void createEmployee(Employee employee) {

        Connection c = SingletonConexionDB.getConnection();
        PreparedStatement ps = null;

        String queryInsert = "INSERT INTO employee(id_employee, name, last_name, phone, mail, passw, position) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            ps = c.prepareStatement(queryInsert);
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getLast_name());
            ps.setString(4, employee.getPhone());
            ps.setString(5, employee.getMail());
            ps.setString(6, employee.getPasswd());
            ps.setString(7, employee.getPosition());

            if (ps.executeUpdate() == 1) {
                System.out.println("Empleado " + employee.getName() + " guardado correctamente.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
