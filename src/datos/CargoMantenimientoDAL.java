/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.CargoMantenimiento;
import java.util.*;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Jean Carlos Pacheco
 */
public class CargoMantenimientoDAL {
    
    private static Connection cn = null;
    private static PreparedStatement ps = null;
    private static Statement st = null;
    private static ResultSet rs = null;

    public static String insertarCargoMantenimiento(CargoMantenimiento cargoMantenimiento) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "insert into cargomantenimiento values(?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, cargoMantenimiento.getMonecodigo());
            ps.setFloat(2, cargoMantenimiento.getCargMontoMaximo());
            ps.setFloat(3, cargoMantenimiento.getCargImporte());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            mensaje = ex.getMessage();
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                mensaje = ex.getMessage();
            }
        }
        return mensaje;
    }

    public static String buscarCargoMantenimiento(String monecodigo) {
        try {
            cn = Conexion.realizarConexion();
            String sql = "select monecodigo from cargomantenimiento where monecodigo = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, monecodigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("monecodigo");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                rs.close();
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return null;
    }

    public static ArrayList<CargoMantenimiento> listarCargoMantenimiento() {
        ArrayList<CargoMantenimiento> cargoMantenimientos = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from cargomantenimiento";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                cargoMantenimientos.add(new CargoMantenimiento(rs.getString(1), rs.getFloat(2), rs.getFloat(3)));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                rs.close();
                st.close();
                cn.close();
            } catch (SQLException ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return cargoMantenimientos;
    }

//    public static String actualizarCliente(Cliente cliente) {
//        String mensaje = null;
//        try {
//            cn = Conexion.realizarConexion();
//            String sql = "update cliente set cliepaterno = ?, cliematerno=?, clienombre=?, "
//                    + "cliedni=?, clieciudad=?, cliedireccion=?, clietelefono=?, clieemail=? where cliecodigo = ?";
//            ps = cn.prepareStatement(sql);
//            ps.setString(1, cliente.getCliepaterno());
//            ps.setString(2, cliente.getCliematerno());
//            ps.setString(3, cliente.getClienombre());
//            ps.setString(4, cliente.getCliedni());
//            ps.setString(5, cliente.getClieciudad());
//            ps.setString(6, cliente.getCliedireccion());
//            ps.setString(7, cliente.getClietelefono());
//            ps.setString(8, cliente.getClieemail());
//            ps.setString(9, cliente.getCliecodigo());
//            ps.executeUpdate();
//        } catch (ClassNotFoundException | SQLException ex) {
//            mensaje = ex.getMessage();
//        } finally {
//            try {
//                ps.close();
//                cn.close();
//            } catch (SQLException ex) {
//                mensaje = ex.getMessage();
//            }
//        }
//        return mensaje;
//    }

    public static ArrayList<CargoMantenimiento> obtenerCargoMantenimiento(String monecodigo) {
        ArrayList<CargoMantenimiento> cargoMantenimiento = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            String sql = "select * from cargomantenimiento where monecodigo = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, monecodigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                cargoMantenimiento.add(new CargoMantenimiento(rs.getString(1), rs.getFloat(2), rs.getFloat(3)));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                rs.close();
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return cargoMantenimiento;
    }
    
}
