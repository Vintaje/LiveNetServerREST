package com.livenet.livenet.localizacion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Clase modelo de producto
 */

// Le decimos a Spring que es una Entidad y la tabla.
@Entity
@Table(name = "localizaciones")
public class Localizacion implements Serializable {

    //Necesarios
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id = 0;

    @Column(name = "alias", nullable = false, unique = true)
    private String alias;

    @Column(name = "latitud", nullable = false)
    private float latitud;

    @Column(name = "longitud", nullable = false)
    private float longitud;

    @Column(name = "fecha_hora", nullable = false)
    private Date fechaHora;

    @Column(name = "precision", nullable = false)
    private float precision;


    public Localizacion() {
    }

    public Localizacion(String alias, float latitud, float longitud, Date fechaHora, float precision) {
        this.alias = alias;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fechaHora = fechaHora;
        this.precision = precision;
    }

    public Localizacion(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public float getPrecision() {
        return precision;
    }

    public void setPrecision(float precision) {
        this.precision = precision;
    }

    @Override
    public String toString() {
        return "Localizacion{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", fechaHora=" + fechaHora +
                ", precision=" + precision +
                '}';
    }
}
