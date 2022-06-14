/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.AsignadoDAL;
import entidades.Asignado;
import java.sql.Date;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Lenovo
 */
public class AsignadoBL {
    public static int insertarAsignado(String codigoA, String codigoS, String codigoE, Date fechaAlta, Date fechaBaja) {
        String mensaje = null;

        if (codigoA.trim().length() == 6 && codigoS.trim().length() == 3 && codigoE.trim().length() == 4) {
            if (buscarAsignado(codigoA) == null) {
                Asignado a = new Asignado(codigoA, codigoS, codigoE, fechaAlta, fechaBaja);
                mensaje = AsignadoDAL.insertarAsignado(a);
                if (mensaje == null) {
                    showMessageDialog(null, "Registro Insertado", "Resultado", 1);
                    return 0;
                } else {

                    showMessageDialog(null, "Hubo un error en el registro", "Error", 0);
                    return 1;
                }
            } else {
                showMessageDialog(null, "El codigo ya existe");
                return 2;
            }
        } else {
            showMessageDialog(null, "Los Datos ingresados son incorrectos");
            return 3;
        }

    }

    public static String buscarAsignado(String CodigoA) {
        if (CodigoA.trim().length() == 6) {
            return AsignadoDAL.buscarAsignado(CodigoA);

        } else {
            return null;
        }
    }
}
