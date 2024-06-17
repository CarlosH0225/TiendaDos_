package conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionTest {

    public static void main(String[] arg) {

        Conexion conexion = new Conexion();

        try (Connection connect = conexion.getConnectDB()) {

        } catch (SQLException ex){
          System.out.println(ex.toString());
        }

    }
}
