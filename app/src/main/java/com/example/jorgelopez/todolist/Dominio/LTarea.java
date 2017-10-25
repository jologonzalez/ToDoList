package com.example.jorgelopez.todolist.Dominio;

import com.example.jorgelopez.todolist.Modelo.Tarea;
import com.example.jorgelopez.todolist.Repositorio.AppDB;

import java.util.List;

/**
 * Created by Jorge Lopez on 5/09/2017.
 */

public class LTarea implements ILTarea {

    private AppDB database;

    public LTarea() {
        database = AppDB.getIntance();
    }

    @Override
    public void addTarea(Tarea tarea) {
        database.getTareaDAO().insert(tarea);
    }

    @Override
    public List<Tarea> getTarea() {
        return database.getTareaDAO().obtenerTodos();
    }

    @Override
    public void actualizar(Tarea... tareas) {
        database.getTareaDAO().update();
    }

    @Override
    public Tarea obtenerXID(int id) {
        return database.getTareaDAO().obtenerXID(id);
    }

}
