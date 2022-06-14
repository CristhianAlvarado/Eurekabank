/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jean Carlos Pacheco
 */
public class CostoMovimiento {
    
    private String monecodigo;
    private float costimporte;

    public CostoMovimiento(String monecodigo, float costimporte) {
        this.monecodigo = monecodigo;
        this.costimporte = costimporte;
    }
    
    public CostoMovimiento() {
        monecodigo = "MC";
        costimporte = 0.00f;
    }

    public String getMonecodigo() {
        return monecodigo;
    }

    public void setMonecodigo(String monecodigo) {
        this.monecodigo = monecodigo;
    }

    public float getCostimporte() {
        return costimporte;
    }

    public void setCostimporte(float costimporte) {
        this.costimporte = costimporte;
    }
    
    
    
}
