/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author Jean Carlos Pacheco
 */
public class Cuenta {
    
    private String cuencodigo;
    private String monecodigo;
    private String sucucodigo;
    private String emplcreacuenta;
    private String cliecodigo;
    private float cuensaldo;
    private Date cuenfechacreacion;
    private String cuenestado;
    private int cuencontmov;
    private String cuenclave;

    public Cuenta(String cuencodigo, String monecodigo, String sucucodigo, String emplcreacuenta, String cliecodigo, float cuensaldo, Date cuenfechacreacion, String cuenestado, int cuencontmov, String cuenclave) {
        this.cuencodigo = cuencodigo;
        this.monecodigo = monecodigo;
        this.sucucodigo = sucucodigo;
        this.emplcreacuenta = emplcreacuenta;
        this.cliecodigo = cliecodigo;
        this.cuensaldo = cuensaldo;
        this.cuenfechacreacion = cuenfechacreacion;
        this.cuenestado = cuenestado;
        this.cuencontmov = cuencontmov;
        this.cuenclave = cuenclave;
    }
    
    public Cuenta() {
        cuencodigo = "CC";
        monecodigo = "MC";
        sucucodigo = "SC";
        emplcreacuenta = "EC";
        cliecodigo = "CC";
        cuensaldo = 0.0f;
        cuenfechacreacion = new Date(120,4,3);
        cuenestado = "CE";
        cuencontmov = 00;
        cuenclave = "Cc";
    }

    public String getCuencodigo() {
        return cuencodigo;
    }

    public void setCuencodigo(String cuencodigo) {
        this.cuencodigo = cuencodigo;
    }

    public String getMonecodigo() {
        return monecodigo;
    }

    public void setMonecodigo(String monecodigo) {
        this.monecodigo = monecodigo;
    }

    public String getSucucodigo() {
        return sucucodigo;
    }

    public void setSucucodigo(String sucucodigo) {
        this.sucucodigo = sucucodigo;
    }

    public String getEmplcreacuenta() {
        return emplcreacuenta;
    }

    public void setEmplcreacuenta(String emplcreacuenta) {
        this.emplcreacuenta = emplcreacuenta;
    }

    public String getCliecodigo() {
        return cliecodigo;
    }

    public void setCliecodigo(String cliecodigo) {
        this.cliecodigo = cliecodigo;
    }

    public float getCuensaldo() {
        return cuensaldo;
    }

    public void setCuensaldo(float cuensaldo) {
        this.cuensaldo = cuensaldo;
    }

    public Date getCuenfechacreacion() {
        return cuenfechacreacion;
    }

    public void setCuenfechacreacion(Date cuenfechacreacion) {
        this.cuenfechacreacion = cuenfechacreacion;
    }

    public String getCuenestado() {
        return cuenestado;
    }

    public void setCuenestado(String cuenestado) {
        this.cuenestado = cuenestado;
    }

    public int getCuencontmov() {
        return cuencontmov;
    }

    public void setCuencontmov(int cuencontmov) {
        this.cuencontmov = cuencontmov;
    }

    public String getCuenclave() {
        return cuenclave;
    }

    public void setCuenclave(String cuenclave) {
        this.cuenclave = cuenclave;
    }
    
    
    
}
