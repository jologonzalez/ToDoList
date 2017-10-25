package com.example.jorgelopez.todolist.Vistas.Presenter;

import com.example.jorgelopez.todolist.Modelo.Tarea;

import java.util.List;

/**
 * Created by Jorge Lopez on 12/09/2017.
 */

public interface IListPresenter {

    void addTarea(String descTarea, String fecha);

    List<Tarea> obtenerTareas();

    void itemCambioEstado(int posicion, boolean realizado);

}
