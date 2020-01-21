package com.livenet.livenet.localizacion;

import javax.persistence.*;

/**
 * Clase modelo de producto
 */

// Le decimos a Spring que es una Entidad y la tabla.
@Entity
@Table(name = "localizaciones")
public class Localizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "alias", nullable = false,unique = true)
    private String alias;

    @Column(name = "latitud", nullable = false)
    private float latitud;

    @Column(name = "longitud", nullable = false)
    private float longitud;

    @Column(name = "fecha_hora", nullable = false)
    private String fechaHora;


    public Localizacion() {
    }

    public Localizacion(String alias, float latitud, float longitud, String fechaHora) {
        this.alias = alias;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fechaHora = fechaHora;
    }

    public Localizacion(String alias) {

    }


    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }


    @Override
    public String toString() {
        return "Localizacion{" +
                "alias='" + alias + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", fechaHora=" + fechaHora +
                '}';
    }
}
