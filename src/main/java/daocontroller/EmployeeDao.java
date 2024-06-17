package daocontroller;

import conexion.SingletonConexionDB;
import model.Client;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                System.out.println("Empleado/a " + employee.getName() + " guardado correctamente.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void showEmployee() {

        Connection c = SingletonConexionDB.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String querySelect = "SELECT * FROM employee";
        try {
            ps = c.prepareStatement(querySelect);
            rs = ps.executeQuery();
            HidePasswd hidePasswd = null;

            while (rs.next()) {
                System.out.println("LISTA DE EMPLEADOS:");
                System.out.println ("Item: " + rs.getInt(1));
                System.out.println("Nombre " + rs.getString(2));
                System.out.println("Apellido: " + rs.getString(3));
                System.out.println("Celular: " + rs.getString(4));
                System.out.println("Correo electronico: " + rs.getString(5));
                hidePasswd = new HidePasswd(rs.getString("passw"));
                hidePasswd.changeCharacter();
                System.out.println("Contraseña: " + hidePasswd.getHidePassw());
                System.out.println("Tipo: " + rs.getString(7));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void deleteEmployee (int idEmployee) {

        Connection c = SingletonConexionDB.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String queryValidate = "SELECT * FROM `employee` WHERE id_employee = " + idEmployee;
        try {
            ps = c.prepareStatement(queryValidate);
            rs = ps.executeQuery();

            if (rs.next()) {
                String queryDel = "DELETE FROM employee WHERE id_employee = ?";
                ps = c.prepareStatement(queryDel);
                ps.setInt(1, idEmployee);
                ps.executeUpdate();
                System.out.println("Se ha eliminado el item: " + idEmployee + " correctamente");
            } else {
                System.out.println("No hay registros con el item " + idEmployee);
            }

        } catch (SQLException e) {
            System.out.println("Error eliminando un empleado " + e.getMessage());
        }

    }

}
