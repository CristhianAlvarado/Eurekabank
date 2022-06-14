/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Cliente;
import java.util.*;
import datos.ClienteDAL;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Jean Carlos Pacheco
 */
public class ClienteBL {
    
    private static ArrayList<Cliente> lista = new ArrayList<>();

    public static int insertarCliente(String cliecodigo, String cliepaterno, String cliematerno, String clienombre,
            String cliedni, String clieciudad, String cliedireccion, String clietelefono, String clieemail) {
        if(cliecodigo.trim().length()==5 && cliepaterno.trim().length()>0 && cliematerno.trim().length()>0
                && clienombre.trim().length()>0 && cliedni.trim().length()>0 && clieciudad.trim().length()>0
                && cliedireccion.trim().length()>0 && clietelefono.trim().length()>0 && clieemail.trim().length()>0) {
            if(buscarCliente(cliecodigo) == null) {
                Cliente cliente = new Cliente(cliecodigo, cliepaterno, cliematerno, clienombre, cliedni, clieciudad,
                cliedireccion, clietelefono, clieemail);
                String mensaje = ClienteDAL.insertarCliente(cliente);
                if(mensaje == null) {
                    showMessageDialog(null, "Registro insertado", "Resultado", 1);
                    return 0;
                } else {
                    showMessageDialog(null, mensaje, "Error", 0);
                    return 1;
                }
            } else {
                showMessageDialog(null, "Código ya existe", "Error", 0);
                return 2;
            }
        } else {
            showMessageDialog(null, "Datos no válidos", "Error", 0);
            return 3;
        }
    }

    public static String buscarCliente(String cliecodigo) {
        if(cliecodigo.trim().length()==5)
            return ClienteDAL.buscarCliente(cliecodigo);
        else
            return null;
    }

    public static ArrayList<Cliente> listarCliente() {
        return ClienteDAL.listarCliente();
    }
    
    public static ArrayList<Cliente> listarClienteSucursal(String sucunombre) {
        return ClienteDAL.listarClienteSucursal(sucunombre);
    }
    
    public static String actualizarCliente(String cliecodigo, String cliepaterno, String cliematerno, String clienombre,
            String cliedni, String clieciudad, String cliedireccion, String clietelefono, String clieemail) {
        String mensaje;
        if(cliecodigo.trim().length()==5 && cliepaterno.trim().length()>0 && cliematerno.trim().length()>0 && clienombre.trim().length()>0 &&
                cliedni.trim().length()>0 && clieciudad.trim().length()>0 && cliedireccion.trim().length()>0 &&
                clietelefono.trim().length()>0 && clieemail.trim().length()>0) {
            Cliente cliente = new Cliente(cliecodigo, cliepaterno, cliematerno, clienombre, cliedni, clieciudad,
                cliedireccion, clietelefono, clieemail);
            mensaje = ClienteDAL.actualizarCliente(cliente);
            if(mensaje == null)
                mensaje = "Registro actualizado";                
        } else
            mensaje = "Descripción no válida";
        return mensaje;
    }
    
    public static ArrayList<Cliente> obtenerCliente(String cliecodigo) {     
        if(cliecodigo.trim().length()==5) {
            lista = ClienteDAL.obtenerCliente(cliecodigo);
            if(lista.size()>0)
                return lista;
            else 
                return null;
        } else
            return null;
    }
    
}
