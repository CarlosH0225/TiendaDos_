package daocontroller;

import conexion.SingletonConexionDB;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDao {

    public static void createClient(Client client) {

        Connection c = SingletonConexionDB.getConnection();

        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = c.prepareStatement("INSERT INTO `costumer` (`id_costumer`, `name`, `last_name`, `phone`, `mail`, `passw`, `type`) VALUES (?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, client.getId());
            preparedStatement.setString(2, client.getName());
            preparedStatement.setString(3, client.getLast_name());
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.setString(5, client.getMail());
            preparedStatement.setString(6, client.getPasswd());
            preparedStatement.setString(7, client.getType());

            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Cliente registrado correctamente");
            }

        } catch (SQLException er) {
            System.out.println(er.toString());
        }

    }

    public static void showClient() {

        HidePasswd hidePasswd = null;
        Connection c = SingletonConexionDB.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM costumer";

        try {
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Datos del cliente: ");
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Nombre: " + rs.getString(2));
                System.out.println("Apellidos: " + rs.getString(3));
                System.out.print("Celular: " + rs.getString(4) + " \n");
                System.out.print("Correo Electronico: " + rs.getString("mail") + " \n");
                hidePasswd = new HidePasswd(rs.getString("passw"));
                hidePasswd.changeCharacter();
                System.out.println("Contraseña: " + hidePasswd.getHidePassw());
                System.out.print("Type: " + rs.getString("type") + " \n");
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    public static void deleteClient(int id){

        Connection c = SingletonConexionDB.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String queryValidate = "SELECT * FROM `costumer` WHERE id_costumer = " + id;
            ps = c.prepareStatement(queryValidate);
            rs = ps.executeQuery();

            if (rs.next()) {
                String queryDelete = "DELETE FROM costumer WHERE id_costumer = ?";
                ps = c.prepareStatement(queryDelete);
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("Se ha eliminado el item: " + id + " correctamente");
            } else {
                System.out.println("No hay registros con el item " + id);
            }

        } catch (SQLException e) {
            System.out.println("Error eliminando un cliente: " + e.getMessage());
        }


    }

}
