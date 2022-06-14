/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class Asignado {
    private String codigoA;
    private String codigoS;
    private String codigoE;
    private Date fechaAlta ;
    private Date fechaBaja;
    
    public Asignado(){
        codigoA = "NCA";
        codigoS = "NCS";
        codigoE = "NCE";
        fechaAlta = new Date(120,4,3);
        fechaBaja = new Date(120,4,3);
    }
    public Asignado(String codigoA, String codigoS, String codigoE, Date fechaAlta, Date fechaBaja) {
        this.codigoA = codigoA;
        this.codigoS = codigoS;
        this.codigoE = codigoE;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }

    public String getCodigoA() {
        return codigoA;
    }

    public void setCodigoA(String codigoA) {
        this.codigoA = codigoA;
    }

    public String getCodigoS() {
        return codigoS;
    }

    public void setCodigoS(String codigoS) {
        this.codigoS = codigoS;
    }

    public String getCodigoE() {
        return codigoE;
    }

    public void setCodigoE(String codigoE) {
        this.codigoE = codigoE;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
}
