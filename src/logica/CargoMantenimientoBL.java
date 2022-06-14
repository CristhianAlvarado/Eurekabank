/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.CargoMantenimiento;
import java.util.*;
import datos.CargoMantenimientoDAL;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Jean Carlos Pacheco
 */
public class CargoMantenimientoBL {
    
    private static ArrayList<CargoMantenimiento> lista = new ArrayList<>();

    public static int insertarCargoMantenimiento(String monecodigo, float cargMontoMaximo, float cargImporte) {
        if(monecodigo.trim().length()==2 && cargMontoMaximo >0 && cargImporte >0) {
            if(buscarCargoMantenimiento(monecodigo) == null) {
                CargoMantenimiento cargoMantenimiento = new CargoMantenimiento(monecodigo, cargMontoMaximo, cargImporte);
                String mensaje = CargoMantenimientoDAL.insertarCargoMantenimiento(cargoMantenimiento);
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

    public static String buscarCargoMantenimiento(String monecodigo) {
        if(monecodigo.trim().length()==2)
            return CargoMantenimientoDAL.buscarCargoMantenimiento(monecodigo);
        else
            return null;
    }

    public static ArrayList<CargoMantenimiento> listarCliente() {
        return CargoMantenimientoDAL.listarCargoMantenimiento();
    }
    
//    public static String actualizarCargoMantenimiento(String monecodigo, float cargMontoMaximo, float cargImporte) {
//        String mensaje;
//        if(monecodigo.trim().length()==2 && cargMontoMaximo >0 && cargImporte >0) {
//            CargoMantenimiento cargoMantenimiento = new CargoMantenimiento(monecodigo, cargMontoMaximo, cargImporte);
//            mensaje = CargoMantenimientoDAL.actualizarCargoMantenimiento(cargoMantenimiento);
//            if(mensaje == null)
//                mensaje = "Registro actualizado";                
//        } else
//            mensaje = "Descripción no válida";
//        return mensaje;
//    }
    
    public static ArrayList<CargoMantenimiento> obtenerCargoMantenimiento(String monecodigo) {     
        if(monecodigo.trim().length()==2) {
            lista = CargoMantenimientoDAL.obtenerCargoMantenimiento(monecodigo);
            if(lista.size()>0)
                return lista;
            else 
                return null;
        } else
            return null;
    }
    
}
