/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.*;
import java.util.*;
import datos.*;
import static javax.swing.JOptionPane.showMessageDialog;
import patrones.DAOEmpleado;
/**
 *
 * @author Lenovo
 */
public class EmpleadoBL {
    public static EmpleadoDAL empl = new EmpleadoDAL()  ;
    private static ArrayList<Empleado> listaE = new ArrayList<>();

    public static int insertarEmpleado(String codigoE, String paterno, String materno, String nombre, String ciudad, String direccion, String usuario, String clave) {
        if (codigoE.trim().length() == 4 && paterno.trim().length() > 0 && paterno.trim().length() <= 25 && materno.trim().length() > 0 && materno.trim().length() <= 25 && nombre.trim().length() > 0 && nombre.trim().length() <= 30
                && ciudad.trim().length() > 0 && ciudad.trim().length() <= 30 && direccion.trim().length() > 0 && direccion.trim().length() <= 50 && usuario.trim().length() > 0
                && usuario.trim().length() <= 15 && clave.trim().length() > 0 && clave.trim().length() <= 15) {
            if (buscarEmpleado(codigoE) == null) {
                Empleado empleado = new Empleado(codigoE, paterno, materno, nombre, ciudad, direccion, usuario, clave);
                String mensaje = empl.insertarEmpleado(empleado);
                if (mensaje == null) {
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

    public static String buscarEmpleado(String codigoE) {
        if (codigoE.trim().length() == 4) {
            return empl.buscarEmpleado(codigoE);
        } else {
            return null;
        }
    }

    public static String actualizarEmpleado(String codigoE, String paterno, String materno, String nombre, String ciudad, String direccion, String usuario, String clave) {
        String mensaje;
        if (codigoE.trim().length() == 4 && paterno.trim().length() > 0 && paterno.trim().length() <= 25 && materno.trim().length() > 0 && materno.trim().length() <= 25 && nombre.trim().length() > 0 && nombre.trim().length() <= 30
                && ciudad.trim().length() > 0 && ciudad.trim().length() <= 30 && direccion.trim().length() > 0 && direccion.trim().length() <= 50 && usuario.trim().length() > 0
                && usuario.trim().length() <= 15 && clave.trim().length() > 0 && clave.trim().length() <= 15) {
            Empleado empleado = new Empleado(codigoE, paterno, materno, nombre, ciudad, direccion, usuario, clave);
            mensaje = empl.actualizarEmpleado(empleado);
            if (mensaje == null) {
                mensaje = "Registro actualizado";
            }
        } else {
            mensaje = "Descripción no válida";
        }
        return mensaje;
    }
    
    public static ArrayList<Empleado> obtenerEmpleado(String codigoE) {     
        if(codigoE.trim().length()==4) {
            listaE = empl.obtenerEmpleado(codigoE);
            if(listaE.size()>0)
                return listaE;
            else 
                return null;
        } else
            return null;
    }
    public static ArrayList<Empleado> listarEmpleado() {
        return empl.listarEmpleado();
    }
}
