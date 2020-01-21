package com.livenet.livenet.sesion;

import javax.persistence.*;

@Entity
@Table(name="sesiones")
public class Sesion {

    @Id
    @Column(name="alias",nullable = false)
    private String alias;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "loggedin", nullable = false)
    private String loggedin;

    @Column(name = "loggedout", nullable = false)
    private String loggedout;


    public Sesion(){}

    public Sesion(String alias, String token, String loggedin, String loggedout){
        this.alias = alias;
        this.token = token;
        this.loggedin = loggedin;
        this.loggedout = loggedout;
    }

    @Override
    public String toString() {
        return "Sesion{" +
                "alias='" + alias + '\'' +
                ", token='" + token + '\'' +
                ", loggedin='" + loggedin + '\'' +
                ", loggedout='" + loggedout + '\'' +
                '}';
    }
}
