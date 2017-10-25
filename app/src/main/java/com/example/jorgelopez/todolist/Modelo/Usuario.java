package com.example.jorgelopez.todolist.Modelo;

/**
 * Created by Jorge Lopez on 24/10/2017.
 */

public class Usuario {

    private String Uid;
    private String nombre;
    private String email;

    public Usuario() {
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
