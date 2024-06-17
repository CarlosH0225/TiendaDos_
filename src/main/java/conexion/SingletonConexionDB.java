package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConexionDB {

    private static Connection conn = null;


    private SingletonConexionDB() {

        String url = "jdbc:mysql://localhost:3306/tiendados";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "";

        try {

            conn = DriverManager.getConnection(url, user, password);

        } catch (SQLException err) {
            System.out.println(err.toString());
        }

    }

    public static Connection getConnection() {

        if (conn == null) {
            new SingletonConexionDB();
        }

        return conn;

    }
    /*
    public static closeConexion() {

        if (conn != null) {
            conn.close();
        }

    }
    */

}
