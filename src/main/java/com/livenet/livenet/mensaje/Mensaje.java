package com.livenet.livenet.mensaje;


import javax.persistence.*;

@Entity
@Table(name="mensajes")
public class Mensaje {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "remitente", nullable = false)
    private String remitente;

    @Column(name = "destino", nullable = false)
    private String destino;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "fecha_hora", nullable = false)
    private String fecha_hora;

    public Mensaje() {
    }

    public Mensaje(int id, String remitente, String destino, String contenido, String fecha_hora){
        this.id = id;
        this.remitente = remitente;
        this.destino = destino;
        this.contenido = contenido;
        this.fecha_hora = fecha_hora;
    }


    @Override
    public String toString() {
        return "Mensaje{" +
                "remitente='" + remitente + '\'' +
                ", destino='" + destino + '\'' +
                ", contenido='" + contenido + '\'' +
                ", fecha_hora='" + fecha_hora + '\'' +
                '}';
    }
}
