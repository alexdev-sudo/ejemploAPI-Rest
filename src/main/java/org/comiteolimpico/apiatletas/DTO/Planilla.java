package org.comiteolimpico.apiatletas.DTO;

public class Planilla {
    private String nombreatleta;
    private int totalentreno;
    private double pagoTotal;
    private double bonoextranjero;
    private double bonoMarca;
    // setters and Getters
    public String getNombreatleta() {
        return nombreatleta;
    }
    public void setNombreatleta(String nombreatleta) {
        this.nombreatleta = nombreatleta;
    }
    public int getTotalentreno() {
        return totalentreno;
    }
    public void setTotalentreno(int totalentreno) {
        this.totalentreno = totalentreno;
    }
    public double getPagoTotal() {
        return pagoTotal;
    }
    public void setPagoTotal(double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }
    public double getBonoextranjero() {
        return bonoextranjero;
    }
    public void setBonoextranjero(double bonoextranjero) {
        this.bonoextranjero = bonoextranjero;
    }
    public double getBonoMarca() {
        return bonoMarca;
    }
    public void setBonoMarca(double bonoMarca) {
        this.bonoMarca = bonoMarca;
    }
}
