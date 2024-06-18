package daocontroller;

import conexion.SingletonConexionDB;

import model.Sales;
import utilities.CalculateTotalSale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesDao {

    public static void registerSales(Sales sales) {

        Connection c = SingletonConexionDB.getConnection();
        PreparedStatement ps = null;
        CalculateTotalSale calculateTotal = null;

        String queryRegister = "INSERT INTO sales(sale_date, costumer, product, quantity, price, total_sale, employee) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = c.prepareStatement(queryRegister);
            ps.setString(1, sales.getSaleDate());
            ps.setInt(2, sales.getIdCustomer());
            ps.setInt(3, sales.getIdProduct());
            ps.setInt(4, sales.getQuantity());
            ps.setDouble(5, sales.getPrice());
            ps.setDouble(6, sales.getTotalSale());
            ps.setInt(7, sales.getIdEmployee());
            if (ps.executeUpdate() == 1) {
                System.out.println("Venta registrada correctamente");
            }
        } catch (NullPointerException | SQLException e) {
            System.out.print(e.getMessage());
        }

    }

    public static void showSales() {

        Connection c = SingletonConexionDB.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String querySelect = "SELECT * FROM sales";
        try {

            preparedStatement = c.prepareStatement(querySelect);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Fecha: " + resultSet.getString("sale_date"));
                System.out.println("ID Cliente: " + resultSet.getInt("costumer"));
                System.out.println("ID Producto: " + resultSet.getInt("product"));
                System.out.println("Cantidad: " + resultSet.getInt("quantity"));
                System.out.println("Precio unitario: $" + resultSet.getDouble("price"));
                System.out.println("Total venta: $" + resultSet.getDouble("total_sale"));
                System.out.println("ID Empleado: " + resultSet.getInt("employee"));
            }

        } catch (SQLException e) {
            System.out.println("Error mostrando ventas" + e.getMessage());
        }

    }

    public static void deleteSale(int idSale) {

        Connection c = SingletonConexionDB.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String querySearch = "SELECT * FROM sales WHERE " + idSale;

        try {
            preparedStatement = c.prepareStatement(querySearch);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String queryDel = "DELETE FROM sales WHERE = ?";
                preparedStatement = c.prepareStatement(queryDel);
                preparedStatement.setInt(1, idSale);

                if (preparedStatement.executeUpdate() == 1) {
                    System.out.println("Registro de venta eliminado exitosamente");
                } else {
                    System.out.println("Ooops! Algo salio mal");
                }

            }

        } catch (SQLException ex) {
            System.out.println("Ooops!🫣 Algo salio mal");
            System.out.println("Error eliminando venta: " + ex.getMessage());
        }


    }

}
