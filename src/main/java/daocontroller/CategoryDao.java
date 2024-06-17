package daocontroller;

import conexion.SingletonConexionDB;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDao {

    public static void createCategoryDao(Category category) {

        //Conexion conexion = new Conexion();
        Connection conn = SingletonConexionDB.getConnection();

        //try (Connection connect = conexion.getConnectDB()) {

        PreparedStatement ps = null;
        try {

            String query = "INSERT INTO category(category_name) VALUES(?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, category.getCategoryName()); //
            ps.executeUpdate();
            System.out.println("Categoria " + category.getCategoryName() + " almacenado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error guardando categoria: " + e.getMessage());
        }

//        } catch (SQLException ex){
//            System.out.println(ex.toString());
//        }

    }

    public static void selectCategoryDao() {

        // Conexion conexion = new Conexion();
        Connection conn = SingletonConexionDB.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //try (Connection connect = conexion.getConnectDB()) {
        try {

            String query = "SELECT * FROM category";

            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.print("Item: " + rs.getInt(1)+ "\n");
                System.out.print("Nombre categoria: " + rs.getString("category_name") +"\n");
            }

        } catch (SQLException ex){
            System.out.println(ex.toString());
        }

    }

    public static void deleteCategory(int idCategory) {

        Connection connect = SingletonConexionDB.getConnection();

        PreparedStatement ps = null;
        try {

            String query = "DELETE FROM category WHERE category.id_category = ?";
            ps = connect.prepareStatement(query);
            ps.setInt(1, idCategory);
            ps.executeUpdate();
            System.out.println("Se ha eliminado la categoria correctamente");

        } catch (SQLException er) {
            System.out.println("Error eliminando categoria: " + er.toString());
        }

    }

}
