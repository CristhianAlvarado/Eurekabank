/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.MovimientoDAL;
import entidades.Movimiento;
import java.sql.Date;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Lenovo
 */
public class MovimientoBL {
    private static ArrayList<Movimiento> lista = new ArrayList<>();
    public static int insertarMovimiento(String codigoM, int movinumero, Date movifecha, String codigoE, String codigoTM, float importe, String referencia) {
        if (codigoM.trim().length() == 8 && movinumero > 0 && codigoE.trim().length() == 4 && codigoTM.trim().length() == 3 && importe > 0.0f) {
            Movimiento m = new Movimiento(codigoM, movinumero, movifecha, codigoE, codigoTM, importe, referencia);
            String mensaje = MovimientoDAL.insertarMovimiento(m);
            if (mensaje == null) {
                return 0;
            } else {
                showMessageDialog(null, mensaje, "Error", 0);
                return 1;
            }

        } else {
            showMessageDialog(null, "Datos no válidos", "Error", 0);
            return 3;
        }
    }
    
    public static ArrayList<Movimiento> listarMovimiento(Date fecha) {
        lista = MovimientoDAL.listarMovimiento(fecha);
        if(lista.size()>0){
            return lista;
        } else{
            return null;
        }      
    }
    
    public static ArrayList<Movimiento> listarMovimiento1(Date fecha) {
        lista = MovimientoDAL.listarMovimiento1(fecha);
        if(lista.size()>0){
            return lista;
        } else{
            return null;
        }  
    }
}
