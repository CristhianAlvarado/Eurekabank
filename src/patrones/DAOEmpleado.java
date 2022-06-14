/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones;

import entidades.Empleado;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public interface DAOEmpleado {

    public String insertarEmpleado(Empleado em) throws Exception;

    public String buscarEmpleado(String codigoE) throws Exception;

    public String actualizarEmpleado(Empleado em) throws Exception;

    public ArrayList<Empleado> obtenerEmpleado(String codigoE) throws Exception;

    public ArrayList<Empleado> listarEmpleado() throws Exception;
}
