/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.Movimiento;
import java.sql.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Jean Carlos Pacheco
 */
public class MovimientoDAL {
    
    private static Connection cn = null;
    private static CallableStatement cs = null;
    private static PreparedStatement ps = null;
    private static Statement st = null;
    private static ResultSet rs = null;

    public static String insertarMovimiento(Movimiento movimiento) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "{call sp_insertar_movimiento(?,?,?,?,?,?,?)}";
            cs = cn.prepareCall(sql);
            cs.setString(1, movimiento.getCuencodigo());
            cs.setInt(2, movimiento.getMovinumero());
            cs.setDate(3, movimiento.getMovifecha());
            cs.setString(4, movimiento.getEmplcodigo());
            cs.setString(5, movimiento.getTipocodigo());
            cs.setFloat(6, movimiento.getMoviimporte());
            cs.setString(7, movimiento.getCuenreferencia());
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

//    public static String buscarMovimiento(String cuencodigo) {
//        try {
//            cn = Conexion.realizarConexion();
//            String sql = "{call sp_buscar_cuenta(?)}";
//            cs = cn.prepareCall(sql);
//            cs.setString(1, cuencodigo);
//            rs = cs.executeQuery();
//            while (rs.next()) {
//                return rs.getString("cuencodigo");
//            }
//        } catch (ClassNotFoundException | SQLException ex) {
//            showMessageDialog(null, ex.getMessage(), "Error", 0);
//        } finally {
//            try {
//                rs.close();
//                cs.close();
//                cn.close();
//            } catch (SQLException ex) {
//                showMessageDialog(null, ex.getMessage(), "Error", 0);
//            }
//        }
//        return null;
//    }

//    public static ArrayList<Cuenta> listarCuenta() {
//        ArrayList<Cuenta> cuentas = new ArrayList<>();
//        try {
//            cn = Conexion.realizarConexion();
//            String sql = "{call sp_listar_cuenta()}";
//            cs = cn.prepareCall(sql);
//            rs = cs.executeQuery();
//            while (rs.next()) {
//                cuentas.add(new Cuenta(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
//                        rs.getString(5), rs.getFloat(6), rs.getDate(7), rs.getString(8), rs.getInt(9), rs.getString(10)));
//            }
//        } catch (ClassNotFoundException | SQLException ex) {
//            showMessageDialog(null, ex.getMessage(), "Error", 0);
//        } finally {
//            try {
//                rs.close();
//                cs.close();
//                cn.close();
//            } catch (SQLException ex) {
//                showMessageDialog(null, ex.getMessage(), "Error", 0);
//            }
//        }
//        return cuentas;
//    }

//    public static String actualizarCuenta(Cuenta cuenta) {
//        String mensaje = null;
//        try {
//            cn = Conexion.realizarConexion();
//            String sql = "{call sp_actualizar_cuenta(?,?,?,?,?,?,?,?,?,?)}";
//            cs = cn.prepareCall(sql);
//            cs.setString(1, cliente.getCliepaterno());
//            cs.setString(2, cliente.getCliematerno());
//            cs.setString(3, cliente.getClienombre());
//            cs.setString(4, cliente.getCliedni());
//            cs.setString(5, cliente.getClieciudad());
//            cs.setString(6, cliente.getCliedireccion());
//            cs.setString(7, cliente.getClietelefono());
//            cs.setString(8, cliente.getClieemail());
//            cs.setString(9, cliente.getCliecodigo());
//            cs.executeUpdate();
//        } catch (ClassNotFoundException | SQLException ex) {
//            mensaje = ex.getMessage();
//        } finally {
//            try {
//                cs.close();
//                cn.close();
//            } catch (SQLException ex) {
//                mensaje = ex.getMessage();
//            }
//        }
//        return mensaje;
//    }

    public static ArrayList<Movimiento> obtenerMovimiento(String cuencodigo) {
        ArrayList<Movimiento> movimiento = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            String sql = "{call sp_obtener_movimiento(?)}";
            cs = cn.prepareCall(sql);
            cs.setString(1, cuencodigo);
            rs = cs.executeQuery();
            while (rs.next()) {
                movimiento.add(new Movimiento(rs.getString(1), rs.getInt(2), rs.getDate(3), rs.getString(4),
                        rs.getString(5), rs.getFloat(6), rs.getString(7)));
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
        return movimiento;
    }
    
    public static ArrayList<Movimiento> listarMovimiento(Date fecha) {
        ArrayList<Movimiento> movimientos = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            String sql = "{call sp_comprueba_interes(?)}";
            cs = cn.prepareCall(sql);
            cs.setDate(1, fecha);
            rs = cs.executeQuery();
            while (rs.next()) {
                movimientos.add(new Movimiento(rs.getString(1), rs.getInt(2), rs.getDate(3), rs.getString(4),
                        rs.getString(5), rs.getFloat(6), rs.getString(7)));
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
        return movimientos;
    }
    
    public static ArrayList<Movimiento> listarMovimiento1(Date fecha) {
        ArrayList<Movimiento> movimientos = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            String sql = "{call sp_comprueba_mantenimiento(?)}";
            cs = cn.prepareCall(sql);
            cs.setDate(1, fecha);
            rs = cs.executeQuery();
            while (rs.next()) {
                movimientos.add(new Movimiento(rs.getString(1), rs.getInt(2), rs.getDate(3), rs.getString(4),
                        rs.getString(5), rs.getFloat(6), rs.getString(7)));
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
        return movimientos;
    }
    
}
