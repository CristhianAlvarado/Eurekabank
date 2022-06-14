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
public class Movimiento {
    
    private String cuencodigo;
    private int movinumero;
    private Date movifecha;
    private String emplcodigo;
    private String tipocodigo;
    private float moviimporte;
    private String cuenreferencia;

    public Movimiento(String cuencodigo, int movinumero, Date movifecha, String emplcodigo, String tipocodigo, float moviimporte, String cuenreferencia) {
        this.cuencodigo = cuencodigo;
        this.movinumero = movinumero;
        this.movifecha = movifecha;
        this.emplcodigo = emplcodigo;
        this.tipocodigo = tipocodigo;
        this.moviimporte = moviimporte;
        this.cuenreferencia = cuenreferencia;
    }
    
    public Movimiento(){
        this.cuencodigo = "CnC";
        this.movinumero = 0000;
        this.movifecha = new Date(120,4,3);
        this.emplcodigo = "EC";
        this.tipocodigo = "TC";
        this.moviimporte = 0.0f;
        this.cuenreferencia = "CR";
    }

    public String getCuencodigo() {
        return cuencodigo;
    }

    public void setCuencodigo(String cuencodigo) {
        this.cuencodigo = cuencodigo;
    }

    public int getMovinumero() {
        return movinumero;
    }

    public void setMovinumero(int movinumero) {
        this.movinumero = movinumero;
    }

    public Date getMovifecha() {
        return movifecha;
    }

    public void setMovifecha(Date movifecha) {
        this.movifecha = movifecha;
    }

    public String getEmplcodigo() {
        return emplcodigo;
    }

    public void setEmplcodigo(String emplcodigo) {
        this.emplcodigo = emplcodigo;
    }

    public String getTipocodigo() {
        return tipocodigo;
    }

    public void setTipocodigo(String tipocodigo) {
        this.tipocodigo = tipocodigo;
    }

    public float getMoviimporte() {
        return moviimporte;
    }

    public void setMoviimporte(float moviimporte) {
        this.moviimporte = moviimporte;
    }

    public String getCuenreferencia() {
        return cuenreferencia;
    }

    public void setCuenreferencia(String cuenreferencia) {
        this.cuenreferencia = cuenreferencia;
    }
    
    
    
}
