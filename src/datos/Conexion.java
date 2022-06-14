/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;

/**
 *
 * @author Jean Carlos Pacheco
 */
public class Conexion {
    
    public static Connection realizarConexion() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver");
        //String url = "jdbc:mysql://localhost:3306/eurekabank";
        String url = "jdbc:mysql://localhost:3306/eurekabank?useSSL=false";
        String user = "root";
        String password = "alvaradofel16+-";
        return DriverManager.getConnection(url, user, password);
    }
    
}
