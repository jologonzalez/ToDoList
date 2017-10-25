package com.example.jorgelopez.todolist.Vistas.Presenter;

import com.example.jorgelopez.todolist.Dominio.ILTarea;
import com.example.jorgelopez.todolist.Dominio.LTarea;
import com.example.jorgelopez.todolist.Modelo.Tarea;
import com.example.jorgelopez.todolist.Vistas.IListView;

import java.util.List;

/**
 * Created by Jorge Lopez on 12/09/2017.
 */

public class ListPresenter implements IListPresenter {

    private IListView view;
    private ILTarea lTarea;

    public ListPresenter(IListView view) {
        this.view = view;
        lTarea = new LTarea();
    }

    @Override
    public void addTarea(String descTarea, String fecha) {
        Tarea objTarea = new Tarea();
        objTarea.setNombre(descTarea);
        objTarea.setFecha(fecha);
        objTarea.setRealizado(false);

        lTarea.addTarea(objTarea);

        view.refrescarListaTareas(lTarea.getTarea());
    }

    @Override
    public List<Tarea> obtenerTareas() {
        return lTarea.getTarea();
    }

    @Override
    public void itemCambioEstado(int posicion, boolean realizado) {
        Tarea tarea = lTarea.obtenerXID(posicion + 1);
        tarea.setRealizado(realizado);
        lTarea.actualizar(tarea);
        view.refrescarTarea(tarea, posicion);
    }
}
