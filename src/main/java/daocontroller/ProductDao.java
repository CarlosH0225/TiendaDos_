package daocontroller;

import conexion.SingletonConexionDB;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDao {

    public static void createProduct(Product product) {

        try {

            Connection c = SingletonConexionDB.getConnection();

            PreparedStatement st = null;
            st = c.prepareStatement("INSERT INTO product(product_name, price, quantity, category) VALUES(?, ?, ?, ?)");
            st.setString(1, product.getProductName());
            st.setDouble(2, product.getPrice());
            st.setInt(3, product.getQuantity());
            st.setInt(4, product.getIdCategory());
            if (st.executeUpdate() == 1) {
                System.out.println("Producto almacenado correctamente");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void showProduct() {

        try {

            Connection c = SingletonConexionDB.getConnection();

            PreparedStatement st = null;
            ResultSet rs = null;

            String query = "SELECT * FROM product";
            st = c.prepareStatement(query);
            rs = st.executeQuery();

            while (rs.next()) {
                System.out.println("Item: " + rs.getInt(1));
                System.out.println("Nombre del producto: " + rs.getString(2));
                System.out.println("Precio: " +rs.getDouble(3));
                System.out.println("Categoria que pertenece: " + rs.getInt(4));
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    public static void deleteProduct(int id) {

        Connection c = SingletonConexionDB.getConnection();

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String queryValidate = "SELECT * FROM product WHERE id_product = " + id;
            st = c.prepareStatement(queryValidate);
            //st.setInt(1, id);
            System.out.println(queryValidate);
            rs = st.executeQuery();

            if (rs.next()) {
                //System.out.println("Si hay registro " + queryValidate);

                String query = "DELETE FROM product WHERE id_product = ?";
                st = c.prepareStatement(query);
                st.setInt(1, id);
                st.executeUpdate();

            } else {
                System.out.println("No hay registros con el item " + id);
            }



        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }
}
