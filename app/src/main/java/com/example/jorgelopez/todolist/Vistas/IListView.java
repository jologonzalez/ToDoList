package com.example.jorgelopez.todolist.Vistas;

import com.example.jorgelopez.todolist.Modelo.Tarea;

import java.util.List;

/**
 * Created by Jorge Lopez on 12/09/2017.
 */

public interface IListView {

    void clickAddTarea();

    void refrescarListaTareas(List<Tarea> lsTarea);

    void refrescarTarea(Tarea tarea, int posicion);

}
