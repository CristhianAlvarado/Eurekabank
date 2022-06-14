/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones;

import entidades.Empleado;
import java.util.ArrayList;
import java.util.Iterator;
import logica.EmpleadoBL;

/**
 *
 * @author Lenovo
 */
public class ListaEmpleados {

    private ArrayList<Empleado> lista = new ArrayList();

    public ListaEmpleados() throws Exception {
        lista = EmpleadoBL.listarEmpleado();
    }

    public ArrayList<Empleado> getLista() {
        return lista;
    }

    public ListaEmpleadosIterator iterator() {
        return new ListaEmpleadosIterator(lista);

    }

    private class ListaEmpleadosIterator implements Iterator<Empleado> {

        private ArrayList<Empleado> lista;
        private int posicion = 0;

        public ListaEmpleadosIterator(ArrayList<Empleado> listaE) {
            this.lista = listaE;
        }

        @Override
        public boolean hasNext() {
            if (posicion < lista.size() && lista.get(posicion) != null) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Empleado next() {
            return lista.get(++posicion);
        }

    }
}
