/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.CostoMovimiento;
import java.util.*;
import datos.CostoMovimientoDAL;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Jean Carlos Pacheco
 */
public class CostoMovimientoBL {
    
    private static ArrayList<CostoMovimiento> lista = new ArrayList<>();

    public static int insertarCostoMovimiento(String monecodigo, float costimporte) {
        if(monecodigo.trim().length()==2 && costimporte >0) {
            if(buscarCostoMovimiento(monecodigo) == null) {
                CostoMovimiento costoMovimiento = new CostoMovimiento(monecodigo, costimporte);
                String mensaje = CostoMovimientoDAL.insertarCostoMovimiento(costoMovimiento);
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

    public static String buscarCostoMovimiento(String monecodigo) {
        if(monecodigo.trim().length()==2)
            return CostoMovimientoDAL.buscarCostoMovimiento(monecodigo);
        else
            return null;
    }

    public static ArrayList<CostoMovimiento> listarCliente() {
        return CostoMovimientoDAL.listarCostoMovimiento();
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
    
    public static ArrayList<CostoMovimiento> obtenerCotoMovimiento(String monecodigo) {     
        if(monecodigo.trim().length()==2) {
            lista = CostoMovimientoDAL.obtenerCostoMovimiento(monecodigo);
            if(lista.size()>0)
                return lista;
            else 
                return null;
        } else
            return null;
    }
    
}
