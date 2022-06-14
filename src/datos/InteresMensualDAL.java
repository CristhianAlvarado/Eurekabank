/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.InteresMensual;
import java.util.*;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Jean Carlos Pacheco
 */
public class InteresMensualDAL {
    private static Connection cn = null;
    private static PreparedStatement ps = null;
    private static Statement st = null;
    private static ResultSet rs = null;

    public static String insertarInteresMensual(InteresMensual interesMensual) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "insert into interesmensual values(?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, interesMensual.getMonecodigo());
            ps.setFloat(2, interesMensual.getInteimporte());
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

    public static String buscarInteresMensual(String monecodigo) {
        try {
            cn = Conexion.realizarConexion();
            String sql = "select monecodigo from interesmensual where monecodigo = ?";
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

    public static ArrayList<InteresMensual> listarInteresMensual() {
        ArrayList<InteresMensual> interesesMensuales = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from interesmensual";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                interesesMensuales.add(new InteresMensual(rs.getString(1), rs.getFloat(2)));
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
        return interesesMensuales;
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

    public static ArrayList<InteresMensual> obtenerInteresMensual(String monecodigo) {
        ArrayList<InteresMensual> interesMensual = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            String sql = "select * from interesmensual where monecodigo = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, monecodigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                interesMensual.add(new InteresMensual(rs.getString(1), rs.getFloat(2)));
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
        return interesMensual;
    }
}
