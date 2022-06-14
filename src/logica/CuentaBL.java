/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Cuenta;
import java.util.*;
import java.sql.Date;
import datos.CuentaDAL;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Jean Carlos Pacheco
 */
public class CuentaBL {
    
    private static ArrayList<Cuenta> lista = new ArrayList<>();

    public static int insertarCuenta(String cuencodigo, String monecodigo, String sucucodigo, String emplcreacuenta, String cliecodigo, float cuensaldo, Date cuenfechacreacion, String cuenestado, int cuencontmov, String cuenclave) {
        if(cuencodigo.trim().length()==8 && monecodigo.trim().length()==2 && sucucodigo.trim().length()==3 &&
                emplcreacuenta.trim().length()==4 && cliecodigo.trim().length()==5 && cuensaldo>0.0f &&
                cuenestado.trim().length()>0 && cuencontmov >0 && cuenclave.trim().length()==6) {
            if(buscarCuenta(cuencodigo) == null) {
                Cuenta cuenta = new Cuenta(cuencodigo, monecodigo, sucucodigo, emplcreacuenta, cliecodigo, cuensaldo, cuenfechacreacion, cuenestado, cuencontmov, cuenclave);
                String mensaje = CuentaDAL.insertarCuenta(cuenta);
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

    public static String buscarCuenta(String cuencodigo) {
        if(cuencodigo.trim().length()==8)
            return CuentaDAL.buscarCuenta(cuencodigo);
        else
            return null;
    }
    public static String buscarClienteCuenta(String cuencodigo) {
        if(cuencodigo.trim().length()==8)
            return CuentaDAL.buscarClienteCuenta(cuencodigo);
        else
            return null;
    }

    public static ArrayList<Cuenta> listarCuenta() {
        return CuentaDAL.listarCuenta();
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
    
    public static ArrayList<Cuenta> obtenerCuenta(String cuencodigo) {     
        if(cuencodigo.trim().length()==8) {
            lista = CuentaDAL.obtenerCuenta(cuencodigo);
            if(lista.size()>0)
                return lista;
            else 
                return null;
        } else
            return null;
    }
    
}
