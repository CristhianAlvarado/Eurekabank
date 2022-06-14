/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;
import entidades.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;
import patrones.*;
/**
 *
 * @author Lenovo
 */
public class EmpleadoDAL implements DAOEmpleado{
    private static Connection cn = null;
    private static CallableStatement cs = null;
    private static PreparedStatement ps = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    
    public String insertarEmpleado(Empleado em){
        String mensaje=null;
        try {
            cn = Conexion.realizarConexion();
            String sql="call sp_insertar_empleado(?,?,?,?,?,?,?,?)";
            cs = cn.prepareCall(sql);
            cs.setString(1, em.getCodigoE());
            cs.setString(2, em.getPaterno());
            cs.setString(3, em.getMaterno());
            cs.setString(4, em.getNombre());
            cs.setString(5, em.getCiudad());
            cs.setString(6, em.getDireccion());
            cs.setString(7, em.getUsuario());
            cs.setString(8, em.getClave());
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
    
    public String buscarEmpleado(String codigoE){
        try {
            cn=Conexion.realizarConexion();
            String sql="call sp_buscar_empleado(?)";
            cs = cn.prepareCall(sql);
            cs.setString(1, codigoE);
            rs = cs.executeQuery();
            while(rs.next()) {
                return rs.getString("emplcodigo");
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
    
    public String actualizarEmpleado(Empleado em) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "call sp_actualizar_empleado(?,?,?,?,?,?,?,?)";
            cs = cn.prepareCall(sql);
            cs.setString(1, em.getCodigoE());
            cs.setString(2, em.getPaterno());
            cs.setString(3, em.getMaterno());
            cs.setString(4, em.getNombre());
            cs.setString(5, em.getCiudad());
            cs.setString(6, em.getDireccion());
            cs.setString(7, em.getUsuario());
            cs.setString(8, em.getClave());          
            cs.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            mensaje = ex.getMessage();
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException ex) {
                mensaje = ex.getMessage();
            }
        }
        return mensaje;        
    }
    public ArrayList<Empleado> obtenerEmpleado(String codigoE) {
        ArrayList<Empleado> e = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            String sql = "call sp_obtener_empleado(?)";
            cs = cn.prepareCall(sql);
            cs.setString(1, codigoE);
            rs = cs.executeQuery();
            while (rs.next()) {
                e.add(new Empleado(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.toString(), "Error", 0);
        } finally {
            try {
                rs.close();
                cs.close();
                cn.close();
            } catch (SQLException ex) {
                showMessageDialog(null, ex.toString(), "Error", 0);
            }
        }
        return e;
    }
    public ArrayList<Empleado> listarEmpleado() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            String sql = "{call sp_listar_empleados()}";
            cs = cn.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                empleados.add(new Empleado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                rs.close();
                cs.close();
                cn.close();
            } catch (SQLException ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return empleados;
    }
}
