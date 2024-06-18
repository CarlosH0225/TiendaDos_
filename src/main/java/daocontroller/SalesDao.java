package daocontroller;

import conexion.SingletonConexionDB;

import model.Sales;
import utilities.CalculateTotalSale;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
