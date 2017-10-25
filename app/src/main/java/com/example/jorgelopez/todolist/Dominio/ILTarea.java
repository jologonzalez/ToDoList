package com.example.jorgelopez.todolist.Dominio;

import com.example.jorgelopez.todolist.Modelo.Tarea;

import java.util.List;

/**
 * Created by Jorge Lopez on 12/09/2017.
 */

public interface ILTarea {

    void addTarea(Tarea tarea);

    List<Tarea> getTarea();

    void actualizar(Tarea... tareas);

    Tarea obtenerXID(int id);

}
