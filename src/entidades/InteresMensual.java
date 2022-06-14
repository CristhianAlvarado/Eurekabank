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
public class InteresMensual {
    
    private String monecodigo;
    private float inteimporte;

    public InteresMensual(String monecodigo, float inteimporte) {
        this.monecodigo = monecodigo;
        this.inteimporte = inteimporte;
    }

    public InteresMensual() {
    monecodigo = "MC";
    inteimporte = 0.0f;
    }
    
    public String getMonecodigo() {
        return monecodigo;
    }

    public void setMonecodigo(String monecodigo) {
        this.monecodigo = monecodigo;
    }

    public float getInteimporte() {
        return inteimporte;
    }

    public void setInteimporte(float inteimporte) {
        this.inteimporte = inteimporte;
    }
    
    
    
}
