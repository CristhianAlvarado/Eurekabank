/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Lenovo
 */
public class Empleado implements Comparable<Empleado>{
    private String codigoE;
    private String paterno;
    private String materno;
    private String nombre;
    private String ciudad;
    private String direccion;
    private String usuario;
    private String clave;

    public Empleado(){
        this.codigoE="NC";
        this.paterno = "NAP";
        this.materno = "NAM";
        this.nombre = "NN";
        this.ciudad = "NC";
        this.direccion = "NDR";
        this.usuario  = "ND";
        this.clave = "NCL";
    }
    
    public Empleado(String codigoE, String paterno, String materno, String nombre, String ciudad, String direccion, String usuario, String clave) {
        this.codigoE = codigoE;
        this.paterno = paterno;
        this.materno = materno;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getCodigoE() {
        return codigoE;
    }

    public void setCodigoE(String codigoE) {
        this.codigoE = codigoE;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    @Override
    public int compareTo(Empleado e) {
        return this.getPaterno().compareTo(e.getPaterno());
    }
}
