/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.Cliente;
import java.util.*;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Jean Carlos Pacheco
 */
public class ClienteDAL {

    private static Connection cn = null;
    private static CallableStatement cs = null;
    private static PreparedStatement ps = null;
    private static Statement st = null;
    private static ResultSet rs = null;

    public static String insertarCliente(Cliente cliente) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "{call sp_insertar_cliente(?,?,?,?,?,?,?,?,?)}";
            cs = cn.prepareCall(sql);
            cs.setString(1, cliente.getCliecodigo());
            cs.setString(2, cliente.getCliepaterno());
            cs.setString(3, cliente.getCliematerno());
            cs.setString(4, cliente.getClienombre());
            cs.setString(5, cliente.getCliedni());
            cs.setString(6, cliente.getClieciudad());
            cs.setString(7, cliente.getCliedireccion());
            cs.setString(8, cliente.getClietelefono());
            cs.setString(9, cliente.getClieemail());
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

    public static String buscarCliente(String cliecodigo) {
        try {
            cn = Conexion.realizarConexion();
            String sql = "{call sp_buscar_cliente(?)}";
            cs = cn.prepareCall(sql);
            cs.setString(1, cliecodigo);
            rs = cs.executeQuery();
            while (rs.next()) {
                return rs.getString("cliecodigo");
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
        return null;
    }

    public static ArrayList<Cliente> listarCliente() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            String sql = "{call sp_listar_clientes()}";
            cs = cn.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
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
        return clientes;
    }
    
    public static ArrayList<Cliente> listarClienteSucursal(String sucunombre) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            String sql = "{call sp_listarClientesSucursal(?)}";
            cs = cn.prepareCall(sql);
            cs.setString(1, sucunombre);
            rs = cs.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
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
        return clientes;
    }
    

    public static String actualizarCliente(Cliente cliente) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "{call sp_actualizar_cliente(?,?,?,?,?,?,?,?,?)}";
            cs = cn.prepareCall(sql);
            cs.setString(1, cliente.getCliecodigo());
            cs.setString(2, cliente.getCliepaterno());
            cs.setString(3, cliente.getCliematerno());
            cs.setString(4, cliente.getClienombre());
            cs.setString(5, cliente.getCliedni());
            cs.setString(6, cliente.getClieciudad());
            cs.setString(7, cliente.getCliedireccion());
            cs.setString(8, cliente.getClietelefono());
            cs.setString(9, cliente.getClieemail());
            
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

    public static ArrayList<Cliente> obtenerCliente(String cliecodigo) {
        ArrayList<Cliente> cliente = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            String sql = "{call sp_obtener_cliente(?)}";
            cs = cn.prepareCall(sql);
            cs.setString(1, cliecodigo);
            rs = cs.executeQuery();
            while (rs.next()) {
                cliente.add(new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
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
        return cliente;
    }

}
