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
public class CargoMantenimiento {
    
    private String monecodigo;
    private float cargMontoMaximo;
    private  float cargImporte;

    public CargoMantenimiento(String monecodigo, float cargMontoMaximo, float cargImporte) {
        this.monecodigo = monecodigo;
        this.cargMontoMaximo = cargMontoMaximo;
        this.cargImporte = cargImporte;
    }
    
    public CargoMantenimiento() {
        monecodigo = "MC";
        cargMontoMaximo = 0.00f;
        cargImporte = 0.00f;
    }

    public String getMonecodigo() {
        return monecodigo;
    }

    public void setMonecodigo(String monecodigo) {
        this.monecodigo = monecodigo;
    }

    public float getCargMontoMaximo() {
        return cargMontoMaximo;
    }

    public void setCargMontoMaximo(float cargMontoMaximo) {
        this.cargMontoMaximo = cargMontoMaximo;
    }

    public float getCargImporte() {
        return cargImporte;
    }

    public void setCargImporte(float cargImporte) {
        this.cargImporte = cargImporte;
    }
    
    
    
}
