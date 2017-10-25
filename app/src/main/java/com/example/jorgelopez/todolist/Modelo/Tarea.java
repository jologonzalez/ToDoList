package com.example.jorgelopez.todolist.Modelo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Jorge Lopez on 5/09/2017.
 */

@Entity(tableName = "Tareas")
public class Tarea {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Nombre")
    private String nombre;

    @ColumnInfo(name = "Fecha")
    private String fecha;

    @ColumnInfo(name = "Realizado")
    private boolean realizado;

    public Tarea() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }
}
