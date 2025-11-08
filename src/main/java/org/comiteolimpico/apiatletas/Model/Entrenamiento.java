package org.comiteolimpico.apiatletas.Model;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
    @Table(name = "entrenamientos")
public class Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private String tipo;
    private double valor;
    private String unidad;
    private String ubicacion;
    private String pais;

    @ManyToOne
    @JoinColumn(name = "atleta_id")
    private Atleta atleta;
    public Entrenamiento() {}
    public Entrenamiento(LocalDate fecha, String tipo, double valor, String unidad
            , String ubicacion, String pais) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.valor = valor;
        this.unidad = unidad;
        this.ubicacion = ubicacion;
        this.pais = pais;

    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }


}

