/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.Asignado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Lenovo
 */
public class AsignadoDAL {
    private static Connection cn = null;
    private static CallableStatement cs = null;
    private static PreparedStatement ps = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    
    public static String insertarAsignado(Asignado a){
        String mensaje=null;
        try {
            cn = Conexion.realizarConexion();
            String sql="call sp_insertar_asignado(?,?,?,?,?)";
            cs = cn.prepareCall(sql);
            cs.setString(1, a.getCodigoA());
            cs.setString(2, a.getCodigoS());
            cs.setString(3, a.getCodigoE());
            cs.setDate(4, a.getFechaAlta());
            cs.setDate(5, a.getFechaBaja());
            cs.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            mensaje = ex.toString();
        } finally {
            try {
                cs.close();
                cn.close();
            }catch(SQLException ex) {
                mensaje = ex.toString();
            }
        }
        return mensaje;
    }
    public static String buscarAsignado(String codigoA){
        try {
            cn=Conexion.realizarConexion();
            String sql="call sp_buscar_asignado(?)";
            cs = cn.prepareCall(sql);
            cs.setString(1, codigoA);
            rs = cs.executeQuery();
            while(rs.next()) {
                return rs.getString("asigcodigo");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null,ex.getMessage(),"Error",0);
        } finally {
            try {
                rs.close();
                cs.close();
                cn.close();
            }catch(SQLException ex) {
                showMessageDialog(null,ex.getMessage(),"Error",0);
            }
        }
        return null;
    }
}
